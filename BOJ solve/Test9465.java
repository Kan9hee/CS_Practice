import java.io.*;
import java.util.*;

public class Test9465 {
    static int[][] map;
    static int[][] DP;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int n=Integer.parseInt(br.readLine());
            map=new int[2][n+1];
            DP=new int[2][n+1];
            for(int l=0;l<2;l++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int k=1;k<=n;k++)
                    map[l][k]=Integer.parseInt(st.nextToken());
            }

            DP[0][1]=map[0][1];
            DP[1][1]=map[1][1];

            for(int count=2;count<=n;count++){
                DP[0][count]=Math.max(DP[1][count-2],DP[1][count-1])+map[0][count];
                DP[1][count]=Math.max(DP[0][count-2],DP[0][count-1])+map[1][count];
            }

            System.out.println(Math.max(DP[0][n],DP[1][n]));
        }
    }
}
