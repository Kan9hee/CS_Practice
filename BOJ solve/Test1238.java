import java.io.*;
import java.util.*;

public class Test1238 {

    static class Path{
        int endPoint,time;
        Path(int endPoint,int time){
            this.endPoint=endPoint;
            this.time=time;
        }
    }

    static ArrayList<ArrayList<Path>> map = new ArrayList<>();
    static ArrayList<ArrayList<Path>> reverseMap = new ArrayList<>();
    static int[] student;
    static int n,m,x;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        x=Integer.parseInt(input[2]);

        student=new int[n+1];
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
            reverseMap.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            input=br.readLine().split("\\s+");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int time=Integer.parseInt(input[2]);
            map.get(start).add(new Path(end,time));
            reverseMap.get(end).add(new Path(start,time));
        }

        int[] ntox=dijkstra(map);
        int[] xton=dijkstra(reverseMap);

        int result=0;
        for(int i=1;i<=n;i++)
            result=Math.max(result,ntox[i]+xton[i]);

        System.out.println(result);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Path>> oneWay){
        PriorityQueue<Path> pq=new PriorityQueue<>((Path p1,Path p2)->p1.time-p2.time);
        int[] distance=new int[n+1];
        boolean[] check=new boolean[n+1];
        
        Arrays.fill(distance,Integer.MAX_VALUE);
        pq.add(new Path(x,0));
        distance[x]=0;

        while(!pq.isEmpty()){
            Path temp=pq.poll();
            int end=temp.endPoint;
            if(!check[end]){
                check[end]=true;
                for(Path next:oneWay.get(end)){
                    if(!check[next.endPoint]&&distance[next.endPoint]>distance[end]+next.time){
                        distance[next.endPoint]=distance[end]+next.time;
                        pq.add(new Path(next.endPoint,distance[next.endPoint]));
                    }
                }
            }
        }
        
        return distance;
    }
}
