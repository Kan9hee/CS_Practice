import java.io.*;
import java.util.*;

public class Test11399 {
    public static void main(String[]arg) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int scale=Integer.parseInt(br.readLine());
        int people[]=new int[scale];
        int wait=0,min_sum=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<scale;i++)
            people[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(people);

        for(int i=0;i<scale;i++){
            wait=wait+people[i];
            min_sum+=wait;
        }

        System.out.println(min_sum);
    }
}
