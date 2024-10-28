/*
M - number of set function calls
N - number of get function calls
L - length of key and value strings

Time complexity = O(L.M.logM)
Space complexity = O(L.M)
*/
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> keyTimeMap;
    
    public TimeMap() {
        keyTimeMap = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new TreeMap<Integer, String>());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        
        Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        // Return searched time's value, if exists.
        if (floorKey != null) {
            return keyTimeMap.get(key).get(floorKey);
        }
        
        return "";
    }
}