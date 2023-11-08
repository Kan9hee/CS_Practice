import java.io.*;

public class Test2579 {
    static Integer[] dp;
    static int[] stair;
    static int N;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        stair=new int[N+1];
        dp=new Integer[N+1];

        for(int i=1;i<=N;i++)
            stair[i]=Integer.parseInt(br.readLine());

        dp[0]=stair[0];
        dp[1]=stair[1];
        if(N>=2)
            dp[2]=stair[1]+stair[2];

        System.out.println(topdown(N));
    }

    private static int topdown(int floor){
        if(dp[floor]==null)
            dp[floor]=Math.max(topdown(floor-2),topdown(floor-3)+stair[floor-1])+stair[floor];

        return dp[floor];
    }
}
