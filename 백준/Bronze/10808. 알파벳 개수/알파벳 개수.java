import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int[] alphabet = new int[26];

        // 알파벳 개수 카운트
        for (int i = 0; i < input.length; i++) {
            alphabet[input[i] - 'a']++;
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
        }

        // 출력
        System.out.println(sb);
    }
}