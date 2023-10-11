import java.io.*;
import java.util.*;

public class Test13023 {
    static ArrayList<Integer>[] map;
    static boolean[] check;
    static int mapSize,friendship,answer=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input=br.readLine().split("\\s+");
        mapSize=Integer.parseInt(input[0]);
        friendship=Integer.parseInt(input[1]);

        map=new ArrayList[mapSize];
        check=new boolean[mapSize];
        for(int i=0;i<mapSize;i++)
            map[i]=new ArrayList<Integer>();
        for(int i=0;i<friendship;i++){
            input=br.readLine().split("\\s+");
            map[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            map[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
        }

        for(int i=0;i<mapSize;i++){
            if(answer==0)
                dfs(i,1);
        }

        System.out.println(answer);
    }

    private static void dfs(int start,int count){
        if(count==5){
            answer=1;
            return;
        }

        check[start]=true;
        for(int i:map[start]){
            if(!check[i]&&answer==0)
                dfs(i,count+1);
        }
        check[start]=false;
    }
}
