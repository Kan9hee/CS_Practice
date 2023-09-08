import java.io.*;
import java.util.*;

public class Test17070 {

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int[][] map=new int[N][N];
        int[][][] DP=new int[N][N][3];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int t=0;t<N;t++)
                map[i][t]=Integer.parseInt(st.nextToken());
        }
        DP[0][1][0] = 1;

        for(int i=0;i<N;i++){
            for(int t=2;t<N;t++){
                if(t-1>=0&&map[i][t]==0)
                    DP[i][t][0] = DP[i][t-1][0] + DP[i][t-1][2];
                if(i-1>=0&&map[i][t]==0)
                    DP[i][t][1] = DP[i-1][t][1] + DP[i-1][t][2];
                if(i-1>=0&&t-1>=0&&map[i][t]==0&&map[i-1][t]==0&&map[i][t-1]==0)
                    DP[i][t][2] = DP[i-1][t-1][0] + DP[i-1][t-1][1] + DP[i-1][t-1][2];
            }
        }
        
        System.out.println(DP[N-1][N-1][0]+DP[N-1][N-1][1]+DP[N-1][N-1][2]);
    }
}
