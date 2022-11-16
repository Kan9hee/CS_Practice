import java.io.*;
import java.util.*;

public class Test2580{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int map[][]=new int[9][9];
    
    static void solve(int y, int x) {
		if(x == 9){ //행 하나의 탐색이 끝날 경우, 다음 열번째 행의 0번 index로 이동한다.
			solve(y+1,0);
			return;
		}
 
		if (y == 9){    //모든 행렬의 탐색이 끝날 경우, 결과를 출력하고 종료한다.
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
 
		if (map[y][x] == 0) {   //채워야 할 공간을 발견 시 행, 열, 3x3부분행렬에 겹치는 값이 있는지 확인하고 값을 결정한다.
			for (int i = 1; i <= 9; i++) {
				if (find(y, x, i)) {
					map[y][x] = i;
					solve(y, x + 1);    //결정 후 다음 index로 이동한다.
				}
			}
			return;
		}
 
		solve(y, x + 1);
	}
 
	static boolean find(int y, int x, int value) {
        int ty = y - y % 3; //속한 부분행렬의 초기 y 위치값
		int tx = x - x % 3; //속한 부분행렬의 초기 x 위치값

		for (int i = 0; i < 9; i++) //속한 행에서 겹치는 값 확인
			if (map[y][i] == value)
				return false;
 
		for (int i = 0; i < 9; i++) //속한 열에서 겹치는 값 확인
			if (map[i][x] == value)
				return false;
 
		for (int i = ty; i < ty + 3; i++)   //속한 부분행렬에서 겹치는 값 확인
			for (int j = tx; j < tx + 3; j++)
				if (map[i][j] == value)
					return false;

		return true;
	}
 
	public static void main(String[] args)throws IOException{
		for (int y = 0; y < 9; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < 9; x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
 
		solve(0, 0);
	}
}