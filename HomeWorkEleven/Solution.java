package HomeWorkEleven;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public char irstUniqChar(String s){
        Deque<Character> deque=new ArrayDeque<>();
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int a=ch-'a';
            count[a]++;
            if(count[a]==1){
                deque.add(ch);
            }
        }
        char c= ' ';
        while(deque.size()>0){
            char ch=deque.peek();
            int a=ch-'a';
            if(count[a]==1){
                c=ch;
                break;
            }else{
                deque.pop();
            }
        }
        return c;
    }
}
