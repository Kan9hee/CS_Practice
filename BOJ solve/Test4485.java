import java.io.*;
import java.util.*;

public class Test4485{

    static class Node{
        int x,y,value;
        Node(int x,int y,int value){
            this.x=x;
            this.y=y;
            this.value=value;
        }
    }

    static int[][] map;
    static int[] xmove={1,0,0,-1};
    static int[] ymove={0,1,-1,0};
    static int N,history=1;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            N=Integer.parseInt(br.readLine());
            if(N==0)
                break;
            
            map=new int[N][N];
            for(int i=0;i<N;i++){
                String[] input=br.readLine().split("\\s+");
                for(int j=0;j<N;j++)
                    map[i][j]=Integer.parseInt(input[j]);
            }

            BFS();
            history++;
        }
    }

    private static void BFS(){
        PriorityQueue<Node>q=new PriorityQueue<>((Node n1,Node n2)->n1.value-n2.value);
        boolean[][] check=new boolean[N][N];
        int answer=Integer.MAX_VALUE;
        q.add(new Node(0,0,map[0][0]));

        while(!q.isEmpty()){
            Node temp=q.poll();
            if(temp.x==(N-1)&&temp.y==(N-1)){
                answer=Math.min(answer,temp.value);
            }
            check[temp.x][temp.y]=true;
            for(int i=0;i<4;i++){
                int nx=temp.x+xmove[i];
                int ny=temp.y+ymove[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<N)
                    if(!check[nx][ny])
                        q.add(new Node(nx,ny,temp.value+map[nx][ny]));
            }
        }

        System.out.println("Problem "+history+": "+answer);
    }
}