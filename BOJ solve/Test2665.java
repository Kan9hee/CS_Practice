import java.io.*;
import java.util.*;

public class Test2665 {

    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[][] map,countMap;
    static int[] xmove={-1,1,0,0};
    static int[] ymove={0,0,1,-1};
    static int N;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        countMap=new int[N][N];
        for(int i=0;i<N;i++){
            String input=br.readLine();
            Arrays.fill(countMap[i],Integer.MAX_VALUE);
            for(int j=0;j<N;j++)
                map[i][j]=input.charAt(j)-'0';
        }

        BFS(0,0);
    }

    private static void BFS(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        countMap[x][y] = 0;

        while(!q.isEmpty()){
            Node temp=q.poll();
            int val=countMap[temp.x][temp.y];
            for(int i=0;i<4;i++){
                int nx=temp.x+xmove[i];
                int ny=temp.y+ymove[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<N&&countMap[nx][ny]>val){
                    countMap[nx][ny]=map[nx][ny]==1?val:val+1;
                    q.add(new Node(nx,ny));
                }
            }
        }

        System.out.println(countMap[N-1][N-1]);
    }
}
