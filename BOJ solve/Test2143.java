import java.io.*;
import java.util.*;

public class Test2143 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long T=Integer.parseInt(br.readLine());
        String[] input;
        long val;

        int[] A=new int[Integer.parseInt(br.readLine())];
        long[] ASums=new long[A.length*(A.length+1)/2];
        input=br.readLine().split("\\s+");
        for(int i=0,sumCount=0;i<A.length;i++){
            A[i]=Integer.parseInt(input[i]);
            val=0;
            for(int point=i;point>=0;point--){
                val+=A[point];
                ASums[sumCount++]=val;
            }
        }
        Arrays.sort(ASums);
        
        int[] B=new int[Integer.parseInt(br.readLine())];
        long[] BSums=new long[B.length*(B.length+1)/2];
        input=br.readLine().split("\\s+");
        for(int i=0,sumCount=0;i<B.length;i++){
            B[i]=Integer.parseInt(input[i]);
            val=0;
            for(int point=i;point>=0;point--){
                val+=B[point];
                BSums[sumCount++]=val;
            }
        }
        Arrays.sort(BSums);

        long result=0;
        for(int i=0;i<ASums.length;){
            long currentASum=ASums[i];
            long aTerm = upperBound(ASums, currentASum)-lowerBound(ASums, currentASum);
            long bTerm = upperBound(BSums, T-currentASum)-lowerBound(BSums, T-currentASum);
            result+=aTerm*bTerm;
            i+=aTerm;
        }

        System.out.println(result);
    }

    private static int upperBound(long[] arr,long val) {
		int left=0, right=arr.length; 
		while(left<right) {
			int mid=(left+right)/2;
			if(val>=arr[mid])
				left=mid+1;
			else
				right=mid;
		}

		return right;
	}

    static int lowerBound(long[] arr, long val) {
		int left=0, right=arr.length; 
		while(left<right) {
			int mid=(left+right)/2;
			if(val<=arr[mid])
				right=mid;
			else
				left=mid+1;
		}

		return right;
	}
}
