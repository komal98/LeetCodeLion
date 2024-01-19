class Pair {
    int val;
    int dist;
    public Pair(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Pair> list = new ArrayList<Pair>();
        for(int i=0; i<arr.length; i++) {
            Pair obj = new Pair(arr[i], Math.abs(x-arr[i]));
            list.add(obj);
        }
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                if(o1.dist!=o2.dist) {
                    return Integer.valueOf(o1.dist).compareTo(Integer.valueOf(o2.dist));
                } else {
                    return Integer.valueOf(o1.val).compareTo(Integer.valueOf(o2.val));
                }       
            }
        });
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<k; i++) {
            System.out.println(list.get(i).val+" "+list.get(i).dist);
            result.add(list.get(i).val);
        }
        Collections.sort(result);
        return result;
    }
}