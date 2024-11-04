import java.util.Scanner;

/* 더 크게 합치기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        int j = scan.nextInt();

        int ij = Integer.parseInt(""+i+j); // "" 로 문자열로 변환 후 Integer.parseInt()로 다시 정수로 변환
        int ji = Integer.parseInt(""+j+i);

        int res =  0;
        res = Math.max(ij, ji); // Math.max() 를 이용해서 ij 와 ji 중 더 큰 값을 res 에 저장

        /* 삼항 연산자 */
//      res = ij > ji ? ij : ji; // ij 가 ji 보다 크면 ij 실행 ji가 크면 ji 실행

        System.out.println(res);
    }
}