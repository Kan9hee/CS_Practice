import java.io.*;
import java.util.*;

public class Test1926 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] check;
    static int[] setX={1,0,-1,0};
    static int[] setY={0,1,0,-1};
    static int mapX,mapY,size,count=0,maxSize=0;

    static void DFS(int x,int y){
        for(int i=0;i<4;i++){
            int tempX=x+setX[i];
            int tempY=y+setY[i];

            if(tempX<mapX&&tempX>=0&&tempY<mapY&&tempY>=0)
                if(!check[tempY][tempX]&&map[tempY][tempX]==1){
                    check[tempY][tempX]=true;
                    size++;
                    DFS(tempX,tempY);
                }
        }
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        mapY=Integer.parseInt(st.nextToken());
        mapX=Integer.parseInt(st.nextToken());

        map=new int[mapY][mapX];
        check=new boolean[mapY][mapX];

        for(int i=0;i<mapY;i++){
            st=new StringTokenizer(br.readLine());
            for(int t=0;t<mapX;t++)
                map[i][t]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<mapY;i++)
            for(int t=0;t<mapX;t++)
                if(!check[i][t]&&map[i][t]==1){
                    size=1;
                    check[i][t]=true;
                    DFS(t,i);
                    maxSize=Math.max(maxSize,size);
                    count++;
                }
        
        System.out.println(count+"\n"+maxSize);
        br.close();
    }
}
