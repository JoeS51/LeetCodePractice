class HitCounter {
    Deque<Integer> d;

    public HitCounter() {
        d = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        d.add(timestamp);
        while (d.size() > 0 && d.getFirst() <= timestamp - 300) {
            d.removeFirst();
        }
    }
    
    public int getHits(int timestamp) {
        while(d.size() > 0 && d.getFirst() <= timestamp - 300) {
            d.removeFirst();
        }
        return d.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */