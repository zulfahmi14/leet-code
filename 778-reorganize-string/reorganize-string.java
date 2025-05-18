class Solution {
    private class Pair {
        int count;
        Character c;

        public Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> m = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        List<Character> ans = new ArrayList<>();
        for(char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character, Integer> entry : m.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }

        while(true) {
            if (pq.isEmpty()) break;
            else if (pq.size() == 1) {
                Pair data = pq.poll();

                if (data.count == 1) {
                    ans.add(data.c);
                } else {
                    return "";
                }
            } else {
                Pair data1 = pq.poll();
                Pair data2 = pq.poll();
                int nextCount = 0;

                if (pq.size() > 0) {
                    nextCount = pq.peek().count;
                }

                while(data2.count > 0 && data2.count >= nextCount) {
                    ans.add(data1.c); ans.add(data2.c);
                    data1.count--; data2.count--;
                }

                if (data1.count > 0) {
                    pq.add(data1);
                }

                if (data2.count > 0) {
                    pq.add(data2);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        ans.forEach(sb::append);
        return sb.toString();
    }
}