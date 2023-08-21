import java.util.Arrays;

public class Level3_10 {
    public static void main(String[] args) {
        int[] times = { 7, 10 };
        solution(6,times);
    }

    public static long solution(int n, int[] times) {
        long minTime=0;
        long maxTime=(long)n*times[times.length-1];
        long answer = 0;
        Arrays.sort(times);
        
        while(minTime<=maxTime){
            long mid=(minTime+maxTime)/2;
            long sum=0;
            for(int value:times)
                sum+=mid/value;
            if(sum<n)
                minTime=sum+1;
            else{
                maxTime=sum-1;
                answer=mid;
            }
        }
        
        return answer;
    }
}