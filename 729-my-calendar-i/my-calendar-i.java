class MyCalendar {

    TreeMap<Integer ,Integer> booked ;

    public MyCalendar() {
        this.booked = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer floor = booked.floorKey(startTime);
        Integer ceil = booked.ceilingKey(startTime);

        if((floor == null || booked.get(floor) <= startTime) && (ceil == null || ceil >= endTime)) {
            booked.put(startTime, endTime);
            return true;
        }

        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */