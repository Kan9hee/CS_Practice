import java.io.*;
import java.util.*;

public class Test5430{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static ArrayList<Integer>al=new ArrayList<>();

    static void ACWorking(String order,int size,String values){
        boolean right=true; //배열이 올바르게 정렬되었는지 확인
        st=new StringTokenizer(values,"[,]");   //입력된 문자열에서 대괄호와 쉼표를 뺀 나머지를 가져온다.
        for(int t=0;t<size;t++)
            al.add(Integer.parseInt(st.nextToken()));   //가져온 수를 ArrayList에 저장한다.
        
        for(int i=0;i<order.length();i++){  //명령어 확인
            if(order.charAt(i)=='R')    //명령어가 R일 경우 정수 배열을 뒤집었다고 가정한다.
                right=!right;
            else{   //명령어가 D일 경우 배열 맨 앞의 값을 없앤다.
                if(al.isEmpty()){   //더이상 뺄 값이 없을 경우 에러 메시지를 남기고 종료한다.
                    sb.append("error\n");
                    return;
                }
                if(right)   //배열이 올바르게 정렬되었을 경우 맨 앞의 값을 없앤다.
                    al.remove(0);
                else    //배열이 뒤집혔다고 가정되었다면 맨 뒤의 값을 없앤다.
                    al.remove(al.size()-1);  
            }
        }
        if(!right)  //명령 종료시에도 뒤집혔다 가정되었으면
            Collections.reverse(al);    //진짜로 뒤집는다.
        sb.append(al.toString().replaceAll("\\s", "")+"\n");    //AllayList를 문자열로 바꾼 뒤, 공백을 없앤다.
    }

    public static void main(String[]args)throws IOException{
        int count=Integer.parseInt(br.readLine());  //반복 횟수

        for(int i=0;i<count;i++){
            String order=br.readLine(); //명령어
            int size=Integer.parseInt(br.readLine());   //배열 크기
            String values=br.readLine();    //배열
            ACWorking(order, size, values);
            al.clear(); //연산 종료 후 잔여 ArrayList값 정리
        }

        System.out.println(sb.toString());  //각 결과 출력
    }
}