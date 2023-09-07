import java.io.*;
import java.util.*;

public class Test1325 {
    static ArrayList<Integer>[] computers;
    static int[] ranks;
    static int MaxCount=Integer.MIN_VALUE;
    static int N;
    
    public static void main(String[] args)throws IOException{
        StringBuilder sb=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        computers=new ArrayList[N+1];
        ranks=new int[N+1];

        for(int i=1;i<=N;i++)
            computers[i]=new ArrayList<>();

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            computers[A].add(B);
        }

        for(int start=1;start<N+1;start++)
            BFS(start);

        for(int i=1;i<N+1;i++)
            MaxCount=Math.max(ranks[i], MaxCount);

        for(int i=1;i<N+1;i++)
            if(ranks[i]==MaxCount)
                sb.append(i+" ");
        
        System.out.println(sb);
    }

    private static void BFS(int start){
        Queue<Integer>q=new LinkedList<>();
        boolean[] visit=new boolean[N+1];
        q.add(start);
        visit[start]=true;

        while(!q.isEmpty()){
            int computer=q.poll();
            for(int next:computers[computer])
                if(!visit[next]){
                    q.add(next);
                    visit[next]=true;
                    ranks[next]++;
                }
        }
    }
}
