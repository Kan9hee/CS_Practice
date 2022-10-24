import java.io.*;
import java.util.*;

public class Test2667 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    static int size,count;
    static int Map[][];
    static int X_temp[]={1,0,-1,0};
    static int Y_temp[]={0,1,0,-1};
    static void search(int y,int x){
        Map[y][x]=0;
        for(int i=0;i<4;i++){
            int tx=x+X_temp[i];
            int ty=y+Y_temp[i];
            if(tx>=0&&tx<size&&ty>=0&&ty<size)
                if(Map[ty][tx]==1){
                    count++;
                    search(ty,tx);
                }
        }
    }

    public static void main(String[] args)throws IOException{
        size=Integer.parseInt(br.readLine());
        Map=new int[size][size];
        for(int i=0;i<size;i++){
            String temp=br.readLine();
            for(int k=0;k<size;k++)
                Map[i][k]=temp.charAt(k)-'0';
        }

        ArrayList<Integer>list=new ArrayList<>();
        count=1;
        for(int i=0;i<size;i++)
            for(int k=0;k<size;k++)
                if(Map[i][k]==1){
                    search(i,k);
                    list.add(count);
                    count=1;
                }
        
        Collections.sort(list);
        sb.append(list.size()+"\n");
        for(int i=0;i<list.size();i++)
            sb.append(list.get(i)+"\n");
        System.out.println(sb);
    }
}
