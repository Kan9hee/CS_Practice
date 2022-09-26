import java.io.*;
import java.util.*;

public class Test18870{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static Map<Integer,Integer>zip=new HashMap<>();
    static int count,rank;
    static int origin[],sorted[];

    public static void main(String[] args)throws IOException{
        count=Integer.parseInt(br.readLine());
        origin=new int[count];
        sorted=new int[count];
        rank=0;
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<count;i++)
            sorted[i]=origin[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(sorted);

        for(int i=0;i<count;i++)
            if(!zip.containsKey(sorted[i]))
                zip.put(sorted[i], rank++);

        for(int i=0;i<count;i++){
            int temp=zip.get(origin[i]);
            sb.append(Integer.toString(temp));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}