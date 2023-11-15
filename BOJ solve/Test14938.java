import java.io.*;
import java.util.*;

public class Test14938 {
    static class Node{
        int place,length;
        Node(int place,int length){
            this.place=place;
            this.length=length;
        }
    }

    static ArrayList<ArrayList<Node>> map=new ArrayList<>();
    static int[] item;
    static int n,m,r,answer=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        r=Integer.parseInt(input[2]);

        item=new int[n+1];
        input=br.readLine().split("\\s+");
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
            if(i>0)
                item[i]=Integer.parseInt(input[i-1]);
        }

        for(int i=1;i<=r;i++){
            input=br.readLine().split("\\s+");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int len=Integer.parseInt(input[2]);
            map.get(start).add(new Node(end,len));
            map.get(end).add(new Node(start,len));
        }
        
        for(int i=1;i<=n;i++)
            answer=Math.max(answer,dijkstra(i));

        System.out.println(answer);
    }

    private static int dijkstra(int start){
        PriorityQueue<Node>pq=new PriorityQueue<>((Node n1,Node n2)->n1.length-n2.length);
        int[] distance=new int[n+1];
        boolean[] check=new boolean[n+1];

        pq.add(new Node(start,0));
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start]=0;
        int result=0;

        while(!pq.isEmpty()){
            Node temp=pq.poll();
            
            if(!check[temp.place]){
                check[temp.place]=true;
                for(Node next:map.get(temp.place)){
                    if(!check[next.place]&&distance[next.place]>distance[temp.place]+next.length){
                        distance[next.place]=distance[temp.place]+next.length;
                        pq.add(new Node(next.place,distance[next.place]));
                    }
                }
            }
        }

        for(int i=1;i<=n;i++)
            if(distance[i]<=m)
                result+=item[i];
                
        return result;
    }
}
