package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/length-of-last-word/
 **/
public class FindLengthOfLastWord {
    public static void main(String[] args) {
        String s1 = "Hello World";
        int r1 = 5;
        System.out.println(lengthOfLastWord(s1)==r1);
        String s2 = "  ";
        int r2 = 0;
        System.out.println(lengthOfLastWord(s2)==r2);
        String s3 = "a ";
        int r3 = 1;
        System.out.println(lengthOfLastWord(s3)==r3);
    }
    public static int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && len > 0) return len;
            if(s.charAt(i) != ' '){
                len++;
            }
        }
        return len;
    }
    public static int lengthOfLastWord2(String s) {
        int len = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                len = 0;
            }else{
                len++;
            }
        }
        return len;
    }
}
