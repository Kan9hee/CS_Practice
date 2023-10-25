import java.io.*;
import java.util.*;

public class Test1504 {

    static class Node{
        int otherNode;
        int weight;
        Node(int otherNode,int weight){
            this.otherNode=otherNode;
            this.weight=weight;
        }
    }

    static ArrayList<ArrayList<Node>> map=new ArrayList<>();
    static int[] weights;
    static boolean[] check;
    static int N,E;
    static int INF=200000000; //maxE * maxWeight

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        
        weights=new int[N+1];
        check=new boolean[N+1];
        for(int i=0;i<=N;i++)
            map.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end,weight));
            map.get(end).add(new Node(start,weight));
        }

        st=new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());
        int result1=0, result2=0;
        int v12Shortcut=Dijkstra(v1,v2);
        
        result1+=Dijkstra(1,v1);
        result1+=v12Shortcut;
        result1+=Dijkstra(v2,N);

        result2+=Dijkstra(1,v2);
        result2+=v12Shortcut;
        result2+=Dijkstra(v1,N);

        int answer=-1;
        if(result1<INF&&result2<INF)
            answer=Math.min(result1,result2);

        System.out.println(answer);
    }

    private static int Dijkstra(int start,int end){
        PriorityQueue<Node>pq=new PriorityQueue<>((Node o1,Node o2) -> o1.weight-o2.weight);
        int[] weights=new int[N+1];
        boolean[] check=new boolean[N+1];
        Arrays.fill(weights,INF);
        Arrays.fill(check,false);
        pq.add(new Node(start,0));
        weights[start]=0;

        while(!pq.isEmpty()){
            Node temp=pq.poll();

            if(!check[temp.otherNode]){
                check[temp.otherNode]=true;

                for(Node node:map.get(temp.otherNode)){
                    if(weights[node.otherNode]>temp.weight+node.weight){
                        weights[node.otherNode]=temp.weight+node.weight;
                        pq.add(new Node(node.otherNode,weights[node.otherNode]));
                    }
                }
            }
        }

        return weights[end];
    }
}
