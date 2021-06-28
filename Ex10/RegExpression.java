package Ex10;

public class RegExpression{
    public static void main(String[] args) {
        String s = "abcd";
        String p = "abcd";
        System.out.println(reg(s, p));
    }

    public static boolean reg(String s, String p) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == p.charAt(j)){
                j++;
            }
        }
        return true;
    }

    
}