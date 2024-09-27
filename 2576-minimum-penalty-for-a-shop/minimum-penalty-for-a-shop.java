/*
Find the best hour when it is still open
minimizing penalty = maximizing profiy
so loop through the strig at evry hour when the 
customer is present our profit increases
customer is absent -1
at the point where we get max profit is also where we get min penalty
*/
public class Solution {
    public int bestClosingTime(String customers) {
        int max_score = 0, score = 0, best_hour = -1;
        for(int i = 0; i < customers.length(); ++i) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if(score > max_score) {
                max_score = score;
                best_hour = i;
            }
        }
        return best_hour + 1;
    }
}