public class AddParantehics {
    
    public static void main(String[] args) {
        String s = "())";
        
        int ans = minAddToMakeValid(s);

        System.out.println(ans);
    }
    public static int minAddToMakeValid(String s) {

        int n = s.length();

        if(n == 0) return 0;// empty string

        //using stagck

        int add = 0;

        int open_par = 0;

        for(int i = 0 ; i < n ; i++){

            char ch = s.charAt(i);

            if(ch == '('){

                open_par++;

            }else if(open_par > 0){

                open_par--;// delete valid paranthics 

            }else if(open_par <= 0){//my stack is empty

                add++;//add fornt of open Parentheses 

            }
        }

        return open_par + add;
    }
}
