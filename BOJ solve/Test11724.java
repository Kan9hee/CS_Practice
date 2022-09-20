import java.io.*;
import java.util.StringTokenizer;
public class Test11724 {
    static int N;
    static int M;
    static int nodes[][];
    static boolean conected[];

    static void dfs(int head){
        conected[head]=true;
        for(int i=1;i<=N;i++)
            if(nodes[head][i]==1&&!conected[i])
                dfs(i);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        nodes=new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int head=Integer.parseInt(st.nextToken());
            int tail=Integer.parseInt(st.nextToken());
            nodes[head][tail]=1;
            nodes[tail][head]=1;
        }

        conected=new boolean[N+1];
        int count=0;

        for(int i=1;i<=N;i++){
            if(!conected[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
