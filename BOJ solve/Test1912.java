import java.io.*;
import java.util.*;

public class Test1912 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws IOException{
        int size=Integer.parseInt(br.readLine());
        int exam[]=new int[size];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++)
            exam[i]=Integer.parseInt(st.nextToken());

        int temp=exam[0],max=exam[0];
        for(int i=1;i<size;i++){
            temp=Math.max(temp+exam[i],exam[i]);
            max=Math.max(temp, max);
        }
        
        System.out.println(max);
    }
}
