import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1309{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] DP=new int[N+1][3];
        int answer=0;

        Arrays.fill(DP[1],1);

        for(int i=2;i<=N;i++){
            DP[i][0]=(DP[i-1][0]+DP[i-1][1]+DP[i-1][2])%9901;
            DP[i][1]=(DP[i-1][0]+DP[i-1][2])%9901;
            DP[i][2]=(DP[i-1][0]+DP[i-1][1])%9901;
        }

        for(int val:DP[N])
            answer+=val;
        
        System.out.println(answer%9901);
    }
}