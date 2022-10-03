import java.io.*;
import java.util.*;
 
public class Test1149 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int[][] rgb;
	static int[][] map;

    //��ȯ �Լ��μ�, ���� �ڽ��� ���� �Ҵ�� ���� ���� ���� �ִ� �ٸ� ���� ���� �ּڰ��� ���Ѵ�.
    //���� ���� ���, ���� ���� ���ļ� �ȵȴ�.
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
        
        //���� �����ϸ� �ؿ��� ���� �ö���� �������� ���߹迭�� Ž���Ѵ�.
        //�� ���򺰷� �� Ž���� ����� �߿��� �ּڰ��� ���Ѵ�.
		System.out.println(Math.min(Paint_cost(count- 1, 0), Math.min(Paint_cost(count - 1, 1), Paint_cost(count - 1, 2))));
	}
}
