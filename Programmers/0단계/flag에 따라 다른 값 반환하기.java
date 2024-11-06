import java.util.Scanner;

/* flag에 따라 다른 값 반환하기 */
public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        Boolean flag = scan.nextBoolean();

        System.out.println(s.solution(a, b, flag));
    }
}

class Solution {
    public int solution(int a, int b, boolean flag) {

        return flag ? a + b : a - b;
    }
}