package Ex5;


public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int l = s.length();
        //Define rectangular size
        int unitSize = numRows*2-1;
        Character[][] rec = new Character[numRows][(l/unitSize + 1)*numRows] ;
        
        //Define direction
        // (0,-1) (1,1)
        //Fill rectangular
        int idown = 0;
        int iright;
        int icol = 0;
        for(int i = 0; i<l;){

            //Down
            for(idown = 0;idown < numRows;idown++){
                rec[idown][icol*(numRows-1)] = s.charAt(i);
                // printRec(rec);
                i++;
                if(i>=l) break;
            }
            iright = 1;
            //Right
            // Some Commet here for git test
            for(idown = numRows - 2;i<l && idown > 0;idown--){
                rec[idown][icol*(numRows-1)+iright] = s.charAt(i);
                // printRec(rec);
                iright++;
                i++;
                if(i>=l) break;
            }
            icol++;
        }
        
        //Read and parse return string
        StringBuffer sb = new StringBuffer();
        for (Character[] characters : rec) {
            for (Character c : characters) {
                if(c != null) {
                    sb.append(c);
                }
            }
        }
        // printRec(rec);
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Solution sol = new Solution();
        System.out.println(sol.convert(s,1));
    }

    private void printRec(Character[][] rec){
        for (Character[] characters : rec) {
            for (Character c : characters) {
                if(c == null) {
                    c = ' ';
                }
                System.out.print(c);
            }
            System.out.print("\n");
        }
    }
}
