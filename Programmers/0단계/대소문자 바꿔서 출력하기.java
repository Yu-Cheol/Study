import java.util.Scanner;

/* 대소문자 바꿔서 출력하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder res = new StringBuilder();

        /* 배열을 쓸 땐 .length 뒤에 괄호가 안 붙는다 */
        for(int i = 0; i < str.length(); i++){
            /* .charAt(i) 활용해서 문자열 -> 문자로 변환 */
            char ch = str.charAt(i);

            /* 문자로 변환된 값을 대/소문자 구분하기 위해 적은 if ~ else 문 */
            if(Character.isUpperCase(ch)){ // isUpperCase() 는 해당 문자가 대문자인지 확인시켜주는 메서드
                res.append(Character.toLowerCase(ch));
                // .append 문자열에 문자를 이어붙여 추가해 줌
                // Character.toLowerCase(ch) 는 해당 문자를 소문자로 바꿔주는 메서드 ( 문자열 전체를 소문자로 변환할 거였으면 String.toLowerCase() 를 사용)
            }else{
                res.append(Character.toUpperCase(ch));
            }
        }
        System.out.println(res);
    }
}