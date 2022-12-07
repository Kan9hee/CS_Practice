import java.io.*;
import java.util.*;
 
public class Test1916 {
    static class Node implements Comparable<Node> { //가변 배열에 저장할 목적지 노드 클래스
        int end;    //목적지 위치
        int value;  //목적지까지의 거리

        Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override   //우선순위 큐에 오버라이딩하여 Node객체를 비교, 우선도를 결정한다.
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> map;  //이중 가변 배열 map
    static int[] distance;  //목적지별 거리 저장용 배열. start 지점은 항상 0이다.
    static boolean[] check; //목적지별 방문 확인용 배열. start 지점은 처음부터 true다.

    static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐를 이용해 현재 위치를 경유시 더 가까운 목적지로 이동한다.
        pq.add(new Node(start, 0));//출발지를 우선순위큐에 삽입.
        distance[start] = 0;    //출발지점 거리는 자기 자신과의 거리이므로 0이다.
 
        while (!pq.isEmpty()) {
            Node temp = pq.poll();  //우선순위 큐에서 지역 위치정보 반환
 
            if (!check[temp.end]) { //만약 해당 지역이 방문하지 않은 목적지일 경우
                int valid = temp.end;
                check[valid] = true;//해당 목적지를 방문했음을 기록한다.

                for (Node node : map.get(valid)) {
                    if (!check[node.end])   //만약 현재 위치에서 갈 수 있는 목적지가 방문하지 않은 상태일 경우
                        if(distance[valid] + node.value < distance[node.end]) { //현재 위치를 경유할 때 더 가깝다면
                            distance[node.end] = distance[valid] + node.value;  //해당 목적지의 거리 정보를 갱신하고
                            pq.add(new Node(node.end, distance[node.end]));     //우선순위 큐에 해당 목적지의 정보를 삽입한다.
                    }
                }
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        int size = Integer.parseInt(br.readLine()); //최대 위치 개수
        check = new boolean[size + 1];
        distance = new int[size + 1];
        Arrays.fill(distance, size*100000); //위치별 최대 거리 설정
 
        map = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            map.add(new ArrayList<>());
        }
 
        int cases = Integer.parseInt(br.readLine());    //위치 정보 설정
        for (int i = 0; i < cases; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end, weight));
        }
 
        st = new StringTokenizer(br.readLine());    //찾을 거리 정보
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(start);
        System.out.println(distance[end]);
        
        br.close();
    }
}
