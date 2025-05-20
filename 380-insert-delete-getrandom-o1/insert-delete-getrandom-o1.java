class RandomizedSet {

    List<Integer> list ;
    Map<Integer, Integer> m;
    Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        m = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (m.get(val) != null) {
            return false;
        }

        list.add(val);
        m.put(val, list.size()-1);

        return true;
    }
    
    public boolean remove(int val) {
        if (m.get(val) == null) {
            return false;
        }

        int idxCurrent = m.get(val);
        Collections.swap(list, idxCurrent, list.size()-1);
        m.put(list.get(idxCurrent), idxCurrent);
        m.remove(val);
        list.remove(list.size()-1);

        return true;
    }
    
    public int getRandom() {
        int randIdx = rand.nextInt(list.size());
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */