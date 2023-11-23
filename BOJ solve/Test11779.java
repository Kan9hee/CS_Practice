import java.io.*;
import java.util.*;

public class Test11779 {
    static class Node{
        int end,val;
        
        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }

    static ArrayList<Node>[] map;
    static boolean[] visited;
    static int[] distance,route;
    static int endPoint;
    static Node result=null;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        distance=new int[n+1];
        route=new int[n+1];
        visited=new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        map=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            map[i]=new ArrayList<>();

        String[] input;
        for(int i=0;i<m;i++){
            input=br.readLine().split("\\s+");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int val=Integer.parseInt(input[2]);
            map[start].add(new Node(end,val));
        }

        input=br.readLine().split("\\s+");
        endPoint=Integer.parseInt(input[1]);
        dijkstra(Integer.parseInt(input[0]));

        ArrayList<Integer> routes=new ArrayList<>();
        int current=endPoint;
        while(current!=0) {
            routes.add(current);
            current=route[current];
        }

        System.out.println(distance[endPoint]);
        System.out.println(routes.size());
        for(int i=routes.size()-1;i>=0;i--)
            System.out.print(routes.get(i)+" ");
    }

    public static void dijkstra(int start){
        PriorityQueue<Node>pq=new PriorityQueue<>((Node n1,Node n2)->n2.val-n1.val);
        pq.add(new Node(start,0));
        distance[start]=0;
        route[start]=0;

        while(!pq.isEmpty()){
            Node temp=pq.poll();
            if(visited[temp.end])
                continue;
            visited[temp.end]=true;

            for(Node next:map[temp.end]){
                if(distance[next.end]>distance[temp.end]+next.val){
                    distance[next.end]=distance[temp.end]+next.val;
                    pq.add(new Node(next.end,distance[next.end]));
                    route[next.end]=temp.end;
                }
            }
        }
    }
}
