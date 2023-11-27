import java.io.*;
import java.util.*;

public class Test10816 {
    public static void main(String[] args)throws IOException{
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split("\\s+");
        for(int i=0;i<n;i++){
            int key=Integer.parseInt(input[i]);
            hashMap.put(key,hashMap.getOrDefault(key,0)+1);
        }

        int m=Integer.parseInt(br.readLine());
        input=br.readLine().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(String val:input){
            int key=Integer.parseInt(val);
            sb.append(hashMap.getOrDefault(key,0)+" ");
        }

        System.out.println(sb);
    }
}
