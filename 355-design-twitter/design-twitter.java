class Twitter {

    private class User {
        public int userId;
        public Tweet tweetHead;
        public Set<Integer> followees;

        public User(int userId) {
            this.userId = userId;
            this.tweetHead = null;
            this.followees = new HashSet<>();
        }
    }

    private class Tweet {
        public int tweetId;
        public long timestamp;
        public Tweet next;

        public Tweet(int tweetId, Tweet next) {
            this.tweetId = tweetId;
            this.next = next;
            this.timestamp = tweetCounter++;
        }
    }

    Map<Integer, User> users;
    long tweetCounter ;

    public Twitter() {
        users = new HashMap<>();
        tweetCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = users.getOrDefault(userId, new User(userId));
        Tweet newTweet = new Tweet(tweetId, user.tweetHead);
        user.tweetHead = newTweet;
        users.put(userId, user);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = users.get(userId);
        List<Integer> response = new ArrayList<>();

        if (user == null) {
            return response;
        }

        PriorityQueue<Tweet> latestFeed = new PriorityQueue<Tweet>((a, b) -> Long.compare(b.timestamp, a.timestamp));
        
        if (user.tweetHead != null) {
            latestFeed.add(user.tweetHead);
        }

        for(Integer followeeId : user.followees) {
            User followee = users.getOrDefault(followeeId, new User(followeeId));
            if (followee.tweetHead != null) {
                latestFeed.add(followee.tweetHead);
            }
        }

        while(!latestFeed.isEmpty() && response.size() < 10) {
            Tweet tweet = latestFeed.poll(); // get and remove

            if (tweet.next != null) {
                latestFeed.add(tweet.next);
            }

            response.add(tweet.tweetId);
        }

        return response;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = users.getOrDefault(followerId, new User(followerId));
        user.followees.add(followeeId);
        users.put(followerId, user);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = users.get(followerId);
        if (user != null) {
            user.followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */