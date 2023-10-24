import java.io.*;
import java.util.*;

public class Test15683 {
    static ArrayList<int[]> cameras=new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
    static int answer=Integer.MAX_VALUE;
    static int x,y;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        int[][] map=new int[x][y];
        
        for(int i=0;i<x;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<y;j++){
                int val=Integer.parseInt(st.nextToken());
                map[i][j]=val;
                if(val>0&&val<6)
                    cameras.add(new int[]{i,j});
            }
        }

        find(map,0);
        System.out.println(answer);
    }

    private static void find(int[][] map,int count){
        if(count==cameras.size()){
            int result=0;
            for(int i=0;i<x;i++)
                for(int j=0;j<y;j++)
                    if(map[i][j]==0)
                        result++;
            answer=Math.min(answer,result);
            return;
        }

        int[][]tempMap=new int[x][y];
        for(int i=0;i<x;i++)
            tempMap[i]=map[i].clone();
        int[] node=cameras.get(count);
        int val=tempMap[node[0]][node[1]];

        if(val==5){
            for(int i=0;i<4;i++)
                paint(tempMap,node,dx[i],dy[i],-1);
            find(tempMap,count+1);
            for(int i=0;i<4;i++)
                paint(tempMap,node,dx[i],dy[i],0);
        }
        else if(val==2){
            for (int i=0;i<2;i++) {
                paint(tempMap,node,dx[i],dy[i],-1);
                paint(tempMap,node,dx[(i+2)%4],dy[(i+2)%4],-1);
                find(tempMap,count+1);
                paint(tempMap,node,dx[i],dy[i],0);
                paint(tempMap,node,dx[(i+2)%4],dy[(i+2)%4],0);
            }
        }
        else{
            if(val==1){
                for(int i=0;i<4;i++){
                    paint(tempMap,node,dx[i],dy[i],-1);
                    find(tempMap,count+1);
                    paint(tempMap,node,dx[i],dy[i],0);
                }
            }
            else if(val==3){
                for(int i=0,j=1;i<4;j=(j+1)%4,i++){
                    paint(tempMap,node,dx[i],dy[i],-1);
                    paint(tempMap,node,dx[j],dy[j],-1);
                    find(tempMap,count+1);
                    paint(tempMap,node,dx[i],dy[i],0);
                    paint(tempMap,node,dx[j],dy[j],0);
                }
            }
            else if(val==4){
                for(int i=3,j=0,k=1;j<4;i=(i+1)%4,j++,k=(k+1)%4){
                    paint(tempMap,node,dx[i],dy[i],-1);
                    paint(tempMap,node,dx[j],dy[j],-1);
                    paint(tempMap,node,dx[k],dy[k],-1);
                    find(tempMap,count+1);
                    paint(tempMap,node,dx[i],dy[i],0);
                    paint(tempMap,node,dx[j],dy[j],0);
                    paint(tempMap,node,dx[k],dy[k],0);
                }
            }
        }
    }

    private static void paint(int[][] map,int[] node,int xway,int yway,int val){
        for(int i=1;;i++){
            int nx=node[0]+i*xway;
            int ny=node[1]+i*yway;
            if(nx<0||ny<0||nx>=x||ny>=y)
                break;
            if(map[nx][ny]>0)
                break;
            map[nx][ny]=val;
        }
    }
}
