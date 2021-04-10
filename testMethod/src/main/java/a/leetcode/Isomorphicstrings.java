package a.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siyuan Li
 * @version 1.0.0
 * @Description https://leetcode-cn.com/problems/isomorphic-strings/
 **/
public class Isomorphicstrings {
    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        System.out.println(isIsomorphic(s1, t1));//true
        String s = "foo", t = "bar";
        System.out.println(isIsomorphic(s, t));//false
        String s2 = "paper", t2 = "title";
        System.out.println(isIsomorphic(s2, t2));//true
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            boolean t1NoPair = s2t.containsKey(s1) && s2t.get(s1) != t1;
            boolean s1NoPair = t2s.containsKey(t1) && t2s.get(t1)!= s1;
            if(t1NoPair || s1NoPair) return false;
            s2t.put(s1,t1);
            t2s.put(t1,s1);
        }
        return true;
    }

}
