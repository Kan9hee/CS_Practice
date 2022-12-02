import java.io.*;
import java.util.*;

public class Test14499 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int[][] map;
    static int[] setX={1,-1,0,0};
    static int[] setY={0,0,-1,1};
    static int[] dice=new int[6];
    static int mapX,mapY,diceX,diceY;

    static void moveDice(int order){
        int tempX=diceX+setX[order-1];
        int tempY=diceY+setY[order-1];
        if(tempX>=mapX||tempX<0||tempY>=mapY||tempY<0)
            return;
        
        int val=dice[2];
        switch(order) {
            case 1:
                dice[2] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = val;
                break;
            case 2:
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = val;
                break;
            case 3:
                dice[2] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[0];
                dice[0] = val;
                break;
            case 4:
                dice[2] = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[4];
                dice[4] = val;
                break;
        }
        if(map[tempY][tempX] == 0) {
            map[tempY][tempX] = dice[5];
        } else {
            dice[5] = map[tempY][tempX];
            map[tempY][tempX] =0;
        }
        sb.append(dice[2]).append("\n");
        diceX=tempX;
        diceY=tempY;
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());

        mapY=Integer.parseInt(st.nextToken());
        mapX=Integer.parseInt(st.nextToken());
        map=new int[mapY][mapX];

        diceX=Integer.parseInt(st.nextToken());
        diceY=Integer.parseInt(st.nextToken());

        int order=Integer.parseInt(st.nextToken());

        for(int i=0;i<mapY;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<mapX;j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<order;i++){
            int temp=Integer.parseInt(st.nextToken());
            moveDice(temp);
        }

        System.out.println(sb.toString());
    }
}
