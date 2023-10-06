import java.io.*;
import java.util.*;

public class Test14052 {
    static int[][] map,copyMap;
    static int[] xList={1,0,-1,0};
    static int[] yList={0,-1,0,1};
    static int result=Integer.MIN_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] mapSet=br.readLine().split("\\s+");

        map=new int[Integer.parseInt(mapSet[0])][Integer.parseInt(mapSet[1])];
        for(int i=0;i<map.length;i++){
            String[] input=br.readLine().split("\\s+");
            for(int j=0;j<input.length;j++)
                map[i][j]=Integer.parseInt(input[j]);
        }

        dfs(3);
        System.out.println(result);
    }

    public static void dfs(int count){
        if(count==0){
            bfs();
            return;
        }
        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(count-1);
                    map[i][j]=0;
                }
            }
    }

    public static void bfs(){
        Queue<int[]> q=new LinkedList<>();
        copyMap=new int[map.length][map[0].length]; //infection simulate map

        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[0].length;j++){
                copyMap[i][j]=map[i][j];
                if(copyMap[i][j]==2)
                    q.add(new int[]{i,j});
            }

        while(!q.isEmpty()){
            int[] temp=q.poll();
            for(int i=0;i<4;i++){
                int dx=temp[0]+xList[i];
                int dy=temp[1]+yList[i];
                if(dx>=0&&dx<map.length&&dy>=0&&dy<map[0].length){
                    if(copyMap[dx][dy]==0){
                        copyMap[dx][dy]=2;
                        q.add(new int[]{dx,dy});
                    }
                }
            }
        }

        int count=0;
        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[0].length;j++)
                if(copyMap[i][j]==0)
                    count++;

        result=Math.max(result,count);
    }
}