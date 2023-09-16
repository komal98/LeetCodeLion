class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        //0 -flowers start blooming
        //1 -person arrives
        //2 - flower stops blooming

        //[type of event, time of event]
        PriorityQueue<int[]> events = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] event1, int[] event2){
                if(event1[1]!=event2[1]){
                    return event1[1] - event2[1];
                }
                return event1[0] - event2[0];
            }
        });

        //add events in the priority queue
        for(int[]flower : flowers){
            events.offer(new int[]{0,flower[0]});
            events.offer(new int[]{2,flower[1]});
        }

        //add people
        for(int i = 0; i<people.length; i++){
            events.offer(new int[]{1,people[i],i});
        }

        //process events track the number of blooming flowers
        int[] ans = new int[people.length];
        int numOfFlowersBlooming = 0;
        while(!events.isEmpty()){
            int[] event = events.poll();
            if(0 == event[0]){//flower starts blooimg
                numOfFlowersBlooming++;
            }else if(2 == event[0]){
                numOfFlowersBlooming--;
            }else{
                ans[event[2]] = numOfFlowersBlooming;
            }
        }
        return ans;
    }
}