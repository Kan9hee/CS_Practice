import java.io.*;
import java.util.*;

public class Test10815 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        int[] nList=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nList[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(nList);
        
        int M=Integer.parseInt(br.readLine());
        String[] mList=br.readLine().split("\\s+");

        for(String val:mList){
            int mindex=0, maxdex=N-1;
            boolean check=false;
            while(mindex<=maxdex){
                int index=(maxdex+mindex)/2;
                if(Integer.parseInt(val)>nList[index])
                    mindex=index+1;
                else if(Integer.parseInt(val)<nList[index])
                    maxdex=index-1;
                else{
                    check=true;
                    break;
                }
            }
            String result=check?"1 ":"0 ";
            sb.append(result);
        }

        System.out.println(sb);
    }
}