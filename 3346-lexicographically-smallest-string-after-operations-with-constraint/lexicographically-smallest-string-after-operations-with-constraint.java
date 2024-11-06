class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder res = new StringBuilder("");
        if(k==0) return s;
        char chars[] = s.toCharArray();
        int start = 0;
        while(k>0 && start<s.length()){
            int diff = (chars[start++] - 'a');
            int min = Math.min(diff, 26-diff);
            if(min<=k){
                res.append('a');
                k-=min;
            }else{
                diff -=k;
                res.append((char)(diff+'a'));
                break;
            }
        }

        while(start<s.length()){
            res.append(chars[start++]);
        }

        return res.toString();
        
    }
}
/*
zbbz
aaaz
edge case identified
if my first char is within reach from a and under k do that
same for second char
till k is not zero

zbbz
%26 + 1 is the distance of each char from a
a b c d e f g h i j k l m n o p q r s t u v x y z
int distance from a -> [0 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1] //identify this pattern
if distance is greater than 12 then we have to do mod(0-26)%26+1
if distance is less than  equal to 12 then take that distance as is mod(0-9)
z -> distance from a is 1, k = 2
b -> distance from a is 1, k = 1
b -> distance from a is 1, k = 1
*/