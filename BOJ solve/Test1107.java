import java.io.*;
import java.util.*;

public class Test1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean check[] = new boolean[10];   //이용 가능한 수 목록 (0~9)
    static int target, brokenButtons, count;    //목표값, 이용 불가능한 값의 수, 실행 횟수
    static int result = Integer.MAX_VALUE;      //최소 실행 횟수

    static void DFS(int multiple, String chanel) {  //1의 자리부터 10만의 자리까지의 값을 구하고, 목표값과의 최소 거리값을 찾는다.
        for (int i = 0; i < 10; i++)
            if (!check[i]) {    //이용 가능한 수일 경우
                String temp = chanel + Integer.toString(i); //기존 값*10 + 현재 이용 가능한 수
                count = Math.abs(target - Integer.parseInt(temp)) + temp.length();  //실행 횟수 = 목표값-현재값+현재값의 자릿수
                result = Math.min(result, count);   //최소 실행 횟수 갱신
                if (multiple < 6)   //10만의 자리까지 탐색하지 않았다면
                    DFS(multiple + 1, temp); //현재값*10의 1의 자리 경우를 탐색
            }
    }

    public static void main(String[] args) throws IOException {
        target = Integer.parseInt(br.readLine());
        brokenButtons = Integer.parseInt(br.readLine());

        if (brokenButtons > 0) {    //이용 불가능한 값 설정
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenButtons; i++)
                check[Integer.parseInt(st.nextToken())] = true;
        }

        if (target == 100) {    //설정된 초기값은 100으로, 목표값이 같다면 즉시 종료한다.
            System.out.println(0);  //제자리이므로 실행을 하지도 않아 실행 횟수는 0이다.
            return;
        }

        count = Math.abs(100 - target);     //초기값과 목표값의 거리
        result = Math.min(result, count);   //최소 실행 횟수를 임시로 count로 설정한다.
        DFS(0, "");
        System.out.println(result);
    }
}