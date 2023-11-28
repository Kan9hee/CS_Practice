import java.io.*;
import java.util.*;

public class Test2573 {
    static boolean[][] checkMap;
    static int[][] map;
    static int[] xmove={1,0,-1,0};
    static int[] ymove={0,1,0,-1};
    static int n,m,year=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        map=new int[n][m];
        for(int i=0;i<n;i++){
            input=br.readLine().split("\\s+");
            for(int j=0;j<m;j++)
                map[i][j]=Integer.parseInt(input[j]);
        }

        while(true){
            checkMap=new boolean[n][m];
            int count=0;
		
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!checkMap[i][j]&&map[i][j]>0){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            if(count>1){
                System.out.println(year);
                break;
            }else if(count==0){
                System.out.println(0);
                break;
            }

            bfs();
            year++;
        }
    }

    private static void dfs(int x,int y){
        checkMap[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+xmove[i];
            int ny=y+ymove[i];
            if(nx>=0&&ny>=0&&nx<n&&ny<m)
                if(!checkMap[nx][ny]&&map[nx][ny]>0)
                    dfs(nx,ny);
        }
    }

    private static void bfs(){
        Queue<int[]>q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]>0)
                    q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int count=0;

            for(int i=0;i<4;i++){
                int nx=temp[0]+xmove[i];
                int ny=temp[1]+ymove[i];
                if(nx>=0&&ny>=0&&nx<n&&ny<m)
                    if(!checkMap[nx][ny]&&map[nx][ny]==0)
                        count++;
            }

            if(count>=map[temp[0]][temp[1]])
                map[temp[0]][temp[1]]=0;
            else
                map[temp[0]][temp[1]]-=count;
        }
    }
}
