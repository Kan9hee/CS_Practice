import java.io.*;
import java.util.*;

public class Test2583 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static PriorityQueue<Integer>list=new PriorityQueue<>();
    static boolean map[][]; //이중배열
    static int mapX,mapY,count=0;   //이중배열 x,y축 크기, 갯수 측정용 변수
    static int setX[]={1,-1,0,0};   //x축 이동용 배열
    static int setY[]={0,0,1,-1};   //y축 이동용 배열

    static void inputBoxs(int stx,int sty,int ex,int ey){   //비활성 영역 설정
        for(int i=sty;i<ey;i++)
            for(int t=stx;t<ex;t++)
                map[i][t]=true;
    }

    static void check(int x,int y){
        map[y][x]=true; //현재 위치 방문 확인
        count++;    //이어진 위치 갯수 갱신
        for(int i=0;i<4;i++){
            int tmpX=x+setX[i];
            int tmpY=y+setY[i];
            if(tmpX>=0&&tmpX<mapX&&tmpY>=0&&tmpY<mapY&&!map[tmpY][tmpX])
                check(tmpX, tmpY);  //이중 배열 내이며, false인 위치일 경우 재귀호출
        }
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        mapY=Integer.parseInt(st.nextToken());
        mapX=Integer.parseInt(st.nextToken());
        int boxs=Integer.parseInt(st.nextToken());
        map=new boolean[mapY][mapX];

        for(int i=0;i<boxs;i++){
            st=new StringTokenizer(br.readLine());
            int info[]=new int[4];  //주어진 값에 따른 영역 비활성화
            for(int t=0;t<4;t++)    //info[0],info[1] 부터  info[2],info[3]까지의 배열을 비활성화한다.
                info[t]=Integer.parseInt(st.nextToken());
            inputBoxs(info[0], info[1], info[2], info[3]);
        }

        for(int i=0;i<mapY;i++)
            for(int t=0;t<mapX;t++)
                if(!map[i][t]){ //현재 위치가 false일 경우
                    check(t,i); //현재 위치부터 활성화된 구역의 크기를 측정, 비활성화한다.
                    list.add(count);    //우선순위큐에 측정된 구역크기를 저장한다.
                    count=0;    //다음 측정을 위한 초기화
                }
        
        count=list.size();  //우선순위 큐 내의 구역들의 수
        sb.append(count+"\n");
        for(int i=0;i<count;i++)
            sb.append(list.poll()+" ");

        System.out.println(sb.toString());
    }
}
