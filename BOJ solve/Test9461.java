import java.io.*;

public class Test9461 {
    static Long[] list=new Long[101];
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        list[0]=0L;
        list[1]=1L;
        list[2]=1L;
        list[3]=1L;
        list[4]=2L;

        for(int i=0;i<n;i++){
            int request=Integer.parseInt(br.readLine());
            if(list[request]==null)
                System.out.println(search(request));
            else
                System.out.println(list[request]);
        }
    }

    private static long search(int val){
        if(list[val]!=null)
            return list[val];

        int before=(val-1)<0?0:val-1;
        int moreBefore=(val-5)<0?0:val-5;
        list[val]=search(before)+search(moreBefore);
        return list[val];
    }
}
