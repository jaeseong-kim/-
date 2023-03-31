
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[][] apt=new int[15][15];

        for(int i=0;i<apt.length;i++){
            for(int j=1;j<apt[i].length;j++){
                if(i==0 || j==1){
                    apt[i][j]=j;
                }else{
                    apt[i][j]=apt[i][j-1]+apt[i-1][j];
                }
            }
        }

        int caseNum=Integer.parseInt(br.readLine());
        while(caseNum>0){
            int k=Integer.parseInt(br.readLine());
            int n=Integer.parseInt(br.readLine());

            System.out.println(apt[k][n]);
            
            caseNum--;
        }
    }
}