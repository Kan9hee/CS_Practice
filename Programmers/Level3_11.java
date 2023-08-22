import java.util.Arrays;
import java.util.Comparator;

class Level3_11{
    static int[] linkInfo;

    public static void main(String[] args){
        int[][] costs={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4,costs));
    }

    public static int solution(int n, int[][] costs) {
        linkInfo=new int[n];
        int answer = 0;
        
        for(int i=0;i<n;i++)
            linkInfo[i]=i;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        for(int[] cost:costs){
            if(find(cost[0])!=find(cost[1])){
                answer+=cost[2];
                link(cost[0],cost[1]);
            }
        }
        
        return answer;
    }
    
    private static int find(int value) {
        if (linkInfo[value] == value)
            return value;
        return find(linkInfo[value]);
    }
                    
    private static void link(int val1, int val2) {
        int result1 = find(val1);
        int result2 = find(val2);
        
        if (result1 < result2)
            linkInfo[result2] = result1;
        else
            linkInfo[result1] = result2;
    } 
}