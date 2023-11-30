import java.io.*;
import java.util.*;

public class Test1920{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] A=new int[n];
        String[] input=br.readLine().split("\\s+");
        for(int i=0;i<n;i++)
            A[i]=Integer.parseInt(input[i]);
        Arrays.sort(A);
        
        int m=Integer.parseInt(br.readLine());
        input=br.readLine().split("\\s+");
        for(int i=0;i<m;i++){
            int start=0, end=n, check=0;
            int val=Integer.parseInt(input[i]);

            while(start<end){
                int mid=(start+end)/2;
                if(A[mid]==val){
                    check=1;
                    break;
                }
                else if(A[mid]<val)
                    start=mid+1;
                else if(A[mid]>val)
                    end=mid;
            }

            System.out.println(check);
        }
    }
}
