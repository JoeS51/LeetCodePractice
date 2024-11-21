class RecentCounter {
    List<Integer> l;
    public RecentCounter() {
        l = new ArrayList<>();
    }
    
    public int ping(int t) {
        int count = 1;
        
        for (int i = l.size() - 1; i >= 0; i--) {
            if (l.get(i) < t - 3000) {
                l = l.subList(i+1, l.size());
                l.add(t);
                return count;
            }
            count++;
        }
        l.add(t);
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */