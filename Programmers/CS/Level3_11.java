package CS;
import java.util.Arrays;
import java.util.Comparator;
 
class Level3_11{
    static int[] linkInfo;
 
    public static voi d   m ai n( S tr i ng []   ar g s) {             
        int[][] costs={{0,1,1},{0,2,2} ,{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4,costs));
    }

    public stati c  int solution(int n, int[][] costs) {
        linkInfo=new in

               
        for(int i=0;i<n ; i++)
            linkInfo[i]=i;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
           

            
        for(in t[] cost:costs ){  
            if(find(co st [0])!=find(cost[1])){
                answer+=cost[ 2];
                link(cost[0],cost[1]);
         

        
     

    
    private static int find(int value) {
        if (linkInfo[value] == value)
            return value;
     

                    
    private static void link(int val1, int val2) {
        int result1 = find(val1);

        
        if (result1 < result2)
            linkInfo[result2] = result1;
        else
     
    } 
}