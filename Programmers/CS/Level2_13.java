package CS;

public class Level2_13 {
    public static void main(String[] args) {
        int[][] maps = { { 2, 3 }, { 4, 3 }, { 1, 1 }, { 2, 1 } };

        int[] result = solution(maps);
        for (int i = 0; i < 4; i++)
            System.out.println(result[i]);
    }

    public static int[] solution(int[][] edges) {
        int[] result = new int[4];
        int nodeCount = 0;

        // 전체 그래프 내 정점들의 개수
        for (int i = 0; i < edges.length; i++)
            nodeCount = Math.max(nodeCount, Math.max(edges[i][0], edges[i][1]));

        // 각 노드별 출발 간선 및 도착 간선의 개수
        int[] in = new int[nodeCount + 1];
        int[] out = new int[nodeCount + 1];
        for (int i = 0; i < edges.length; i++) {
            out[edges[i][0]]++;
            in[edges[i][1]]++;
        }

        // 종류별 그래프들로 출발만 하는 노드
        for (int i = 1; i <= nodeCount; i++) {
            if (out[i] - in[i] > 1) {
                result[0] = i;
                break;
            }
        }

        // 다른 노드로 더이상 나아가지 못하는 막대 그래프 개수와
        // 2개의 노드로 출발하며 2개의 노드로부터 도착하는 8자 그래프 개수
        // 출발만 하는 노드로부터 연결되는 것을 감안
        for (int i = 1; i <= nodeCount; i++) {
            if (out[i] == 0 && in[i] > 0)
                result[2]++;
            if (out[i] >= 2 && in[i] >= 2)
                result[3]++;
        }

        // 도넛 그래프의 개수
        // 다른 그래프에 연결은 되었으나, 막대/8자 그래프가 아닌 나머지 그래프
        result[1] = out[result[0]] - (result[2] + result[3]);

        return result;
    }
}
