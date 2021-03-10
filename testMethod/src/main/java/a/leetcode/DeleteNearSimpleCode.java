package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 **/
public class DeleteNearSimpleCode {
    public static void main(String[] args) {
        String s1 = "abbaca";
        String r1 = "ca";
        System.out.println(r1.equals(removeDuplicates(s1)));
        String s2 = "abbbaca";
        String r2 = "baca";
        System.out.println(r2.equals(removeDuplicates(s2)));
    }

    public static String removeDuplicates(String S) {
        StringBuffer sb = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top>=0 && sb.charAt(top) == S.charAt(i)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(S.charAt(i));
                top++;
            }
        }
        return sb.toString();
    }
}
