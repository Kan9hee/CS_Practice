import java.io.*;
import java.util.*;

public class Test1707 {
    static ArrayList<ArrayList<Integer>> map;
    static int[] check;
    static int V,E;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){
            String[] input=br.readLine().split("\\s+");
            V=Integer.parseInt(input[0]);
            E=Integer.parseInt(input[1]);
            map=new ArrayList<ArrayList<Integer>>();
            check=new int[V+1];

            for(int j=0;j<=V;j++)
                map.add(new ArrayList<Integer>());

            for(int j=0;j<E;j++){
                input=br.readLine().split("\\s+");
                int start=Integer.parseInt(input[0]);
                int end=Integer.parseInt(input[1]);
                map.get(start).add(end);
                map.get(end).add(start);
            }

            boolean answer = false;
            for(int j=1;j<=V;j++){
                if(check[j]==0)
                    answer=bfs(j,1);
                if(!answer)
                    break;
            }
            
            System.out.println(answer?"YES":"NO");
        }
    }

    private static boolean bfs(int node,int set){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        check[node]=set;

        while(!q.isEmpty()){
            int temp=q.poll();
            for(int next:map.get(temp)) {
                if(check[temp]==check[next])
                    return false;
                if(check[next]==0) {
                    check[next]=check[temp]*-1;
                    q.add(next);
                }
            }
        }

        return true;
    }
}
