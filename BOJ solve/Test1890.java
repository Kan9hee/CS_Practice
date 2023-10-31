import java.io.*;
import java.util.Arrays;

public class Test1890 {
    static int[][] map;
    static long[][] dpmap;
    static int N;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        dpmap=new long[N][N];
        
        for(int i=0;i<N;i++){
            String[] input=br.readLine().split("\\s+");
            Arrays.fill(dpmap[i],-1);
            for(int j=0;j<N;j++)
                map[i][j]=Integer.parseInt(input[j]);
        }
        
        System.out.println(TopDown(0,0));
    }

    private static long TopDown(int x,int y){
        if(x==N-1&&y==N-1)
            return 1;
        else if(x<0||y<0||x>=N||y>=N||map[x][y]==0)
            return 0;
        
        if(dpmap[x][y]==-1)
            dpmap[x][y]=TopDown(x+map[x][y],y)+TopDown(x,y+map[x][y]);
        return dpmap[x][y];
    }
}
