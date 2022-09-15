import java.io.*;
import java.util.*;
public class Test2630 {
    static int white=0,blue=0;
    static int AllWhite[]={0,0,0,0},AllBlue[]={1,1,1,1};
    static int paper[][];

    static boolean check(int size,int x,int y){
        int color=paper[x][y];
        for(int i=x;i<x+size;i++)
            for(int k=y;k<y+size;k++)
                if(paper[i][k]!=color)
                    return false;
        return true;
    }

    static void find(int size,int x,int y){
        if(check(size,x,y)){
            if(paper[x][y]==1)
                blue++;
            else
                white++;
            return;
        }
        size/=2;
        find(size,x,y);
        find(size,x+size,y);
        find(size,x,y+size);
        find(size,x+size,y+size);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size=Integer.parseInt(br.readLine());
        paper=new int[size][size];
        for(int i=0;i<size;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<size;k++)
                paper[i][k]=Integer.parseInt(st.nextToken());
        }
        find(size,0,0);
        System.out.println(white);
        System.out.println(blue);
    }
}
