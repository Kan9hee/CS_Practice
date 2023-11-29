import java.io.*;
import java.util.*;

public class Test10282 {
    static class Node{
        int end,time;
        Node(int end,int time){
            this.end=end;
            this.time=time;
        }
    }

    static ArrayList<Node>[] map;
    static int[] list;
    static boolean[] check;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        
        for(int i=0;i<tc;i++){
            String[] input=br.readLine().split("\\s+");
            int n=Integer.parseInt(input[0]);
            int d=Integer.parseInt(input[1]);
            int c=Integer.parseInt(input[2]);

            map=new ArrayList[n+1];
            list=new int[n+1];
            check=new boolean[n+1];
            for(int t=0;t<=n;t++){
                list[t]=Integer.MAX_VALUE;
                map[t]=new ArrayList<>();
            }

            for(int k=0;k<d;k++){
                input=br.readLine().split("\\s+");
                int a=Integer.parseInt(input[0]);
                int b=Integer.parseInt(input[1]);
                int s=Integer.parseInt(input[2]);
                map[b].add(new Node(a,s));
            }

            PriorityQueue<Node>q=new PriorityQueue<>((Node n1,Node n2)->n1.time-n2.time);
            q.add(new Node(c,0));
            list[c]=0;
            while(!q.isEmpty()){
                Node temp=q.poll();
                if (!check[temp.end]){
                    check[temp.end]=true;
                    for(Node val:map[temp.end])
                        if(list[val.end]>list[temp.end]+val.time){
                            list[val.end]=list[temp.end]+val.time;
                            q.add(new Node(val.end,list[val.end]));
                        }
                }
            }

            int comCount=0,timeCount=0;
            for(int r=1;r<=n;r++)
                if(list[r]!=Integer.MAX_VALUE){
                    comCount++;
                    timeCount=Math.max(timeCount,list[r]);
                }

            System.out.println(comCount+" "+timeCount);
        }
    }
}
