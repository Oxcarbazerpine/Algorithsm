package smart;

import java.util.Arrays;

public class ArrangeQuantityPlan {
    public static void main(String[] args) {
        int[] f = {5, 0, 4, 0,10,6};
        int[] a = {5, 4, 0, 0,5,6};

        System.out.println(Arrays.toString(getArrangeQtys(f, a)));
    }

    public static int[] getArrangeQtys(int[] forcastQtys, int[] acceptRemainQtys) {
        int monthNum = 6;

        int[] arrangeQtys = new int[monthNum];
        for (int i = 0; i < monthNum; i++) {
            int fIdx = i;
            int acceptRemain = acceptRemainQtys[i] - forcastQtys[fIdx];
            if (acceptRemain > 0) {

                do {
                    fIdx++;
                    acceptRemain = acceptRemain - forcastQtys[fIdx];
                } while (fIdx < monthNum && acceptRemain > 0);

                forcastQtys[fIdx] = acceptRemain < 0 ? -acceptRemain : 0;
            } else {

            }
            arrangeQtys[i] = Math.max(acceptRemainQtys[i], forcastQtys[i]);
        }

        return arrangeQtys;
    }
}
