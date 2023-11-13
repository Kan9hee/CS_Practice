import java.io.*;
import java.util.*;

public class Test1520 {
    static int[][] dp;
    static int[][] map;
    static int[] xmove={0,1,-1,0};
    static int[] ymove={1,0,0,-1};
    static int m,n,result=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        m=Integer.parseInt(input[0]);
        n=Integer.parseInt(input[1]);
        map=new int[m][n];
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            input=br.readLine().split("\\s+");
            Arrays.fill(dp[i],-1); //no visit
            for(int j=0;j<n;j++)
                map[i][j]=Integer.parseInt(input[j]);
        }

        System.out.println(dfs(0,0));
    }

    private static int dfs(int x,int y){
        if(x==n-1&&y==m-1)
            return 1;
        
        if(dp[y][x]!=-1)
            return dp[y][x];

        dp[y][x]=0; //visit

        for(int i=0;i<4;i++){
            int nx=x+xmove[i];
            int ny=y+ymove[i];
            if(nx>=0&&ny>=0&&nx<n&&ny<m)
                if(map[y][x]>map[ny][nx]){
                    dp[y][x]+=dfs(nx,ny);
                }
        }

        return dp[y][x];
    }
}
