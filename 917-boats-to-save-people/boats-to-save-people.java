class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length == 0) return 0;
        if(people.length == 1) return 1;
        Arrays.sort(people);
        
        int boats = 0;

        int left = 0;
        int right = people.length-1;

        while(left<=right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boats++;
                left++;
                right--;
            }
            else{
                boats++;
                right--;
            }
        }
        return boats;
    }
}

/*
Array of people
Infinite number of boats
each boat can carry max weight limit
each boat carries at most two people at the same time <= limit

OUTPUT: Minimum number of boats to carry every given person

Two Pointer

[3,2,2,1] 
sort
[1,2,2,3]
1+3> limit boats = 1
1+2<= limit boats = 2
2

*/