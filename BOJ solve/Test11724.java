import java.io.*;
import java.util.StringTokenizer;
public class Test11724{
    static int N;
    static int M;
    static int nodes[][];
    static boolean connected[];

    //그래프 내의 연결된 간선을 통하여
    //connect배열의 (정점 번호)번째 요소를 true로 한다.
    static void dfs(int head){
        connected[head]=true;
        for(int i=1;i<=N;i++)
            if(nodes[head][i]==1&&!connected[i])
                dfs(i);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        nodes=new int[N+1][N+1];

        //선언한 두 정점은 서로 오갈 수 있는 간선으로 이어져
        //이중 배열에서 두 값을 바꾼 경우도 1로 한다.
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int head=Integer.parseInt(st.nextToken());
            int tail=Integer.parseInt(st.nextToken());
            nodes[head][tail]=1;
            nodes[tail][head]=1;
        }

        connected=new boolean[N+1];
        int count=0;

        //정점 1에서부터 N까지 세며
        //i번째 connected배열에서 true였는지를 통해
        //그 정점이 다른 정점과 이어졌는지를 분석한다.
        //false일 경우, 지금까지 센 정점들과 이어지지 않았다고 간주한다.
        //최소 1개의 그래프는 만들어진다.
        for(int i=1;i<=N;i++){
            if(!connected[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}