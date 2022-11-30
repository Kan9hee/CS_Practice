import java.io.*;
import java.util.*;

public class Test2110 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] list;               //위치 리스트
    static int size,router,result=0; //리스트 크기, 물건 개수, 결과값

    static void getDistance(){
        int min=1;              
        int max=list[size-1];

        while(min<=max){            //최솟값과 최댓값이 교차하기 전까지 반복한다.
            int mid=(max+min)/2;    //매 반복마다 최대값과 최솟값의 중간값을 구한다.

            if(check(mid)){         //중간값을 검증한 결과 물건 개수를 커버 가능할 경우
                result=Math.max(result,mid);    //결과값을 기존 결과값과 mid값 중 큰 값으로 갱신한다.
                min=mid+1;          //최솟값을 mid+1로 갱신한다.
            }else                   //커버 불가능할 경우
                max=mid-1;          //최댓값을 mid-1로 갱신한다.
        }
    }

    static boolean check(int val){  //getDistance에서 mid의 값을 확인하는 메소드.
        int count=1;
        int index=0;

        for(int i=0;i<size-1;i++){
            if(list[index]+val<=list[i+1]){ //중간값과 index번째 list값을 합친 값이 i+1번째 리스트 값보다 작다는 것은
                count++;                    //그 중간값을 적절한 값으로 판단해
                index=i+1;                  //count값을 1 올리고, index값을 i+1로 갱신
            }
        }

        if(count>=router)   //count값이 물건의 갯수보다 클 경우, 그만큼 커버가 가능하다는 것으로 간주한다.
            return true;
        else
            return false;
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        size=Integer.parseInt(st.nextToken());
        router=Integer.parseInt(st.nextToken());
        
        list=new int[size];
        for(int i=0;i<size;i++)
            list[i]=Integer.parseInt(br.readLine());
        Arrays.sort(list);  //list에 입력한 위치를 오름차순으로 정렬한다.

        getDistance();
        System.out.println(result);
    }
}
