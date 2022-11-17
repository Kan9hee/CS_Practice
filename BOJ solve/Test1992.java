import java.io.*;

public class Test1992 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static char map[][];
    static int setX[]={0,1,0,1};
    static int setY[]={0,0,1,1};

    static String quadTree(int y,int x,int search){ //���߹迭�� 4������ �κй迭�� ���� ����� ���ڿ��� �����Ѵ�.
        StringBuilder sb=new StringBuilder();
        String list[]=new String[4];
        search/=2;  //���߹迭�� ������ ����

        if(search==1){  //�� �̻� search�� ���� �� ���� ���, �ּ� �κй迭�� �����Ѵ�.
            for(int i=0;i<4;i++)
                list[i]=String.valueOf(map[y+setY[i]][x+setX[i]]);  //�ּ� �κй迭�� �� 4���� �д´�.
            if(list[0].equals(list[1])&&list[1].equals(list[2])&&list[2].equals(list[3]))
                return list[0]; //���� ���� ��� ���� ���, �� �� �ϳ��� ��ȯ�Ѵ�.
            else{
                sb.append("(");
                for(int i=0;i<4;i++)
                    sb.append(list[i]);
                sb.append(")");
                return sb.toString();   //���� ���� ���� �ٸ� ���, �Ұ�ȣ ���� ���������� ��ġ�Ͽ� ��ȯ�Ѵ�.
            }
        }

        boolean check=true; //���ڿ� ���� ���� Ȯ�ο� ����
        for(int i=0;i<4;i++){
            list[i]=quadTree(y+setY[i]*search, x+setX[i]*search, search);
            if(i>0)
                if(list[i].length()>1||!list[i].equals(list[0]))
                    check=false;    //���� �о�� ���� �Ұ�ȣ�� �ѷ��ο��ų� ���� ���� ���� ���� ���, check�� false�� �ٲ۴�.
        }
        
        if(check)
            return list[0]; //���� ���� ��� ���� ���, �� �� �ϳ��� ��ȯ�Ѵ�.
        else{
            sb.append("(");
            for(int i=0;i<4;i++)
                sb.append(list[i]);
            sb.append(")");
            return sb.toString();   //���� ���� ���� �ٸ� ���, �Ұ�ȣ ���� ���������� ��ġ�Ͽ� ��ȯ�Ѵ�.
        }
    }

    public static void main(String[] args)throws IOException{
        int size=Integer.parseInt(br.readLine());
        map=new char[size][size];

        for(int y=0;y<size;y++){
            String temp=br.readLine();  //���߹迭�� 1���� ���ڿ��� �д´�.
            map[y]=temp.toCharArray();  //���ڿ��� map�� y���� char�� �迭�� ��ġ�Ѵ�.
        }

        System.out.println(quadTree(0, 0, size));
    }
}