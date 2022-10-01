import java.io.*;
import java.util.*;

public class Test10845 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer>q=new LinkedList<>();

    public static void main(String[]args)throws IOException{
        int work=Integer.parseInt(br.readLine());
        int save;

        for(int i=0;i<work;i++){
            st=new StringTokenizer(br.readLine());
            String order=st.nextToken();
            switch(order){
                case "push":q.add(Integer.parseInt(st.nextToken()));break;
                case "pop":
                    if(q.isEmpty())
                        save=-1;
                    else
                        save=q.poll();
                    System.out.println(save);
                break;
                case "size":System.out.println(q.size());break;
                case "empty":System.out.println((q.isEmpty())?1:0);break;
                case "front":
                    if(q.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(q.peek());
                    break;
                case "back":
                    if(q.isEmpty())
                        System.out.println(-1);
                    else{
                        Object[] temp=q.toArray();
                        System.out.println(temp[q.size()-1]);
                    }
                    break;
            }
        }
    }
}
