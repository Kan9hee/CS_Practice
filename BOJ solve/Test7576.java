import java.io.*;
import java.util.*;

public class Test7576 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<xy>q=new LinkedList<>();
    static int x,y,result=0;
    static int space[][];
    static int x_set[]={0,0,-1,1};
    static int y_set[]={-1,1,0,0};
    static boolean unfinished;

    static class xy{
        int x;
        int y;
        public xy(int yi,int xi){
            x=xi;
            y=yi;
        }
    }

    public static void main(String[]args)throws IOException{
        st=new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        space=new int[y][x];

        for(int i=0;i<y;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<x;k++){
                space[i][k]=Integer.parseInt(st.nextToken());
                if(space[i][k]==1)
                    q.add(new xy(i,k));
            }
        }

        while(!q.isEmpty()){
            xy temp=q.remove();
            int temp_x=temp.x;
            int temp_y=temp.y;
            
            for(int i=0;i<4;i++){
                int tx=temp_x+x_set[i];
                int ty=temp_y+y_set[i];

                if(tx>=0&&tx<x&&ty>=0&&ty<y)
                    if(space[ty][tx]==0){
                        q.add(new xy(ty,tx));
                        space[ty][tx]=space[temp_y][temp_x]+1;
                    }
            }
        }

        for(int i=0;i<y;i++){
            for(int k=0;k<x;k++){
                if(space[i][k]==0)
                    unfinished=true;
                result=Math.max(result,space[i][k]);
            }
        }
        if(unfinished)
            System.out.println(-1);
        else
            System.out.println(result-1);
    }
}
