package Contest3rdQuestions;
/*
In a string aabbbccdd
the difference between first occurrence of an element and the last occurrence of another element is always maximum
*/
public class MaximumGapBetweenStations {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();
        if (n == 1)
            return 0;
        int start[] = new int[n];
        int end[] = new int[n];
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
            if (skill.charAt(i) == station.charAt(j)) {
                start[i] = j;
                i--;
            }
            j--;
        }
        i = 0;
        j = 0;
        while (i < n && j < m) {
            if (skill.charAt(i) == station.charAt(j)) {
                end[i] = j;
                i++;
            }
            j++;
        }
        int max = 0;
        for (int x = 0; x < n - 1; x++) {
            max = Math.max(max, start[x+1] - end[x]);
        }
        return max;

    }
}
