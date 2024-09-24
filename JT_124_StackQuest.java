import java.util.Stack;

public class JT_124_StackQuest {
//    Q1) Balanced Brackets

    // My approach Iterative (Not an correct method) this method only tells no. of '(' & ')' in String
    // Cant check the balanced brackets
    // Better way is to use stack
    static boolean balanceBracket(String str){
        if(str.length()%2!=0){
            return false;
        }
        int opn =0;
        int cls =0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)=='(')opn++;
            else cls++;
        }
        if(opn!=cls)return false;
        else return true;
    }
    static boolean normalApproachParenthesis(String str){
        int x = 0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)=='('){
                x++;
            }
            else{
                x--;
            }
            if(x<0){
                return false;
            }
        }
        if(x==0)return true;
        else{
            return false ;
        }
    }
    // Using Stack
    static boolean balanceBracketStack(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if(st.size()==0){
                    return false;
                }
               else if(st.peek()=='(')st.pop();
            }
        }
        if(st.empty())return true;
        else return false;
    }
//Q2) (LEETCODE) 20. Valid Parentheses
    static boolean validParenthesis(String str){
        Stack<Character> st = new Stack<>();
        for(int i =0;i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    return false;
                }
                else if(st.peek()=='(' && ch == ')'   ){
                    st.pop();
                }
                else if(st.peek()=='[' && ch == ']'){
                    st.pop();
                }
                else if(st.peek()=='{' && ch == '}'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.empty())return true;
        else{
            return false;
        }
    }
//    Q3) Find the minimum number of brackets we need to remove to make the bracket sequence balanced
    static void countUnbalanceBracket(String str){
        Stack<Character> st = new Stack<>();
        int removal = 0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)=='('){
                st.push(str.charAt(i));
            }
            else{
                 if (!st.empty()&&st.peek()=='(') {
                    st.pop();
                }
                else{
                    removal++;
                }
            }
        }
        System.out.println(removal+st.size());
    }
    public static void main(String[] args) {
    String str = "(()()(";//false
    String str1 = ")()())";//false
    String str2 = ")(())()";//false
    String str3 = "(()())";// true
        String str4 = "(())";//true
        String str5 = "(()()))(()"; // very important i.e if ( & ) are in equal quantity then not necessary it is balanced
        String str6 = "())())";// false

//    System.out.println(balanceBracket(str5));// Not for to check balanced bracket
//        System.out.println(balanceBracketStack(str));
//        System.out.println(normalApproachParenthesis(str));

        String str7 = "([)]";
        String str8 = "()[]{}(]";
//        System.out.println(validParenthesis(str8));
        countUnbalanceBracket("()(())(()))");
    }
}
