import java.io.*;
import java.util.*;

public class Test1932 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int size,tree[][];
    public static void main(String[]args)throws IOException{
        size=Integer.parseInt(br.readLine());
        tree=new int[size][size];

        for(int i=0;i<size;i++){
            st=new StringTokenizer(br.readLine());
            for(int t=0;t<i+1;t++)
                tree[i][t]=Integer.parseInt(st.nextToken());
        }

        for(int i=size-2;i>=0;i--){
            int temp1,temp2;
            for(int t=0;t<i+2;t++){
                temp1=tree[i][t]+tree[i+1][t];
                if(t!=i+1)
                    temp2=tree[i][t]+tree[i+1][t+1];
                else
                    temp2=0;
                tree[i][t]=Math.max(temp1,temp2);
            }
        }

        System.out.println(tree[0][0]);
    }
}
