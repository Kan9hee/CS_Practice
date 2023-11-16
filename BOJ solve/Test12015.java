import java.io.*;

public class Test12015 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] list=new int[n];
        String[] input=br.readLine().split("\\s+");
        int length=1;

        for(int i=0;i<n;i++){
            int val=Integer.parseInt(input[i]);
            if(i==0){
                list[0]=val;
                continue;
            }

            if(val>list[length-1]){
                list[length]=val;
                length++;
            }else{
                int low=0,top=length;
                while(low<top){
                    int mid=(low+top)/2;
                    if(list[mid]<val)
                        low=mid+1;
                    else
                        top=mid;
                }
                list[low]=val;
            }
        }

        System.out.println(length);
    }
}
