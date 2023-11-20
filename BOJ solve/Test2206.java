import java.io.*;
import java.util.*;

public class Test2206 {
    static class Node{
        int x,y,val,crashed;
        Node(int x,int y,int val,int crashed){
            this.x=x;
            this.y=y;
            this.val=val;
            this.crashed=crashed;
        }
    }

    static int[] xmove={1,0,-1,0};
    static int[] ymove={0,1,0,-1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        int[][] map=new int[n][m];
        boolean[][][] check=new boolean[n][m][2];

        for(int i=0;i<n;i++){
            input=br.readLine().split("");
            for(int j=0;j<m;j++)
                map[i][j]=Integer.parseInt(input[j]);
        }

        Queue<Node>q=new LinkedList<>();
        q.add(new Node(0,0,1,1));

        while(!q.isEmpty()){
            Node temp=q.poll();

            if(temp.x==n-1&&temp.y==m-1){
                System.out.println(temp.val);
                return;
            }

            for(int i=0;i<4;i++){
                int nx=temp.x+xmove[i];
                int ny=temp.y+ymove[i];
                int moved=temp.val+1;
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(!check[nx][ny][temp.crashed]){
                        if(map[nx][ny]==0){
                            q.add(new Node(nx,ny,moved,temp.crashed));
                            check[nx][ny][temp.crashed]=true;
                        }
                        else if(temp.crashed==1){
                            q.add(new Node(nx,ny,moved,0));
                            check[nx][ny][0]=true;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
