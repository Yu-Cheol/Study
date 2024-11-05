import java.util.Scanner;

/* 조건 문자열 */
public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        Scanner scan = new Scanner(System.in);

        String ineq = scan.nextLine();
        String eq = scan.nextLine();
        int n = scan.nextInt();
        int m = scan.nextInt();

        int res = s.solution(ineq, eq, n ,m);

        System.out.println(res);

    }
}

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if(ineq.equals(">")){
            if(eq.equals("=")){
                answer = n >= m ? 1 : 0;
            }else{
                answer = n > m ? 1 : 0;
            }
        }else if(ineq.equals("<")){
            if(eq.equals("=")){
                answer = n <= m ? 1 : 0;
            }else{
                answer = n < m ? 1 : 0;
            }
        }
        return answer;
    }
}