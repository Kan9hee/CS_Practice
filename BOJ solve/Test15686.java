import java.io.*;
import java.util.*;

public class Test15686 {    //배열 정보를 그대로 사용하지 않도록 주의하자. 조금이라도 계산 시간을 줄이는 것이 중요하다.
    static class Node {//배열의 x,y축 노드 정보를 클래스화하여 사용한다.
        int x, y;
        public Node(int y, int x) {
            this.x=x;
            this.y=y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int map[][];     //전체 지도
	static int n,m, answer; //지도 행렬 길이, 목표 운영 점포수, 최단 길이
	static ArrayList<Node> chicken, house;  //지도 내 점포, 집의 위치로 이루어진 연결리스트
	static Stack<Node> select;  //선택한 점포 스택

    static void find(int start, int depth) {
		if(depth == m) {    //목표 운영 점포수까지 순회했을 경우
			int sum = 0;
			for(int i=0; i<house.size(); i++) {
				int y1 = house.get(i).y;
				int x1 = house.get(i).x;
				int min = Integer.MAX_VALUE;
				for(Node s : select) {
					int y2 = s.y;
					int x2 = s.x;
                    int distance=Math.abs(y1-y2) + Math.abs(x1-x2); //집과 선택된 점포의 거리를 절댓값으로 더한다.
					min = Math.min(min, distance);  //최솟값 갱신
				}
				sum += min; //최종적으로 선택된 점포와의 거리를 총합에 삽입.
			}
			answer = Math.min(answer, sum); //최종결과값 갱신
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			select.push(new Node(chicken.get(i).y, chicken.get(i).x));  //선택된 점포를 스택에 넣는다.
			find(i+1, depth+1); //순회
			select.pop();//스택에 넣은 점포 정보를 뺀다.
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		map = new int[n][n];
		answer = Integer.MAX_VALUE;
		select = new Stack<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new Node(i, j));
				}
				else if(map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}

		find(0, 0);
		System.out.println(answer);
	}
}
