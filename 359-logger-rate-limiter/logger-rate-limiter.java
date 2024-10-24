class Logger {

    Map<String, Integer> messageMap;
    public Logger() {
         messageMap = new HashMap<>();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int allowedTimeStamp = messageMap.getOrDefault(message, timestamp);
        if (allowedTimeStamp > timestamp) {
            return false;
        } else {
            messageMap.put(message, timestamp + 10);
            return true;
        }
    }
}