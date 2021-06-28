package Ex5;


public class Solution {
    public String convert(String s, int numRows) {
        int l = s.length();
        //Define rectangular size
        int unitSize = numRows*2-1;
        Character[][] rec = new Character[numRows][(l/unitSize + 1)*numRows] ;
        
        //Define direction
        // (0,-1) (1,1)
        //Fill rectangular
        int idown = 0;
        int iright = 0;
        for(int i = 0; i<l;){

            //Down
            for(idown = 0;idown < numRows-1;idown++){
                rec[idown][iright] = s.charAt(i);
                printRec(rec);

                i++;
                if(i>=l) break;
            }
            //Right
            for(idown = numRows - 1;i<l && idown > 0;idown--){
                rec[idown][iright] = s.charAt(i);
                printRec(rec);

                iright++;
                i++;
                if(i>=l) break;
            }
        }
        //Read and parse return string

        
        return "";
    }
    public static void main(String[] args) {
        String s = "HaveANiceDay!";
        Solution sol = new Solution();
        System.out.println(sol.convert(s,4));
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
