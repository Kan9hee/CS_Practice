import java.io.*;

public class Test11727 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] list=new int[n+1];
        list[0]=1;
        list[1]=1;
        for(int i=2;i<=n;i++)
            list[i]=(list[i-1]+list[i-2]*2)%10007;

        System.out.println(list[n]);
    }
}
