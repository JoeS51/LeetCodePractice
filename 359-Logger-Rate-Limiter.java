class Logger {
    Map<String, Integer> nextAllowed; 
    public Logger() {
       nextAllowed = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
       if (nextAllowed.containsKey(message) && nextAllowed.get(message) > timestamp) {
        return false;
       } else {
        nextAllowed.put(message, timestamp+10);
        return true;
       }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */