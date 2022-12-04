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
        
        int val=dice[2];    //주사위의 윗면
        switch(order) {     //주사위의 이동 방향에 따라 회전한다. 여기서는 배열의 값을 옮기는 것으로 구현한다.
            case 1:         //동쪽 이동
                dice[2] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = val;
                break;
            case 2:         //서쪽 이동
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = val;
                break;
            case 3:         //북쪽 이동
                dice[2] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[0];
                dice[0] = val;
                break;
            case 4:         //남쪽 이동
                dice[2] = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[4];
                dice[4] = val;
                break;
        }
        if(map[tempY][tempX] == 0) {    //주사위를 굴려 이동한 위치의 값이 0일 경우
            map[tempY][tempX] = dice[5];//주사위의 밑면에 있는 값을 해당 위치에 복사한다.
        } else {                        //그러나 이동해 도착한 위치의 값이 0이 아닐 경우
            dice[5] = map[tempY][tempX];//해당 위치의 값을 주사위 밑면의 값으로 하고
            map[tempY][tempX] =0;       //그 위치의 값은 0이 된다.
        }
        System.out.println(dice[2]);    //현재 위치에서 주사위의 윗면에 있는 값을 출력한다.
        diceX=tempX;    //이동한 위치를 갱신한다.
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
    }
}
