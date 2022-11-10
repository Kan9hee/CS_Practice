import java.io.*;
import java.util.*;

public class Test15686 {    //�迭 ������ �״�� ������� �ʵ��� ��������. �����̶� ��� �ð��� ���̴� ���� �߿��ϴ�.
    static class Node {//�迭�� x,y�� ��� ������ Ŭ����ȭ�Ͽ� ����Ѵ�.
        int x, y;
        public Node(int y, int x) {
            this.x=x;
            this.y=y;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int map[][];     //��ü ����
	static int n,m, answer; //���� ��� ����, ��ǥ � ������, �ִ� ����
	static ArrayList<Node> chicken, house;  //���� �� ����, ���� ��ġ�� �̷���� ���Ḯ��Ʈ
	static Stack<Node> select;  //������ ���� ����

    static void find(int start, int depth) {
		if(depth == m) {    //��ǥ � ���������� ��ȸ���� ���
			int sum = 0;
			for(int i=0; i<house.size(); i++) {
				int y1 = house.get(i).y;
				int x1 = house.get(i).x;
				int min = Integer.MAX_VALUE;
				for(Node s : select) {
					int y2 = s.y;
					int x2 = s.x;
                    int distance=Math.abs(y1-y2) + Math.abs(x1-x2); //���� ���õ� ������ �Ÿ��� �������� ���Ѵ�.
					min = Math.min(min, distance);  //�ּڰ� ����
				}
				sum += min; //���������� ���õ� �������� �Ÿ��� ���տ� ����.
			}
			answer = Math.min(answer, sum); //��������� ����
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			select.push(new Node(chicken.get(i).y, chicken.get(i).x));  //���õ� ������ ���ÿ� �ִ´�.
			find(i+1, depth+1); //��ȸ
			select.pop();//���ÿ� ���� ���� ������ ����.
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
