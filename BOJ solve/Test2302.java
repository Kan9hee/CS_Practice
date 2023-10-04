import java.io.*;

public class Test2302 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int list[]=new int[N+1];
        list[0]=1;
        list[1]=1;
        for(int i=2;i<=N;i++)
            list[i]=list[i-1]+list[i-2];

        int M=Integer.parseInt(br.readLine());
        int result=1,last=0;
        for(int i=0;i<M;i++){
            int ban=Integer.parseInt(br.readLine());
            result*=list[ban-last-1];
            last=ban;
        }
        result*=list[N-last];

        System.out.println(result);
    }
}
