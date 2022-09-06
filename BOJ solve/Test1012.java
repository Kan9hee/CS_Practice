import java.io.*;
import java.util.*;

public class Test1012{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int width,height,baechu; //배추밭의 가로,세로,심어진 배추 수
    static int soilland[][];    //배추밭 이중배열
    static int spot[][];    //심어진 배추 위치
    static int dx[]={1,-1,0,0}; //재귀함수에 쓰일 x축 설정 배열
    static int dy[]={0,0,1,-1}; //재귀함수에 쓰일 y축 설정 배열

    //배추밭 내의 유효공간 확인용 함수
    static int AvailableCheck(int x_value,int y_value){
        soilland[x_value][y_value]=2;
        for(int i=0;i<4;i++){
            int x = x_value + dx[i];
            int y = y_value + dy[i];
            if(x>=0&&y>=0&&x<width&&y<height)
                if(soilland[x][y]==1)
                    AvailableCheck(x, y);
        }
        return 1;
    }

    //테스트케이스 설정 및 결과 도출 함수
    static int TestCase()throws IOException{
        int worm=0;
        st=new StringTokenizer(br.readLine());
        width=Integer.parseInt(st.nextToken());
        height=Integer.parseInt(st.nextToken());
        soilland=new int[width][height];
        baechu=Integer.parseInt(st.nextToken());
        spot=new int[baechu][2];
        for(int i=0;i<baechu;i++){
            st=new StringTokenizer(br.readLine());
            spot[i][0]=Integer.parseInt(st.nextToken());
            spot[i][1]=Integer.parseInt(st.nextToken());
            soilland[spot[i][0]][spot[i][1]]=1;
        }
        for(int i=0;i<baechu;i++){
            if(soilland[spot[i][0]][spot[i][1]]==1)
                worm+=AvailableCheck(spot[i][0],spot[i][1]);
        }
        return worm;
    }

    public static void main(String[] args)throws IOException{
        int testcount=Integer.parseInt(br.readLine());
        for(int i=0;i<testcount;i++){
            System.out.println(TestCase());
        }
    }
}