package a.leetcode;

import java.util.Arrays;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/implement-strstr/
 **/
public class FindStr {
    public static void main(String[] args) {

        testKmp();

        System.out.println(strStr("abcdabd", "cd") == 2);
        System.out.println(strStr("a", "") == 0);
        System.out.println(strStr("abc", "c") == 2);
        System.out.println(strStr("mississippi", "issip") == 4);
    }

    public static void testKmp() {
        String s1 = "abcdabd";
        int[] test1 = getNext(s1);
        System.out.println(Arrays.equals(test1, new int[]{0, 0, 0, 0, 0, 1, 2}));
        String s3 = "abab";
        int[] test3 = getNext(s3);
        System.out.println(Arrays.equals(test3, new int[]{0, 0, 0, 1}));
        String s2 = "GTGTGCF";
        int[] test2 = getNext(s2);
        System.out.println(Arrays.equals(test2, new int[]{0, 0, 0, 1, 2, 3, 0}));
    }


    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char hayChar = haystack.charAt(i);
            while (j != 0 && hayChar != needle.charAt(j)) {
                j = next[j];
            }
            if (hayChar == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(String needle) {
        char[] chars = needle.toCharArray();
        int[] kmpOrder = new int[chars.length];
        int j = 0;
        for (int i = 2; i < chars.length; i++) {
            while (j != 0 && chars[i - 1] != chars[j]) {
                j = kmpOrder[j];
            }
            if (chars[i-1] == chars[j]) {
                j++;
            }
            kmpOrder[i] = j;
        }
        return kmpOrder;
    }

}
