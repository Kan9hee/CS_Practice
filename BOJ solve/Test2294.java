import java.io.*;
import java.util.*;

public class Test2294 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        int[] list=new int[Integer.parseInt(input[0])];
        int k=Integer.parseInt(input[1]);

        for(int i=0;i<list.length;i++)
            list[i]=Integer.parseInt(br.readLine());

        int[] dp=new int[Integer.parseInt(input[1])+1];
        Arrays.fill(dp,10001);
        dp[0]=0;

        for(int i=0;i<list.length;i++)
            for(int j=list[i];j<=k;j++)
                dp[j]=Math.min(dp[j],dp[j-list[i]]+1);
        
        if(dp[k]==10001)
            dp[k]=-1;
        
        System.out.println(dp[k]);
    }
}
