import java.io.*;
import java.util.*;

public class Test1987 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] alphaCheck=new boolean[26];
    static int[][] map;
    static int[] setX={1,0,-1,0};
    static int[] setY={0,1,0,-1};
    static int mapX,mapY,result=0;

    static void solve(int x,int y,int count){   //현재 x좌표, y좌표, 이동 횟수
        if(alphaCheck[map[y][x]]){          //만약 현재 좌표의 값을 이미 거쳤을 경우
            result=Math.max(result,count);  //이동 횟수를 통해 최대 이동 횟수를 갱신한다.
            return;                         //이후 메소드를 반환한다.
        }
        alphaCheck[map[y][x]]=true; //현재 좌표의 값을 거쳤음을 기록한다.
        count++;                    //이동 횟수를 갱신한다.
        for(int i=0;i<4;i++){   
            int tempX=x+setX[i];    //다음으로 이동할 x좌표
            int tempY=y+setY[i];    //다음으로 이동할 y좌표
            if(tempX>=0&&tempX<mapX&&tempY>=0&&tempY<mapY)
                solve(tempX,tempY,count);   //x,y좌표가 유효할 경우, solve를 순환호출한다.
        }
        alphaCheck[map[y][x]]=false;//반환 전, 값 갱신을 위한 현재 좌표 기록 초기화
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        mapY=Integer.parseInt(st.nextToken());
        mapX=Integer.parseInt(st.nextToken());
        map=new int[mapY][mapX];

        for(int i=0;i<mapY;i++){
            String temp=br.readLine();
            for(int t=0;t<mapX;t++){
                map[i][t]=temp.charAt(t)-'A';
            }
        }

        solve(0,0,0);
        System.out.println(result);
    }
}
