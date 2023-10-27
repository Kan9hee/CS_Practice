import java.io.*;
import java.util.*;

public class Test1446 {

    static class Line{
        int start,end,weight;
        Line(int start,int end,int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }

    static Line[] list;
    static int[] road;
    static int N,D;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        N=Integer.parseInt(input[0]);
        D=Integer.parseInt(input[1]);
        list=new Line[N];
        road=new int[D+1];

        for(int i=0;i<N;i++){
            input=br.readLine().split("\\s+");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int weight=Integer.parseInt(input[2]);
            list[i]=new Line(start,end,weight);
        }

        for(int i=0;i<=D;i++)
            road[i]=i;

        Dijkstra(0);
    }

    private static void Dijkstra(int start){
        PriorityQueue<Line>pq=new PriorityQueue<>((Line n1,Line n2)->n1.weight-n2.weight);
        pq.add(new Line(start,0,0));
        road[start]=0;
        int linesEnd=0;

        while(!pq.isEmpty()){
            Line temp=pq.poll();
            linesEnd=temp.end;
            for(Line shortCut:list){
                if(shortCut.start>=linesEnd&&shortCut.end<=D){
                    int interval=shortCut.start-linesEnd;
                    if(road[shortCut.end]>road[linesEnd]+shortCut.weight+interval){
                        road[shortCut.end]=road[linesEnd]+shortCut.weight+interval;
                        pq.add(new Line(linesEnd,shortCut.end,road[shortCut.end]));
                    }
                }
            }
            road[D]=Math.min(road[linesEnd]+D-linesEnd,road[D]);
        }

        System.out.println(road[D]);
    }
}
