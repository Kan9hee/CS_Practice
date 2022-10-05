import java.io.*;
import java.util.*;

public class Test11725 {
    static ArrayList<Integer>list[];
    static Queue<Integer> q=new LinkedList<>();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static boolean tree[][],check[];
    static int result[];

    static void BFS(int root){
        q.add(root);
        while(!q.isEmpty()){
            root=q.poll();
            for(int i:list[root]){
                if(!check[i]){
                    result[i]=root;
                    q.add(i);
                    check[i]=true;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        int node=Integer.parseInt(br.readLine());
        list=new ArrayList[node+1];
        for(int i=0;i<=node;i++)
            list[i]=(new ArrayList<>());
        result=new int[node+1];
        check=new boolean[node+1];

        for(int i=0;i<node-1;i++){
            st=new StringTokenizer(br.readLine());
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }

        BFS(1);

        for(int i=2;i<=node;i++)
            sb.append(result[i]+"\n");
        System.out.println(sb);
    }
}