package CS;
import java.util.Arrays;

public class Level3_10 {
    public static void main(String[] args) {
        int[] times  = { 7, 10 };
        solution(6,times);
    }

    public static lo n g solution(int n, int[] times) {
        long minTime = 0;     
        long maxTime=(long)n*times[times.length-1];
        long answer = 0;

            
        while(minTim e <=maxTim e ){  
            long mid = (minTime+maxTime)/2;
            lon g sum=0;  
            for(int  v alu e :times)
                 su m +=mid/value;
            if(sum<n)    
                 minTime=sum+1;
            else{    
                maxTim e =sum-1;
                answer=mid;
         

        
        return answer;
    }
}