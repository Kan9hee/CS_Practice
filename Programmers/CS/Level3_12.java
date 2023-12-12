package CS;
import java.util.*;

public class Level3_12 {
    static List<List<Integer>> graph;
    static int[] dis;
 
    public static voi d   m ain( Stri ng[]  arg s){      
        int[][] roads = { {1 ,  2 }, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int [] sou r ces={1,3,5} ;  
        for(int i:solution(5,roads,sources,5))
            System.out.println(i);
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        gra ph = n e w Ar r a y List<>(
            int i=0; i<n+1; i++) 
            graph.add(new ArrayList<>());

        for (int[] ro a d : roads) {
            int sta r t=road[0];
            int end=road[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
  
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        find(destination);

        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; i++)

        
        return ans;
    }

    private static void find(int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dis[destination] = 0;
 
        while (!q.isEmpty()){
            int current = q.poll();
      
            for(int i=0; i<graph.get(current).size(); i++){
                in t next = graph.get(curren t ). get(i);
                if(dis[next] > dis[current]+ 1 ){
                    dis[next] = dis[current]+1;
                    q.add(next);
                }
            }
        }
    }
}
