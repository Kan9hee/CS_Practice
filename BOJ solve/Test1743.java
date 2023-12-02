import java.io.*;
import java.util.*;

public class Test1743 {
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static ArrayList<Node>list=new ArrayList<>();
    static boolean[][] map,check;
    static int[] xmove={1,0,-1,0};
    static int[] ymove={0,1,0,-1};
    static int n,m,biggest=Integer.MIN_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        int k=Integer.parseInt(input[2]);
        map=new boolean[n+1][m+1];
        check=new boolean[n+1][m+1];

        for(int i=0;i<k;i++){
            input=br.readLine().split("\\s+");
            int x=Integer.parseInt(input[0]);
            int y=Integer.parseInt(input[1]);
            map[x][y]=true;
            list.add(new Node(x,y));
        }

        for(Node temp:list){
            if(!check[temp.x][temp.y])
                BFS(temp.x,temp.y);
        }

        System.out.println(biggest);
    }

    private static void BFS(int x,int y){
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(x,y));
        check[x][y]=true;
        int result=0;

        while(!q.isEmpty()){
            Node temp=q.poll();
            result++;
            for(int i=0;i<4;i++){
                int nx=temp.x+xmove[i];
                int ny=temp.y+ymove[i];
                if(nx>0&&ny>0&&nx<=n&&ny<=m)
                    if(!check[nx][ny]&&map[nx][ny]){
                        check[nx][ny]=true;
                        q.add(new Node(nx,ny));
                    }
            }
        }

        biggest=Math.max(biggest,result);
    }
}