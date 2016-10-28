package Strings;

import java.util.Stack;

/**
 * ** O(n) Time Complexity Solution**
 * Given a string, find minimum number of cuts required so that every substring formed is a palindrome
 * Created by SwapnilSudam on 10/27/2016.
 */
public class PalindromePartition {
    Stack<Integer> stack;
    int size;
    String st;
    PalindromePartition(String s){
        st=s;
        stack = new Stack<Integer>();
    }
    int fun(){
        for(int i=1;i<st.length();i++){
            if(stack.size()==0){
                if(st.charAt(0)==st.charAt(i))
                    continue;
                else{
                    stack.add(i);
                }
            }
            else if(st.charAt(stack.peek())==st.charAt(i)){
                continue;
            }
            else if(st.charAt(stack.peek()-1)==st.charAt(i)){
                stack.pop();
            }
            else {
                stack.add(i);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        String s = "abcacb";
        PalindromePartition obj = new PalindromePartition(s);
        System.out.println("Minimum partitions required for string "+s+" are "+obj.fun());
    }

}
