import java.io.*;

public class Test9663 {
    static int map[]; //express 2-dimensional array as 1-dimensional array
    static int N, answer=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N];

        find(0);
        System.out.println(answer);
    }

    private static void find(int count){
        if(count==N){
            answer++;
            return;
        }

        for(int i=0;i<N;i++){
            map[count]=i;
            if(check(count))
                find(count+1);
        }
    }

    private static boolean check(int row){
        for(int i=0;i<row;i++){
            if(map[row]==map[i])
                return false;
            else if(Math.abs(row-i)==Math.abs(map[row]-map[i]))
                return false;
        }

        return true;
    }
}
