import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        String str = br.readLine();
        boolean isTag = false;
        String answer = "";
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isTag) {
                sb.append(c);
                if (c == '>') {
                    answer += sb.toString();
                    isTag = false;
                    sb = new StringBuffer();
                }
                continue;
            }

            if (c == '<' || c == ' ') {
                answer += sb.reverse().toString();
                sb = new StringBuffer();
                if (c == '<') {
                    isTag = true;
                    sb.append(c);
                }else{
                    answer+=" ";
                }
                continue;
            }

            if(i==str.length()-1){
                answer+=sb.append(c).reverse().toString();
                continue;
            }

            sb.append(c);
        }
        
        // 출력
        System.out.println(answer);
    }
}