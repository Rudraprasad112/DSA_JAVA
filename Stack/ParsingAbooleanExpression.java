import java.util.*;
public class ParsingAbooleanExpression {


    public static void main(String[] args) {
        // in this problem gives a expression string contians 't' ,'f','&','|','!','(',')'
        //example -:
            //expression = "&(|(f))"

        String expression = "|(f,f,|(f,t),f)";

        boolean ans = parseBoolExpr(expression);
        System.out.println(ans);
        
    }
    public static  boolean parseBoolExpr(String expression) {
        
        Stack<Character> st = new Stack<>();

        for(char ch : expression.toCharArray()){

            if(ch == '(' || ch == ','){

                continue;

            } if( ch == 't' || ch == 'f' ||  ch == '&' || ch == '|' || ch == '!'){

                st.push(ch);

            }else if(ch == ')'){// close bracket

                boolean truePresent = false; boolean falsePresent = false;

                while(st.peek() != '&' && st.peek() != '|' && st.peek() != '!'){
                    
                    char top = st.pop();

                    if(top == 't'){

                        truePresent = true;

                    }else{

                        falsePresent = true;

                    }

                }// complete count of true and false;

                char operater = st.pop();

                if(operater == '&'){

                    char pu = falsePresent ? 'f' : 't';

                    st.push(pu);

                }else if(operater == '|'){

                    char pu = truePresent ? 't': 'f';

                    st.push(pu);

                }else{// obously !

                    char pu = truePresent ? 'f': 't';

                    st.push(pu);

                }
            }

        }
        return st.peek() == 't'? true:false;
    }
}
