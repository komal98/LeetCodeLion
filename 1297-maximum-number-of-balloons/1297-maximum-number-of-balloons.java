class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for( char c : text.toCharArray()){
            switch(c){
                case 'b' : b++;
                break;
                
                case 'a' : a++;
                break;

                case 'l' : l++;
                break;

                case 'o' : o++;
                break;

                case 'n' : n++;
                break;
            }
        }
       return Math.min(Math.min(Math.min(b,a),n), Math.min(l/2,o/2)); 
    }
}
/*
b - 1
a - 1
l - 2
o - 2
n - 1
*/