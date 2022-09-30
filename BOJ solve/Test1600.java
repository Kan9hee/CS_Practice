import java.io.*;

public class Test1600 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException{
        /*long size,target;
        size=Integer.parseInt(br.readLine());
        target=Integer.parseInt(br.readLine())+1;

        long width,height;
        if(target%size!=0){
            height=(target/size)+1;
            width=(target%size);
        }else{
            height=(target/size);
            width=size;
        }
        System.out.println(width*height);*/

        //이분탐색을 통해 전체 배열에서 탐색 범위를 좁혀가
        //본래 이중배열이 가리키는 값을 찾는다.
        int size=Integer.parseInt(br.readLine());
        int target=Integer.parseInt(br.readLine());

        int start=1,end=target;
        while(start < end)
        {
            int cnt = 0;
            int mid = (start + end) / 2;
            
            for(int i=1;i<=size;i++)
                cnt += Math.min(mid / i, size);
            
            if(cnt >= target)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println(start);
    }
}
