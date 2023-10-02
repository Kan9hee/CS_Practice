import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test14889 {
    static int N;
    static int map[][];
    static boolean check[];
    static long result=Long.MAX_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        check=new boolean[N];

        for(int i=0;i<N;i++){
            String[] temp=br.readLine().split("\\s+");
            for(int j=0;j<N;j++)
                map[i][j]=Integer.parseInt(temp[j]);
        }

        search(0, 0);
        System.out.println(result);
    }

    private static void search(int idx,int stack){
        if(stack==N/2){
            int start=0, link=0;
            for(int i=0;i<N-1;i++)
                for(int j=i+1;j<N;j++){
                    if(check[i]&&check[j])
                        start+=(map[i][j]+map[j][i]);
                    else if(!check[i]&&!check[j])
                        link+=(map[i][j]+map[j][i]);
                }
            
            int temp=Math.abs(start-link);
            if(temp==0){
                System.out.println(0);
                System.exit(0);
            }
            result=Math.min(result, temp);
            return;
        }

        for(int i=idx;i<N;i++){
            if(!check[i]){
                check[i]=true;
                search(i+1, stack+1);
                check[i]=false;
            }
        }
    }
}
