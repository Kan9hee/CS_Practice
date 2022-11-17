import java.io.*;

public class Test1992 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static char map[][];
    static int setX[]={0,1,0,1};
    static int setY[]={0,0,1,1};

    static String quadTree(int y,int x,int search){ //이중배열을 4분할한 부분배열을 통해 출력할 문자열을 구성한다.
        StringBuilder sb=new StringBuilder();
        String list[]=new String[4];
        search/=2;  //이중배열을 분할할 범위

        if(search==1){  //더 이상 search를 나눌 수 없을 경우, 최소 부분배열로 간주한다.
            for(int i=0;i<4;i++)
                list[i]=String.valueOf(map[y+setY[i]][x+setX[i]]);  //최소 부분배열의 값 4개를 읽는다.
            if(list[0].equals(list[1])&&list[1].equals(list[2])&&list[2].equals(list[3]))
                return list[0]; //읽은 값이 모두 같을 경우, 그 중 하나를 반환한다.
            else{
                sb.append("(");
                for(int i=0;i<4;i++)
                    sb.append(list[i]);
                sb.append(")");
                return sb.toString();   //읽은 값이 서로 다를 경우, 소괄호 내에 순차적으로 배치하여 반환한다.
            }
        }

        boolean check=true; //문자열 구성 여부 확인용 변수
        for(int i=0;i<4;i++){
            list[i]=quadTree(y+setY[i]*search, x+setX[i]*search, search);
            if(i>0)
                if(list[i].length()>1||!list[i].equals(list[0]))
                    check=false;    //만약 읽어온 값이 소괄호에 둘러싸였거나 이전 값과 같지 않을 경우, check를 false로 바꾼다.
        }
        
        if(check)
            return list[0]; //읽은 값이 모두 같을 경우, 그 중 하나를 반환한다.
        else{
            sb.append("(");
            for(int i=0;i<4;i++)
                sb.append(list[i]);
            sb.append(")");
            return sb.toString();   //읽은 값이 서로 다를 경우, 소괄호 내에 순차적으로 배치하여 반환한다.
        }
    }

    public static void main(String[] args)throws IOException{
        int size=Integer.parseInt(br.readLine());
        map=new char[size][size];

        for(int y=0;y<size;y++){
            String temp=br.readLine();  //이중배열의 1행을 문자열로 읽는다.
            map[y]=temp.toCharArray();  //문자열을 map의 y열에 char형 배열로 배치한다.
        }

        System.out.println(quadTree(0, 0, size));
    }
}