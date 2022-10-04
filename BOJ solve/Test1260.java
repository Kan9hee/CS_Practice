import java.io.*;
import java.util.*;

public class Test1260 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static Queue<Integer>q=new LinkedList<>();
    static boolean graph[][];
    static boolean check[];
    static int node,link,root,temp1,temp2;

    static void DFS(int n){
        check[n]=true;
        sb.append(n+" ");
        for(int i=0;i<=node;i++)
            if(graph[n][i]&&!check[i])
                DFS(i);
    }

    static void BFS(int n){
        q.add(n);
		check[n] = false;
		while(!q.isEmpty()){
			n = q.poll();
			sb.append(n + " ");
			for(int i = 1 ; i <= node ; i++) {
				if(graph[n][i] && check[i]) {
					q.add(i);
					check[i] = false;
				}
			}
		}
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        node=Integer.parseInt(st.nextToken());
        link=Integer.parseInt(st.nextToken());
        root=Integer.parseInt(st.nextToken());
        graph=new boolean[node+1][node+1];
        check=new boolean[node+1];

        for(int i=0;i<link;i++){
            st=new StringTokenizer(br.readLine());
            temp1=Integer.parseInt(st.nextToken());
            temp2=Integer.parseInt(st.nextToken());
            graph[temp1][temp2]=graph[temp2][temp1]=true;
        }

        DFS(root);
        sb.append('\n');
        BFS(root);

        System.out.println(sb);
    }
}
