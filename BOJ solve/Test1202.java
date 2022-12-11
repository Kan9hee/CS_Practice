import java.io.*;
import java.util.*;

public class Test1202 {
    static class Jewel implements Comparable<Jewel> {   //보석의 정보
		int weight,price;
		private Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		@Override
		public int compareTo(Jewel o) { //Jewel클래스 타입으로 정렬시 오버라이딩할 compareTo메소드
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
        Arrays.sort(list);  //보석 배열 오름차순으로 정렬

		for (int i = 0; i < bagCount; i++)
			bags[i] = Integer.parseInt(br.readLine());
		Arrays.sort(bags);  //가방 배열 오름차순으로 정렬

		for (int i = 0; i < bagCount; i++) {                                //현재 가방에서
			while (index < jewelCount && list[index].weight <= bags[i]) {   //아직 넣지 않았고 가방이 버티는 중량의 보석일 경우
				pq.add(list[index].price);  //우선순위 큐에 해당 보석의 가치를 저장한다.
				index++;
			}
			if (!pq.isEmpty())  //우선순위 큐를 이용해 현재 가방에 넣을 수 있는 최대 가치의 보석을 취한다.
                result += pq.poll();    //취한 보석들의 가치 총합 갱신
		}
		System.out.println(result);
	}
}