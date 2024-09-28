class Solution {
    HashMap<String, HashMap<String, Double>> connections;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        connections = new HashMap<>();
        double[] answer = new double[queries.size()];

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            List<String> equationActors = equations.get(i);
            String A = equationActors.get(0);
            String B = equationActors.get(1);
            double value = values[i];

            connections.putIfAbsent(A, new HashMap<>());
            connections.putIfAbsent(B, new HashMap<>());
            connections.get(A).put(B, value);
            connections.get(B).put(A, 1.0 / value);
        }

        // Evaluate each query
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String C = query.get(0);
            String D = query.get(1);
            answer[i] = evaluateDivision(C, D, new HashSet<>());
        }

        return answer;
    }

    private double evaluateDivision(String numerator, String denominator, Set<String> visited) {
        // If either variable is not in the graph or they are the same
        if (!connections.containsKey(numerator) || !connections.containsKey(denominator)) {
            return -1.0;
        }
        if (numerator.equals(denominator)) {
            return 1.0;
        }

        visited.add(numerator);

        // Explore the neighbors
        for (Map.Entry<String, Double> entry : connections.get(numerator).entrySet()) {
            String neighbor = entry.getKey();
            double value = entry.getValue();

            // Avoid cycles
            if (!visited.contains(neighbor)) {
                double result = evaluateDivision(neighbor, denominator, visited);
                if (result != -1.0) {
                    return value * result;
                }
            }
        }

        visited.remove(numerator); // Backtrack
        return -1.0;
    }
}
