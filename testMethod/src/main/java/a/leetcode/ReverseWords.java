package a.leetcode;

/**
 * @author Siyuan Li
 * @version 1.0.0
 **/
public class ReverseWords {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));//true
        String s2 = "race a car";
        System.out.println(isPalindrome(s2));//false
    }

    public static boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        int lastIndex = s.length() - 1;
        int index = 0;
        while(lastIndex > index){
            if(!canRun(s.charAt(index))){
                index++;
                continue;
            }
            if(!canRun(s.charAt(lastIndex))){
                lastIndex--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(index)) != Character.toLowerCase(s.charAt(lastIndex))){
                return false;
            }
            index++;
            lastIndex--;
        }
        return true;
    }
    private static boolean canRun(char ch){
        return Character.isDigit(ch) || Character.isLetter(ch);
    }
}
