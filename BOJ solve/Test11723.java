import java.io.*;
import java.util.*;

public class Test11723 {
    static Set<Integer>arr=new HashSet<>();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int count;
    static String option,value;

    /*
     이번 문제에서는 매우 낮은 메모리 제한을 가진다.
     HashSet을 이용해 중복되는 수의 접근을 막고,
     BufferedReader,BufferedWritter를 통해 
     입출력시 필요한 메모리를 낮춘다.
     */
    public static void main(String[]args)throws IOException{
        count=Integer.parseInt(br.readLine());
        Set<Integer>all=new HashSet<>(); //all연산 수행시 바꿀 정수들의 set
        for(int i=1;i<=20;i++)
            all.add(i);

        for(int i=0;i<count;i++){
            st=new StringTokenizer(br.readLine());
            option=st.nextToken();

            if(st.hasMoreTokens()){
                int temp=Integer.parseInt(st.nextToken());
                switch(option){
                case"add":
                    arr.add(temp);
                    break;
                case"remove":
                    arr.remove(temp);
                    break;
                case"check":
                    if(arr.contains(temp))
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case"toggle":
                    if(arr.contains(temp))
                        arr.remove(temp);
                    else
                        arr.add(temp);
                    break;
                }
            }else{
                switch(option){
                case"all":
                    arr=all;
                    break;
                case"empty":
                    arr.clear();
                    break;
                }
            }
        }
        bw.flush();
    }
}