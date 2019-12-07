package swordToOffer3;

public class T51_multiply {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * */
    public static int[] multiply(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i=1; i<B.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int tmp = 1;
        for (int i=B.length-2; i>=0; i--) {
            tmp = tmp * A[i+1];
            B[i] = B[i] * tmp;
        }
        return B;
    }
}
