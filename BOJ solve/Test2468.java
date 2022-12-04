import java.io.*;
import java.util.*;

public class Test2468 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] check;
    static int[] setX={1,-1,0,0};
    static int[] setY={0,0,-1,1};
    static int size,count,height=0,result=0;

    static int DFS(int y,int x,int height){ //영역 묶기용 DFS
        check[y][x] = true;
		for(int i=0; i<4; i++) {
			int nx = x +setX[i];
			int ny = y +setY[i];
			
			if(nx>=0 && ny>=0 && nx<size && ny<size)
                if(!check[ny][nx] && map[ny][nx]>height)
                    DFS(ny,nx, height);
		}
		return 1;   //영역의 개수만 세면 되므로, 해당 영역이 존재한다는 1의 값만 반환한다.
    }

    public static void main(String[] args)throws IOException{
        size=Integer.parseInt(br.readLine());
        map=new int[size][size];

        for(int i=0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

        do{
            count=0;    //매 반복마다 영역의 개수를 0부터 센다.
            check=new boolean[size][size];  //매 반복마다 영역 확인용 이중배열 check를 초기화한다.
            for(int i=0; i<size; i++)
                for(int j=0; j<size; j++)
                    if(!check[i][j]&&map[i][j]>height)  //확인되지 않은 영역에, 높이 조건을 충족시킬 경우
                        count+=DFS(i,j,height);         //그 영역의 크기만큼 check에 표시하고, 영역의 개수를 1 늘린다.
            result=Math.max(result,count);  //이번 반복에서 센 영역과 영역의 최대 개수를 비교해 갱신한다.
            height++;       //매 반복이 끝나면 높이 조건을 1 올린다.
        }while(count!=0);   //셀 수 있는 영역이 없다면 더이상 높이 조건을 충족시킬 수 없다고 간주하여, 반복을 종료한다.

        System.out.println(result); //영역의 최대 개수를 출력한다.
    }
}
