import java.util.Arrays;


public class MinimumNumberofPushestoTypeWordII {

    public int minimumPushes(String word) {

        final int[] m = new int[26];

        for (final char ch : word.toCharArray()) {
            m[ch - 'a']++;
        }
        Arrays.sort(m);

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += m[26 - i - 1] * (i / 8 + 1);
        }
        return res;
    }

}
