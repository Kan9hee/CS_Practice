import java.io.*;
import java.util.*;

public class Test1967 {
    static class Node{
        int next,len;
        Node(int next,int len){
            this.next=next;
            this.len=len;
        }
    }

    static ArrayList<Node>[] tree;
    static boolean[] check;
    static int result=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        tree=new ArrayList[n+1]; //not binary tree
        for(int i=1;i<n+1;i++)
            tree[i]=new ArrayList();

        for(int i=0;i<n-1;i++){
            String[] input=br.readLine().split("\\s+");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int val=Integer.parseInt(input[2]);
            tree[start].add(new Node(end,val));
            tree[end].add(new Node(start,val));
        }

        for(int i=1;i<=n;i++){
            check=new boolean[n+1];
            check[i]=true;
            DFS(i,0);
        }

        System.out.println(result);
    }

    private static void DFS(int num,int sum){
        for(Node linked:tree[num]){
            if(!check[linked.next]){
                check[linked.next]=true;
                DFS(linked.next,sum+linked.len);
            }
        }
        result=Math.max(result,sum);
    }
}
