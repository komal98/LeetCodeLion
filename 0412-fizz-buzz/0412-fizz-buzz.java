class Solution {
    public List<String> fizzBuzz(int n) {
        String fizzbuzz = "FizzBuzz";
        String fizz = "Fizz";
        String buzz = "Buzz";

        List<String> sol = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            if(i%3==0 && i%5==0){
               sol.add(fizzbuzz);
            }
            else if(i%3==0){
                sol.add(fizz);
            }
            else if(i%5==0){
                sol.add(buzz);
            }
            else{
                sol.add(Integer.toString(i));
            }
        }
        return sol;
    }
}