import java.io.*;
import java.util.*;

public class Test1915{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int answer=0;

        int[][] DP=new int[N+1][M+1];
        for(int n=1;n<=N;n++){
            String[] line=br.readLine().split("");
            for(int m=1;m<=M;m++)
                DP[n][m]=Integer.parseInt(line[m-1]);
        }
 
        if(N==1){
            boolean check=false;
            for(int m=1; m<=M; m++)
                if(DP[1][m]==1)
                    check=true;
            System.out.println(check?1:0);
            return;
        }

        if(M==1){
            boolean check=false;
            for(int n=1; n<=N; n++)
                if(DP[n][1]==1)
                    check=true;
            System.out.println(check?1:0);
            return;
        }

        for(int n=1;n<=N;n++){
            for(int m=1;m<=M;m++){
                if(n==1&&m==1)
                    continue;
                else if(DP[n][m]>=1){
                    DP[n][m]=Math.min(Math.min(DP[n-1][m],DP[n][m-1]), DP[n-1][m-1])+1;
                    answer=Math.max(answer,DP[n][m]);
                }
            }
        }
        
        System.out.println(answer*answer);
    }
}