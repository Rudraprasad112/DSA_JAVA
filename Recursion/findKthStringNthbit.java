package Recursion;

public class findKthStringNthbit {
    public static void main(String[] args) {
                    // Given two positive integers n and k, the binary string Sn is formed as follows:
                // 
            // S1 = "0"
            // Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
            // Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
                // 
            // For example, the first four strings in the above sequence are:
                // 
            // S1 = "0"
            // S2 = "011"
            // S3 = "0111001"
            // S4 = "011100110110001"
            // Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
                // 
                // 
                // 
            // Example 1:
                // 
            // Input: n = 3, k = 1
            // Output: "0"
            // Explanation: S3 is "0111001".
            // The 1st bit is "0".
            // Example 2:
                // 
            // Input: n = 4, k = 11
            // Output: "1"
            // Explanation: S4 is "011100110110001".
            // The 11th bit is "1".

        // this probelm i solve O(n)time and O(n)space

        // why use recursion 
            //clearly states that (Si = Si - 1) in the question
        int n = 3;int k = 5;

        char ch = helper(n, k);

        System.out.println(ch);

    }

    public static char helper(int n,int k){
        
        if(k == 1) return '0';

        int len = (1 << n) - 1;// find the length of current string length

        if(k < Math.ceil(len /2.0)){// find the left side of string

            return helper(n-1, k);

        }else if(k == Math.ceil(len /2.0)){

            return '1';// bliendly return 1 because middle part 1001 + (1) + 0110

        }else{// search right part and right part is just revesrsed part of left part

            // find the reverse and complement of string n=bit 

            char ch = helper(n-1, len -(k-1));

            return ch == '0'?'1':'0';
        }

    }

}
