import java.io.*;
import java.util.*;

public class Test9184 {
    static int[][][] dp=new int[21][21][21];
    static int[] input=new int[3];

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int i=0;i<3;i++)
                input[i]=Integer.parseInt(st.nextToken());

            String template="w("+input[0]+", "+input[1]+", "+input[2]+") = ";

            if(input[0]==-1&&input[1]==-1&&input[2]==-1)
                break;

            System.out.println(template+w(input[0],input[1],input[2]));
        }
    }

    private static int w(int a,int b,int c){
        if(a>0&&a<=20&&b>0&&b<=20&&c>0&&c<=20)
            if(dp[a][b][c]!=0)
                return dp[a][b][c];
                
        if(a<=0||b<=0||c<=0)
            return 1;
        if(a>20||b>20||c>20)
            return dp[20][20][20]=w(20,20,20);
        if(a<b&&b<c)
            return dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        return dp[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
    }
}
