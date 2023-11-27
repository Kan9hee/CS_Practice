import java.io.*;
import java.util.*;

public class Test2805{
    static int[] list;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);
        list=new int[n];
        
        input=br.readLine().split("\\s+");
        for(int i=0;i<n;i++)
            list[i]=Integer.parseInt(input[i]);
        Arrays.sort(list);

        int min=0;
        int max=list[n-1];

        while(min<max){
            int mid=(min+max)/2;
            long sum=0;
            for(int i:list)
                if(i-mid>0)
                    sum+=(i-mid);
            if(sum<m)
                max=mid;
            else
                min=mid+1;
        }
        
        System.out.println(min-1);
    }
}