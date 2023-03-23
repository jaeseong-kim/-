import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int size = str2.length();
        int cnt = 0;
        
        for (int i = 0; i < str1.length(); i++) {

            if (i + size <= str1.length()) {
                String subStr1 = str1.substring(i, i + size);
                if (subStr1.equals(str2)) {
                    i = (i + size) - 1;
                    cnt++;
                }
            }
        }
        
        //답
        System.out.println(cnt);
    }
}