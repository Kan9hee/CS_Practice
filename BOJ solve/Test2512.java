import java.io.*;
import java.util.*;

public class Test2512 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] list=new int[n];
        String[] input=br.readLine().split("\\s+");
        for(int i=0;i<n;i++)
            list[i]=Integer.parseInt(input[i]);
        Arrays.sort(list);
        long m=Integer.parseInt(br.readLine());

        int min=1, max=list[n-1];
        while(min<=max){
            int mid=(min+max)/2;
            long sum=0;
            for(int val:list){
                if(val>mid)
                    sum+=mid;
                else
                    sum+=val;
            }
            if(sum<=m)
                min=mid+1;
            else
                max=mid-1;
        }

        System.out.println(max);
    }
}
