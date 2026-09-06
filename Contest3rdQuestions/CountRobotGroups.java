package Contest3rdQuestions;
/*
my errors-
sorted in descending order of speed
did not think that merging of subsequent groups can change previous groups
[230,400] [330,600] [360,300] dist=50
when 1st and 2nd group merge, then this group merges with 1st group so output-1
-thought of stack but couldnt think of time constraint
Input
position =
[61,640,653,863]
speed =
[615,629,454,739]
distance =
222

Use Testcase
Output
1
Expected
2
*/
public class CountRobotGroups {
    public int countGroups(int[] position, int[] speed, int distance) {
        int res = 0, n = speed.length, p2 = Integer.MAX_VALUE, s2 = p2;
        for (int i = n - 1; i >= 0; i--) {
            int p = position[i], s = speed[i];
            if (p2 - p > distance && s <= s2) {
                res += 1;
                s2 = s;
            }
            p2 = p;
        }
        return res;
    }
}
