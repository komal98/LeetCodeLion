class Solution {
    class Pair{
        int freq;
        char ch;

        Pair(int freq, char ch){
            this.freq = freq;
            this.ch = ch;
        }
    }
    public String reorganizeString(String s) {
            int[] charCounts = new int[26];
            int n = s.length();

            //add charCounts of each char
            for(int i = 0; i<n; i++){
                charCounts[s.charAt(i) - 'a']++;
                if(charCounts[s.charAt(i)-'a']>(n+1)/2){
                    return "";
                }
            }

            //add in priorityqueue
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.freq - a.freq);
            for(int i =0; i<26; i++){
                if(charCounts[i]!=0){
                    maxHeap.offer(new Pair(charCounts[i], (char) (i+'a')));
                }
            }

            //construct string
            StringBuilder ans = new StringBuilder();
            while(maxHeap.size()>=2){
                //remove top two most occuring chars
                Pair e1 = maxHeap.poll();
                Pair e2 = maxHeap.poll();

                //add each in string
                ans.append(e1.ch);
                ans.append(e2.ch);

                //update the maxHeap
                if(e1.freq>1){
                    maxHeap.offer(new Pair(e1.freq-1,e1.ch));
                }
                 if(e2.freq>1){
                    maxHeap.offer(new Pair(e2.freq-1,e2.ch));
                }

            }

            //add remaining chars to ans
            if(!maxHeap.isEmpty()){
                ans.append(maxHeap.poll().ch);
            }

            return ans.toString();
    }
}