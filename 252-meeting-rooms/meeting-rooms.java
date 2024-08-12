class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (m1,m2) -> Integer.compare(m1[0],m2[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;

    }
}