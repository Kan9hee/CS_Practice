import java.io.*;
import java.util.*;

public class Test2580{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int map[][]=new int[9][9];
    
    static void solve(int y, int x) {
		if(x == 9){ //�� �ϳ��� Ž���� ���� ���, ���� ����° ���� 0�� index�� �̵��Ѵ�.
			solve(y+1,0);
			return;
		}
 
		if (y == 9){    //��� ����� Ž���� ���� ���, ����� ����ϰ� �����Ѵ�.
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
 
		if (map[y][x] == 0) {   //ä���� �� ������ �߰� �� ��, ��, 3x3�κ���Ŀ� ��ġ�� ���� �ִ��� Ȯ���ϰ� ���� �����Ѵ�.
			for (int i = 1; i <= 9; i++) {
				if (find(y, x, i)) {
					map[y][x] = i;
					solve(y, x + 1);    //���� �� ���� index�� �̵��Ѵ�.
				}
			}
			return;
		}
 
		solve(y, x + 1);
	}
 
	static boolean find(int y, int x, int value) {
        int ty = y - y % 3; //���� �κ������ �ʱ� y ��ġ��
		int tx = x - x % 3; //���� �κ������ �ʱ� x ��ġ��

		for (int i = 0; i < 9; i++) //���� �࿡�� ��ġ�� �� Ȯ��
			if (map[y][i] == value)
				return false;
 
		for (int i = 0; i < 9; i++) //���� ������ ��ġ�� �� Ȯ��
			if (map[i][x] == value)
				return false;
 
		for (int i = ty; i < ty + 3; i++)   //���� �κ���Ŀ��� ��ġ�� �� Ȯ��
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