import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String str = br.readLine();

        // 크로아티아 알파벳
        String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 크로아티아 알파벳 개수 구하기
        int cnt = 0;
        for (int i = 0; i < alphabet.length; i++) {
            while (str.contains(alphabet[i])) {
                str = str.replaceFirst(alphabet[i], " ");
                cnt = cnt + 1;
            }
        }

        // 나머지 알파벳 개수 더하기
        cnt = cnt + str.replaceAll(" ", "").length();

        // 출력
        System.out.println(cnt);
    }
}