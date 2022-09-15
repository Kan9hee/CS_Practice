import java.io.*;
import java.util.*;

public class Test1697{
    static Queue<Integer>q=new LinkedList<>();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int su,bro;
    static int already[]=new int[100001];

    static void search(){
        q.add(su);
        while(!q.isEmpty()){
            int place=q.poll();
            if(place==bro){
                break;
            }
            int temp[]={place+1,place-1,place*2};
            for(int i=0;i<3;i++){
                if (temp[i] >= 0 && temp[i] < already.length && already[temp[i]]==0){
                    q.offer(temp[i]);
                    already[temp[i]]=already[place]+1;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        su=Integer.parseInt(st.nextToken());
        bro=Integer.parseInt(st.nextToken());
        search();
        System.out.println(already[bro]);
    }
}