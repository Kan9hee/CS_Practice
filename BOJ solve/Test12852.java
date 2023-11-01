import java.io.*;

public class Test12852 {
    static int[] dp,history;
    static int N;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        dp=new int[N+1];
        history=new int[N+1];
        dp[1]=0;

        for(int i=2;i<=N;i++){
            dp[i]=dp[i-1]+1;
            history[i]=i-1;
            if(i%2==0&&dp[i/2]+1<dp[i]){
                dp[i]=dp[i/2]+1;
                history[i]=i/2;
            }
            if(i%3==0&&dp[i/3]+1<dp[i]){
                dp[i]=dp[i/3]+1;
                history[i]=i/3;
            }
        }
        System.out.println(dp[N]);
 
        StringBuilder sb=new StringBuilder();
        while(N>0){
            sb.append(N+" ");
            N=history[N];
        }
 
        System.out.println(sb);
    }
}