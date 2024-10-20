// Helper class to represent a visit
   class Tuple {
        String username;
        int timestamp;
        String website;

        Tuple(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Step 1: Group visits by user
        Map<String, List<String>> userVisits = new HashMap<>();
        int n = username.length;

        // Create a list of tuples and sort them by timestamp
        List<Tuple> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new Tuple(username[i], timestamp[i], website[i]));
        }
        visits.sort(Comparator.comparingInt(t -> t.timestamp));

        // Fill userVisits map
        for (Tuple visit : visits) {
            userVisits.putIfAbsent(visit.username, new ArrayList<>());
            userVisits.get(visit.username).add(visit.website);
        }

        // Step 2: Count patterns
        Map<String, Set<String>> patternCount = new HashMap<>();
        
        for (String user : userVisits.keySet()) {
            List<String> sites = userVisits.get(user);
            int size = sites.size();

            // Generate all patterns of 3 websites
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String pattern = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);
                        patternCount.putIfAbsent(pattern, new HashSet<>());
                        patternCount.get(pattern).add(user);
                    }
                }
            }
        }

        // Step 3: Find the best pattern
        String bestPattern = null;
        int maxScore = 0;

        for (Map.Entry<String, Set<String>> entry : patternCount.entrySet()) {
            String pattern = entry.getKey();
            int score = entry.getValue().size();

            // Update the best pattern based on score and lexicographical order
            if (score > maxScore || (score == maxScore && (bestPattern == null || pattern.compareTo(bestPattern) < 0))) {
                maxScore = score;
                bestPattern = pattern;
            }
        }

        // Return the best pattern as a List of Strings
        return bestPattern != null ? Arrays.asList(bestPattern.split(",")) : new ArrayList<>();
    }
}