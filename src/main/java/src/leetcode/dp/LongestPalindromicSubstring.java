package src.leetcode.dp;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bababd"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s==null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len-1)/2);
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int expandFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
