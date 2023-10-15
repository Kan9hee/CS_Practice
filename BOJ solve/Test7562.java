import java.io.*;
import java.util.*;

public class Test7562 {
    static boolean[][] check;
    static int[] xMove={1,2,2,1,-1,-2,-2,-1};
    static int[] yMove={2,1,-1,-2,-2,-1,1,2};
    static int[] startPoint=new int[2], endPoint=new int[2];
    static int mapSize;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            mapSize=Integer.parseInt(br.readLine());
            check=new boolean[mapSize][mapSize];
            String[] startInput=br.readLine().split("\\s+");
            String[] endInput=br.readLine().split("\\s+");
            for(int set=0;set<2;set++){
                startPoint[set]=Integer.parseInt(startInput[set]);
                endPoint[set]=Integer.parseInt(endInput[set]);
            }

            BFS();
        }
    }

    private static void BFS(){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{startPoint[0],startPoint[1],0});
        check[startPoint[0]][startPoint[1]]=true;
        int result=-1;

        while(!q.isEmpty()){
            int[] temp=q.poll();
            if(temp[0]==endPoint[0]&&temp[1]==endPoint[1]){
                result=temp[2];
                break;
            }
            for(int i=0;i<8;i++){
                int nx=temp[0]+xMove[i];
                int ny=temp[1]+yMove[i];
                if(nx>=0&&nx<mapSize&&ny>=0&&ny<mapSize)
                    if(!check[nx][ny]){
                        check[nx][ny]=true;
                        q.add(new int[]{nx,ny,temp[2]+1});
                    }
            }
        }

        System.out.println(result);
    }
}
