import java.io.*;
import java.util.*;
 
public class Test1149 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int[][] rgb;
	static int[][] map;

    //순환 함수로서, 현재 자신의 색에 할당된 값과 윗쪽 층에 있는 다른 색을 비교해 최솟값을 구한다.
    //노드는 이전 노드, 다음 노드와 겹쳐선 안된다.
    static int Paint_cost(int N, int color) {
		if(map[N][color] == 0) {
			if(color == 0)
                map[N][0] = Math.min(Paint_cost(N-1, 1), Paint_cost(N-1, 2)) + rgb[N][0];
			else if(color == 1)
                map[N][1] = Math.min(Paint_cost(N-1, 0), Paint_cost(N-1, 2)) + rgb[N][1];
			else
                map[N][2] = Math.min(Paint_cost(N-1, 0), Paint_cost(N-1, 1)) + rgb[N][2];
		}
		return map[N][color];
	}
	
	public static void main(String[] args) throws IOException {
		int count = Integer.parseInt(br.readLine());
		rgb = new int[count][3];
		map = new int[count][3];
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			for(int t=0;t<3;t++)
			    rgb[i][t] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<3;i++)
            map[0][i]=rgb[0][i];
        
        //맵을 역행하며 밑에서 위로 올라오는 형식으로 이중배열을 탐색한다.
        //각 색깔별로 맵 탐색한 결과물 중에서 최솟값을 구한다.
		System.out.println(Math.min(Paint_cost(count- 1, 0), Math.min(Paint_cost(count - 1, 1), Paint_cost(count - 1, 2))));
	}
}
