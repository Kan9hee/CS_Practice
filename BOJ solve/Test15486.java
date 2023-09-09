import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test15486 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int result=0;

        int[] DP=new int[N+1];
        int[][] list=new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            list[i][0]=Integer.parseInt(st.nextToken());
            list[i][1]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=N;i++){
            if(result<DP[i])
                result=DP[i];
            if(i!=N){
                int day=i+list[i][0];
                if(day<=N)
                    DP[day]=Math.max(DP[day],result+list[i][1]);
            }
        }

        System.out.println(result);
    }
}
