import java.util.*;
import java.io.*;

public class Test3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;                                     //전체 지도
    static int size, apple, curve;                          //지도 크기,사과 위치,커브 명령
    static HashMap<Integer, String> hash = new HashMap<>(); //거리, 커브 명령 해쉬맵
	static List<int[]> snake = new ArrayList<>();           //스네이크 게임의 뱀 길이,위치 표현용
	static int[] setX = { 0, 1, 0, -1 };
	static int[] setY = { 1, 0, -1, 0 };                    //x,y축 이동용 배열

    public static void solve() {
		int cx = 0, cy = 0;
		int count = 0;
		int d = 0;
		snake.add(new int[] { 0, 0 });  //현재위치 저장

		while (true) {
			count++;                    //이동 수 갱신
			int tempX = cx + setX[d];   //이동한 좌표의 x축
			int tempY = cy + setY[d];   //이동한 좌표의 y축

			if (finCheck(tempX, tempY)) //현재 위치가 충돌할 경우
				break;                  //메소드 종료

			if (map[tempX][tempY] == 1) {               //사과를 만났을 경우
				map[tempX][tempY] = 0;                  //해당 위치의 사과를 없앤다
				snake.add(new int[] { tempX, tempY });  //이후 뱀의 길이를 늘린다.
			} else {
				snake.add(new int[] { tempX, tempY });  //아닐 경우,
				snake.remove(0);                 //뱀의 길이는 변하지 않는다.
			}

			if (hash.containsKey(count)) {                  //커브를 돌아야 할 위치에 도달했다면
				if (hash.get(count).equals("D"))
					d=(d+1)%4;                              //D일 경우 우회전을,
                else 
					d=(d+3)%4;                              //L일 경우 좌회전을 한다.
			}

			cx = tempX; //현재 좌표 갱신
			cy = tempY;
		}
		System.out.println(count);  //총 이동거리 출력 후 종료.
	}

    public static boolean finCheck(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
			return true;    //배열의 변두리일 경우 더이상 못간다는 true를 반환한다.
		}

		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);         //뱀의 각 마디마다 확인한다.
			if (nx == t[0] && ny == t[1])   //x나 y축이 배열의 범위를 넘는지
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