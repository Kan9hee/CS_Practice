import java.io.*;
import java.util.*;

public class Test1931 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer,Integer>map=new HashMap<>();
    static Object keys[];
    static int find(int num,int count){
        count++;
        System.out.println(count);
        int key=(int)keys[num];
        int val=map.get(key);
        while(val>=key){
            if(num+1!=keys.length)
                key=(int)keys[num++];
            else
                break;
        }
        if(num+1<8)
            find(key,count);
        return count;
    }

    public static void main(String[]args)throws IOException{
        int test=Integer.parseInt(br.readLine());
        int MAX=0;
        for(int i=0;i<test;i++){
            st=new StringTokenizer(br.readLine());
            int pre_key=Integer.parseInt(st.nextToken());
            int pre_val=Integer.parseInt(st.nextToken());
            if(map.get(pre_key)!=null){
                int low=Math.min(pre_val,map.get(pre_key));
                map.replace(pre_key,low);
            }else{
                map.put(pre_key,pre_val);
            }
        }
        keys=map.keySet().toArray();
        Arrays.sort(keys);
        for(int i=0;i<keys.length;i++){
            int temp=find(i,0);
            MAX=Math.max(MAX, temp);
        }
        System.out.println(MAX);
    }
}
