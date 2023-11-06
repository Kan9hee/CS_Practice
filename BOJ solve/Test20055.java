import java.io.*;

public class Test20055 {
    static boolean[] above;
    static int[] A;
    static int N,K;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);
        A=new int[N*2];
        above=new boolean[N];
        
        input=br.readLine().split("\\s+");
        for(int i=0;i<N*2;i++)
            A[i]=Integer.parseInt(input[i]);

        int result=0;
        while(true){
            int check=0;
            for(int i=0;i<N*2;i++)
                if(A[i]==0)
                    check++;
            if(check>=K)
                break;
            
            int swap=A[N*2-1];
            for (int i=N*2-1;i>0;i--)
                A[i]=A[i-1];
            A[0]=swap;

            for(int i=N-1;i>0;i--)
                above[i]=above[i-1];
            above[0]=false;
            above[N-1]=false;

            for(int i=N-1;i>0;i--)
                if(above[i-1]&&!above[i]&&A[i]>=1){
                    above[i]=true;
                    above[i-1]=false;
                    A[i]--;
                }

            if(A[0]>0){
                A[0]--;
                above[0]=true;
            }

            result++;
        }

        System.out.println(result);
    }
}
