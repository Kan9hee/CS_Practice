import java.io.*;
import java.util.*;

public class Test10026 {
    static class Node{
        int x,y;
        Node(int x,int y){this.x=x;this.y=y;}
    }
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static Stack<Node>stack=new Stack<>();
    static char map[][];
    static boolean check[][];
    static int size,count=0;
    static int settingX[]={1,-1,0,0};
    static int settingY[]={0,0,1,-1};

    static void DFS(int x,int y){
        check[y][x]=true;
        for(int i=0;i<4;i++){
            int tempX=x+settingX[i];
            int tempY=y+settingY[i];
            if(tempX<size&&tempX>=0&&tempY<size&&tempY>=0)
                if(!check[tempY][tempX]){
                    if(map[y][x]==map[tempY][tempX])
                        DFS(tempX,tempY);
                    else
                        stack.push(new Node(tempX, tempY));
                }
        }
    }

    public static void main(String[] args)throws IOException{
        size=Integer.parseInt(br.readLine());
        map=new char[size][size];
        check=new boolean[size][size];

        for(int i=0;i<size;i++){
            String temp=br.readLine();
            for(int t=0;t<size;t++)
                map[i][t]=temp.charAt(t);
        }

        stack.push(new Node(0,0));
        while(!stack.isEmpty()){
            Node temp=stack.pop();
            if(!check[temp.y][temp.x]){
                count++;
                DFS(temp.x,temp.y);
            }
        }
        System.out.print(count+" ");

        count=0;
        check=new boolean[size][size];
        for(int i=0;i<size;i++){
            for(int t=0;t<size;t++){
                if(map[i][t]=='R')
                    map[i][t]='G';
            }
        }

        stack.push(new Node(0,0));
        while(!stack.isEmpty()){
            Node temp=stack.pop();
            if(!check[temp.y][temp.x]){
                count++;
                DFS(temp.x,temp.y);
            }
        }
        System.out.print(count);
    }
}