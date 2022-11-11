import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Test1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = 999999;
    static int nodes,lines,index,dist[];
    static List<Node>[] list;

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[nodes + 1];
        pq.add(new Node(start, 0));
        dist[start] = 0;
 
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
 
            if(check[cur] == true)
                continue;
            check[cur] = true;
 
            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
 
        for(int i = 1; i <= nodes; i++){
         if(dist[i] == INF)
             sb.append("INF\n");
         else
             sb.append(dist[i] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        nodes = Integer.parseInt(st.nextToken());
        lines = Integer.parseInt(st.nextToken());
        index = Integer.parseInt(br.readLine());
        list = new ArrayList[nodes + 1];
        dist = new int[nodes + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= nodes; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < lines; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        dijkstra(index);

        System.out.print(sb.toString());
    }
}
