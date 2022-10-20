import java.io.*;
import java.util.*;

public class Test2178 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> que= new LinkedList<Integer>();
    static int tx,ty,x,y;
    static int[] dx= {-1, 0, 0, 1};
    static int[] dy= {0, -1, 1, 0};
	
	public static void main(String [] args)throws IOException{
        st=new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int visited[][] = new int[Y][X];
		int mat[][] = new int[Y][X];
		
		for(int i=0; i<Y; i++) {
			String str= br.readLine();
			for(int j=0; j<X; j++) {
				mat[i][j]= Integer.parseInt(str.charAt(j)+"");	
			}
		}
		
		que.offer(0);
		que.offer(0);
		visited[0][0]=1;
		
		while(!que.isEmpty()) {
			y=que.poll();
			x=que.poll();
			for(int i=0; i<4; i++) {
				tx= x+dx[i];
				ty= y+dy[i];
				if(tx>=0&&tx<X&&ty>=0&&ty<Y) {
					if(mat[ty][tx]!=0&&visited[ty][tx]!=1) {
						visited[ty][tx]=1;
						mat[ty][tx]= mat[y][x]+1;
						que.offer(ty);
						que.offer(tx);
					}
				}
			}
		}
		System.out.println(mat[Y-1][X-1]);
	}
}