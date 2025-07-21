package CS;

public class Level2_16 {
    public static void main(String[] args) {
        int[] diffs = { 1, 5, 3 };
        int[] times = { 2, 4, 7 };
        System.out.println(solution(diffs, times, 30));
    }

    private static int solution(int[] diffs, int[] times, long limit) {
        int min = 1; 
        int max = 300000;
        
        while(min<max){
            int level = (int) (min+max)/2;
            long usedTime=0;
            
            for(int i=0;i<diffs.length;i++){
                if(diffs[i]<=level)
                    usedTime+=times[i];
                else{
                    int wrongCount = diffs[i]-level;
                    int currentTime = (times[i]+times[i-1])*wrongCount + times[i];
                    usedTime+=currentTime;
                }
            }
            
            if(usedTime<=limit)
                max=level;
            else
                min=level+1;
        }
        
        return max;
    }
}
