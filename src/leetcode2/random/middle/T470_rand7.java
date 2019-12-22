package leetcode2.random.middle;

public class T470_rand7 extends SolBase {

    private static int rand10() {
        int x = (rand7()-1)*7 + (rand7()-1);
        while(x>=40){//0-49区间相同概率
            x = (rand7()-1)*7 + (rand7()-1);
        }
        return x%10+1;
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.print(rand10()+ " ");
        }
    }
}
