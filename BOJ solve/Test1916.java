import java.io.*;
import java.util.*;
 
public class Test1916 {
    static class Node implements Comparable<Node> { //���� �迭�� ������ ������ ��� Ŭ����
        int end;    //������ ��ġ
        int value;  //������������ �Ÿ�

        Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override   //�켱���� ť�� �������̵��Ͽ� Node��ü�� ��, �켱���� �����Ѵ�.
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map;  //���� ���� �迭 map
    static int[] distance;  //�������� �Ÿ� ����� �迭. start ������ �׻� 0�̴�.
    static boolean[] check; //�������� �湮 Ȯ�ο� �迭. start ������ ó������ true��.

    static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); //�켱���� ť�� �̿��� ���� ��ġ�� ������ �� ����� �������� �̵��Ѵ�.
        pq.add(new Node(start, 0));//������� �켱����ť�� ����.
        distance[start] = 0;    //������� �Ÿ��� �ڱ� �ڽŰ��� �Ÿ��̹Ƿ� 0�̴�.
 
        while (!pq.isEmpty()) {
            Node temp = pq.poll();  //�켱���� ť���� ���� ��ġ���� ��ȯ
 
            if (!check[temp.end]) { //���� �ش� ������ �湮���� ���� �������� ���
                int valid = temp.end;
                check[valid] = true;//�ش� �������� �湮������ ����Ѵ�.

                for (Node node : map.get(valid)) {
                    if (!check[node.end])   //���� ���� ��ġ���� �� �� �ִ� �������� �湮���� ���� ������ ���
                        if(distance[valid] + node.value < distance[node.end]) { //���� ��ġ�� ������ �� �� �����ٸ�
                            distance[node.end] = distance[valid] + node.value;  //�ش� �������� �Ÿ� ������ �����ϰ�
                            pq.add(new Node(node.end, distance[node.end]));     //�켱���� ť�� �ش� �������� ������ �����Ѵ�.
                    }
                }
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine()); //�ִ� ��ġ ����
        check = new boolean[size + 1];
        distance = new int[size + 1];
        Arrays.fill(distance, size*100000); //��ġ�� �ִ� �Ÿ� ����
 
        map = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            map.add(new ArrayList<>());
        }
 
        int cases = Integer.parseInt(br.readLine());    //��ġ ���� ����
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end, weight));
        }
 
        st = new StringTokenizer(br.readLine());    //ã�� �Ÿ� ����
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(start);
        System.out.println(distance[end]);
        
        br.close();
    }
}
