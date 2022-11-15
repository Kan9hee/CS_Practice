import java.io.*;
import java.util.*;

public class Test14503 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int lengthX,lengthY,way,count=1,map[][];
    static int setX[]={0,1,0,-1};   //0은 북쪽, 1은 동쪽 2는 남쪽, 3은 서쪽을 의미하며,
    static int setY[]={-1,0,1,0};   //각 방향으로 갔을 경우의 위치 변환 값이다.

    static void cleaner(int x,int y){
        map[y][x]=-1;   //청소한 위치의 값을 -1로 하여 벽, 빈공간과 구분한다.
        int tempx,tempy;

        for(int i=0;i<4;i++){
            way=(way+3)%4;  //좌로 1회전한다.
            tempx=x+setX[way];  //
            tempy=y+setY[way];  //회전 후 직진시의 위치다.
            if(tempx >=0 && tempx < lengthX && tempy >= 0 && tempy < lengthY)
                if(map[tempy][tempx] == 0){ //map배열 내 빈 공간일 경우
                    count++;    //청소 성공 횟수 + 1
                    cleaner(tempx,tempy);   //해당 위치로 이동
                    return;
                }
        }

        int reverseWay=(way+2)%4;   //현재 바라보는 위치의 반대 방향. 앞선 for문에서 4방향을 다 바라보고 원래 방향으로 돌아왔기에 가능.
        tempx=x+setX[reverseWay];
        tempy=y+setY[reverseWay];
        if(tempx >= 0 && tempx < lengthX && tempy >= 0 && tempy < lengthY && map[tempy][tempx] != 1)
            cleaner(tempx, tempy);  //반대 방향으로 나아갔을 때 벽이 아닐 경우 그 위치로 이동한다.
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        lengthY=Integer.parseInt(st.nextToken());
        lengthX=Integer.parseInt(st.nextToken());
        map=new int[lengthY][lengthX];

        st=new StringTokenizer(br.readLine());
        int tempy=Integer.parseInt(st.nextToken());
        int tempx=Integer.parseInt(st.nextToken());
        way=Integer.parseInt(st.nextToken());

        for(int i=0;i<lengthY;i++){
            st=new StringTokenizer(br.readLine());
            for(int t=0;t<lengthX;t++)
                map[i][t]=Integer.parseInt(st.nextToken());
        }

        cleaner(tempx, tempy);
        System.out.println(count);
    }
}
