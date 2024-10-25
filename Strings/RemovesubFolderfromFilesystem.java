package Strings;

import java.util.*;

public class RemovesubFolderfromFilesystem {
    public static void main(String[] args) {
        String folder[] = { "/a","/a/b/c","/a/b/d" };
        List<String> ans = removeSubfolders(folder);
        List<String> ans2 = removeSubfoldersSpaceOptimized(folder);
       
        for(String s:ans){

            System.out.println(s);
        }
        System.out.println("---------------------------------------");
        for(String s:ans2){

            System.out.println(s);
        }
        
    }

    public static List<String> removeSubfolders(String[] folder) {

        Set<String> st = new HashSet<>();

        for (String s : folder) {

            st.add(s);

        }
        for (String s : folder) {

            boolean isFound = false;

            String curr = s;

            for (int i = s.length() - 1; i >= 0; i--) {

                if (s.charAt(i) == '/') {

                    String sub = s.substring(0, i);

                    
                    if (st.contains(sub)) {

                        st.remove(curr);

                        isFound = true;

                        break;

                    }else{

                        s = sub;
                    }

                }
            }

        }

        List<String> list = new ArrayList<>(st);

        return list;
    }
    public static  List<String> removeSubfoldersSpaceOptimized(String[] folder) {
        
        Arrays.sort(folder);

        List<String> ans = new ArrayList<>();

        ans.add(folder[0]);

        for(int i = 1 ; i < folder.length; i++){// O(n) 

            String curr = folder[i];

            if(curr.startsWith(ans.get(ans.size() -1) + "/") == false){// )(m) traverse a char by char and cheack equal of not

                ans.add(curr);
            }
        }
        // overal time complexity is O(n long + n * m)

        return ans;
    }
}
