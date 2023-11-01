import java.io.*;

public class Test1669 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] bottomUp=new int[N+1];
        for(int i=0;i<=N;i++)
            bottomUp[i]=i;

        for(int i=1;i<=N;i++)
            for(int j=1;j*j<=i;j++)
                bottomUp[i]=Math.min(bottomUp[i],bottomUp[i-j*j]+1);
        //if N is 11
        //  1 to 11
        //  bu[1]=1
        //  bu[2]=2
        //  ..
        //  bu[4]=min(4,bu[4-4]+1)=1
        //If j can be squared, initialize bottomUp[i] to 1 each time
        
        System.out.println(bottomUp[N]);
    }
}