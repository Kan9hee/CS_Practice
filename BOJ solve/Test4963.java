import java.io.*;
import java.util.*;

public class Test4963 {
    static int[][] map;
    static boolean[][] check;
    static int[] xMove={1,0,-1,0,1,1,-1,-1};
    static int[] yMove={0,1,0,-1,1,-1,-1,1};
    static int mapX,mapY;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        while(true){
            input=br.readLine().split("\\s+");
            if(input[0].equals("0")&&input[1].equals("0"))
                break;
            mapX=Integer.parseInt(input[0]);
            mapY=Integer.parseInt(input[1]);
        
            map=new int[mapY][mapX];
            check=new boolean[mapY][mapX];

            for(int i=0;i<mapY;i++){
                input=br.readLine().split("\\s+");
                for(int j=0;j<mapX;j++)
                    map[i][j]=Integer.parseInt(input[j]);
            }

            int result=0;
            for(int i=0;i<mapY;i++)
                for(int j=0;j<mapX;j++)
                    if(!check[i][j]&&map[i][j]==1){
                        DFS(i,j);
                        result++;
                    }
            
            System.out.println(result);
        }
    }

    private static void DFS(int y,int x){
        Stack<int[]>stack=new Stack<>();
        stack.push(new int[]{y,x});

        while(!stack.isEmpty()){
            int[] temp=stack.pop();
            check[temp[0]][temp[1]]=true;

            for(int i=0;i<8;i++){
                int nx=temp[1]+xMove[i];
                int ny=temp[0]+yMove[i];
                if(nx>=0&&ny>=0&&nx<mapX&&ny<mapY)
                    if(!check[ny][nx]&&map[ny][nx]==1)
                        stack.push(new int[]{ny,nx});
            }
        }
    }
}
