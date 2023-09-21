import java.io.*;
import java.util.*;

public class Test2096 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[][] map=new int[N+1][3];
        for(int n=1;n<=N;n++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<3;i++)
                map[n][i]=Integer.parseInt(st.nextToken());
        }
        
        int[][] maxDP=new int[N+1][3];
        int[][] minDP=new int[N+1][3];
        for(int i=1;i<=N;i++){
            maxDP[i][0]=Math.max(maxDP[i-1][0],maxDP[i-1][1])+map[i][0];
            maxDP[i][1]=Math.max(Math.max(maxDP[i-1][0],maxDP[i-1][1]),maxDP[i-1][2])+map[i][1];
            maxDP[i][2]=Math.max(maxDP[i-1][1],maxDP[i-1][2])+map[i][2];

            minDP[i][0]=Math.min(minDP[i-1][0],minDP[i-1][1])+map[i][0];
            minDP[i][1]=Math.min(Math.min(minDP[i-1][0],minDP[i-1][1]),minDP[i-1][2])+map[i][1];
            minDP[i][2]=Math.min(minDP[i-1][1],minDP[i-1][2])+map[i][2];
        }

        int[] result=new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
        for(int i=0;i<3;i++){
            result[0]=Math.max(result[0],maxDP[N][i]);
            result[1]=Math.min(result[1],minDP[N][i]);
        }

        System.out.println(result[0]+" "+result[1]);
    }
}
