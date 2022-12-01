import java.io.*;
import java.util.*;

public class Test11404 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int[][] map;         //단방향 거리를 저장할 이중배열
    static int temp=10000001;   //연결되지 않았을 경우의 값 (배열 최대 크기 X 최대 비용 +1)

    public static void main(String[] args)throws IOException{
        int size=Integer.parseInt(br.readLine());   //이중배열의 크기 (최대 100)
        int base=Integer.parseInt(br.readLine());   //배열에 입력할 횟수

        map=new int[size+1][size+1];
        for(int i=1;i<=size;i++){
            Arrays.fill(map[i],temp);   //이중배열의 i번째 행 초기화
            map[i][i]=0;                //자기 자신과의 거리는 0
        }

        for(int i=0;i<base;i++){
            st=new StringTokenizer(br.readLine());
            int ty=Integer.parseInt(st.nextToken());    //출발점
            int tx=Integer.parseInt(st.nextToken());    //도착점
            int value=Integer.parseInt(st.nextToken()); //출발점에서 도착점까지 이동시의 비용 (최대 100,000)
            map[ty][tx]=Math.min(map[ty][tx],value);    //기존 이동비용과 비교해 가장 적은 값으로 갱신
        }

        //Floyd 알고리즘 이용
        for(int check=1;check<=size;check++)
            for(int y=1;y<=size;y++)
                for(int x=1;x<=size;x++)
                    map[y][x]=Math.min(map[y][x],(map[y][check]+map[check][x]));
        
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                if(map[i][j]==temp) //이동 불가능한 경로일 경우 0을 출력한다.
                    sb.append(0).append(" ");
                else
                    sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
