package Ex5;


public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1){return s;}
        int maxLeft = 0;
        int maxRight = 0;
        int max = 0;
        int arm = 1;
        
        String joint = String.join("-", s.split(""));
        for(int i = 1; i < joint.length()-1; i+=arm){
            arm = 1;
            int left = i-1;
            int right = i+1;
            while(left >= 0 && right < joint.length() && joint.charAt(left) == joint.charAt(right)){
                    int len = joint.substring(left, right+1).replace("-", "").length();
                    if(len > max){
                        max = len;
                        maxLeft = left;
                        maxRight = right;
                    }
                    arm++;
                    left--;
                    right++;
            }
        }
        if(maxLeft==maxRight){
            return joint.substring(maxLeft, maxLeft+1);
        }
        return joint.substring(maxLeft, maxRight+1).replace("-", "");
    }

    public static void main(String[] args) {
        String s = "abb";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(s));
    }
}
