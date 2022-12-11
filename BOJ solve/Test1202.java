import java.io.*;
import java.util.*;

public class Test1202 {
    static class Jewel implements Comparable<Jewel> {   //������ ����
		int weight,price;
		private Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		@Override
		public int compareTo(Jewel o) { //JewelŬ���� Ÿ������ ���Ľ� �������̵��� compareTo�޼ҵ�
			return this.weight - o.weight;
		}
	}

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
    static Jewel[] list;
    static int[] bags;
    static int jewelCount,bagCount,index=0;
    static long result=0L;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		jewelCount = Integer.parseInt(st.nextToken());
		bagCount = Integer.parseInt(st.nextToken());
		list = new Jewel[jewelCount];
		bags = new int[bagCount];

		for (int i = 0; i < jewelCount; i++) {
			st = new StringTokenizer(br.readLine());
            int weight=Integer.parseInt(st.nextToken());
            int price=Integer.parseInt(st.nextToken());
			list[i] = new Jewel(weight,price);
		}
        Arrays.sort(list);  //���� �迭 ������������ ����

		for (int i = 0; i < bagCount; i++)
			bags[i] = Integer.parseInt(br.readLine());
		Arrays.sort(bags);  //���� �迭 ������������ ����

		for (int i = 0; i < bagCount; i++) {                                //���� ���濡��
			while (index < jewelCount && list[index].weight <= bags[i]) {   //���� ���� �ʾҰ� ������ ��Ƽ�� �߷��� ������ ���
				pq.add(list[index].price);  //�켱���� ť�� �ش� ������ ��ġ�� �����Ѵ�.
				index++;
			}
			if (!pq.isEmpty())  //�켱���� ť�� �̿��� ���� ���濡 ���� �� �ִ� �ִ� ��ġ�� ������ ���Ѵ�.
                result += pq.poll();    //���� �������� ��ġ ���� ����
		}
		System.out.println(result);
	}
}