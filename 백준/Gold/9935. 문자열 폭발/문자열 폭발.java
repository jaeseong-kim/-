import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            // 문자열 넣기
            sb.append(str.charAt(i));

            // 폭탄 문자열보다 길어지면 sb 검사
            if (sb.length() >= bomb.length()) {
                boolean sameFlag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    char c1 = sb.charAt(sb.length() - bomb.length() + j);
                    char c2 = bomb.charAt(j);
                    if (c1 != c2) {
                        sameFlag = false;
                        break;
                    }
                }

                if (sameFlag) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
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