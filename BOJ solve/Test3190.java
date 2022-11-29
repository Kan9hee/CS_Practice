import java.util.*;
import java.io.*;

public class Test3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;                                     //��ü ����
    static int size, apple, curve;                          //���� ũ��,��� ��ġ,Ŀ�� ���
    static HashMap<Integer, String> hash = new HashMap<>(); //�Ÿ�, Ŀ�� ��� �ؽ���
	static List<int[]> snake = new ArrayList<>();           //������ũ ������ �� ����,��ġ ǥ����
	static int[] setX = { 0, 1, 0, -1 };
	static int[] setY = { 1, 0, -1, 0 };                    //x,y�� �̵��� �迭

    public static void solve() {
		int cx = 0, cy = 0;
		int count = 0;
		int d = 0;
		snake.add(new int[] { 0, 0 });  //������ġ ����

		while (true) {
			count++;                    //�̵� �� ����
			int tempX = cx + setX[d];   //�̵��� ��ǥ�� x��
			int tempY = cy + setY[d];   //�̵��� ��ǥ�� y��

			if (finCheck(tempX, tempY)) //���� ��ġ�� �浹�� ���
				break;                  //�޼ҵ� ����

			if (map[tempX][tempY] == 1) {               //����� ������ ���
				map[tempX][tempY] = 0;                  //�ش� ��ġ�� ����� ���ش�
				snake.add(new int[] { tempX, tempY });  //���� ���� ���̸� �ø���.
			} else {
				snake.add(new int[] { tempX, tempY });  //�ƴ� ���,
				snake.remove(0);                 //���� ���̴� ������ �ʴ´�.
			}

			if (hash.containsKey(count)) {                  //Ŀ�긦 ���ƾ� �� ��ġ�� �����ߴٸ�
				if (hash.get(count).equals("D"))
					d=(d+1)%4;                              //D�� ��� ��ȸ����,
                else 
					d=(d+3)%4;                              //L�� ��� ��ȸ���� �Ѵ�.
			}

			cx = tempX; //���� ��ǥ ����
			cy = tempY;
		}
		System.out.println(count);  //�� �̵��Ÿ� ��� �� ����.
	}

    public static boolean finCheck(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
			return true;    //�迭�� ���θ��� ��� ���̻� �����ٴ� true�� ��ȯ�Ѵ�.
		}

		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);         //���� �� ���𸶴� Ȯ���Ѵ�.
			if (nx == t[0] && ny == t[1])   //x�� y���� �迭�� ������ �Ѵ���
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		size = Integer.parseInt(br.readLine());
		apple = Integer.parseInt(br.readLine());

		map = new int[size][size];
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = 1;
		}

		curve = Integer.parseInt(br.readLine());

		for (int i = 0; i < curve; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			hash.put(x, c);
		}

		solve();
	}
}