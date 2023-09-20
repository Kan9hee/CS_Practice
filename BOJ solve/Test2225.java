import java.io.*;
import java.util.*;

public class Test2225 {
    static int[][] map;
    static long condition=1000000000;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        map=new int[K][N+1];

        System.out.println(search(K-1,N)%condition);
    }

    private static long search(int k,int n){
        if(map[k][n]>0)
            return map[k][n];
        if(n==0||k==0)
            return 1;

        for(int i=0;i<=n;i++){
            map[k][n]+=search(k-1, i);
            map[k][n]%=condition;
        }
        
        return map[k][n];
    }
}
