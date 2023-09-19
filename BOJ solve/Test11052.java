import java.io.*;
import java.util.StringTokenizer;

public class Test11052 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] p=new int[N+1];
        int[] d=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
            p[i]=Integer.parseInt(st.nextToken());

        for (int i=1;i<=N;i++)
            for (int j=1;j<=i;j++)
                d[i] = Math.max(d[i],d[i-j]+p[j]);
        
        System.out.println(d[N]);
    }
}
