/*
    String은 값이 바뀔 때마다 새로운 객체를 생성하기 때문에 메모리 초과가 발생한다.
    StringBuffer, StringBuilder에 처음부터 문자열 값을 다 넣어놓고 문자열 폭탄을 제거하는 방식으로 풀면 시간초과가 난다.
    remove()나 substring()을 하면 시간이 오래 걸리기 때문이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        int bombLength = bomb.length();

        for (int i = 0; i < str.length(); i++) {

            // 문자열 넣기
            sb.append(str.charAt(i));

            // 폭탄 문자열보다 길어지면 sb 검사
            if (sb.length() >= bombLength) {
                boolean sameFlag = true;
                for (int j = 0; j < bombLength; j++) {
                    char c1 = sb.charAt(sb.length() - bombLength + j);
                    char c2 = bomb.charAt(j);
                    if (c1 != c2) {
                        sameFlag = false;
                        break;
                    }
                }

                if (sameFlag) {
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }
        }

        // 출력
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}