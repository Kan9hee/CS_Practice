import java.io.*;
import java.util.*;

public class Test1261 {
    private static class Node{
        int x,y,val;
        Node(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1 ,1};

    public static void main(String[] args)throws IOException{
        Queue<Node>q=new PriorityQueue<>((n1,n2)->{return n1.val-n2.val;});
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int maxX=Integer.parseInt(st.nextToken());
        int maxY=Integer.parseInt(st.nextToken());
        int[][] map=new int[maxX][maxY];
        boolean[][] check=new boolean[maxX][maxY];
        int result=0;

        for(int i=0,j=0;i<maxY;i++,j=0){
            for(char c:br.readLine().toCharArray()){
                map[j][i]=Integer.parseInt(Character.toString(c));
                j++;
            }
        }

        q.add(new Node(0,0,0));
        check[0][0]=true;
        while(!q.isEmpty()){
            Node n=q.poll();
            if(n.x==maxX-1&&n.y==maxY-1){
                result=n.val;
                break;
            }
            for(int i=0;i<4;i++){
                int nx=n.x+dx[i];
                int ny=n.y+dy[i];
                if(nx>=0&&nx<maxX&&ny>=0&&ny<maxY&&!check[nx][ny]){
                    q.add(new Node(nx,ny,n.val+map[nx][ny]));
                    check[nx][ny]=true;
                }
            }
        }

        System.out.println(result);
    }
}
