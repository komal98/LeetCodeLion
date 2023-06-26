class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1) return 1;
        int i = 1;
        while(i < arr.length && arr[i - 1] == arr[i]) i++;
        if(i == arr.length) return 1;
        int maxTurb = 2;
        int turb = maxTurb;
        for(i = 1; i < arr.length - 1; i++) {
            int prev = i - 1;
            int current = i;
            int next = i + 1;
            if((arr[prev] < arr[current] && arr[current] > arr[next])
            || (arr[prev] > arr[current] && arr[current] < arr[next])) {
                turb++;
                if(turb > maxTurb) {
                    maxTurb = turb;
                }
            } else {
                turb = 2;
            }
        }
        return maxTurb;
    }
}