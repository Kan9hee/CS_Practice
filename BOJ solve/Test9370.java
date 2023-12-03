import java.io.*;
import java.util.*;

public class Test9370 {
    static class Node{
        int end,val;
        Node(int end,int val){
            this.end=end;
            this.val=val;
        }
    }

    static ArrayList<Integer> candidates;
    static ArrayList<Node>[] map;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine()); //test case

        for(int i=0;i<T;i++){
            String[] input=br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]); //node count
            int m = Integer.parseInt(input[1]); //value count
            int t = Integer.parseInt(input[2]); //candidates count

            candidates=new ArrayList<>();
            map=new ArrayList[n+1];

            for(int count=0;count<=n;count++)
                map[count]=new ArrayList<>();

            input=br.readLine().split("\\s+");
            int s = Integer.parseInt(input[0]); //start
            int g = Integer.parseInt(input[1]); //contain node start
            int h = Integer.parseInt(input[2]); //contain node end

            for(int v=0;v<m;v++){
                input=br.readLine().split("\\s+");
                int a = Integer.parseInt(input[0]); //start
                int b = Integer.parseInt(input[1]); //end
                int d = Integer.parseInt(input[2]); //val
                d*=2;
                if((a==g&&b==h)||(a==h&&b==g))
                    d-=1;
                map[a].add(new Node(b,d));
                map[b].add(new Node(a,d));
            }

            for(int c=0;c<t;c++)
                candidates.add(Integer.parseInt(br.readLine()));

            PriorityQueue<Node> Djikstra = new PriorityQueue<>((Node n1,Node n2)->n1.val-n2.val);
            int[] list=new int[n+1];
            Arrays.fill(list,2000000000); //if insert MAX_VALUE, it considered an incorrect answer.
            Djikstra.add(new Node(s,0));
            list[s]=0;
            while(!Djikstra.isEmpty()){
                Node temp=Djikstra.poll();
                if(list[temp.end]<temp.val)
                    continue;
                for(Node next:map[temp.end]){
                    if(list[next.end]>list[temp.end]+next.val){
                        list[next.end]=list[temp.end]+next.val;
                        Djikstra.add(new Node(next.end,list[next.end]));
                    }
                }
            }

            StringBuilder st=new StringBuilder();
            Collections.sort(candidates);
            for(int ans:candidates)
                if(list[ans]%2==1)
                    st.append(ans+" ");
            System.out.println(st);
        }
    }
}
