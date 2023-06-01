import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuffer sb = new StringBuffer(str);
        String[] suffix = new String[str.length()];
        
        // 접미사 배열 구하기
        suffix[0] = sb.toString();
        for (int i = 1; i < str.length(); i++) {
            suffix[i] = sb.deleteCharAt(0).toString();
        }
        
        // 사전 순 정렬
        Arrays.sort(suffix);
        
        // 출력
        for (int i = 0; i < suffix.length; i++) {
            System.out.println(suffix[i]);
        }
    }
}