import java.io.*;
import java.util.*;

public class Test1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean check[] = new boolean[10];   //�̿� ������ �� ��� (0~9)
    static int target, brokenButtons, count;    //��ǥ��, �̿� �Ұ����� ���� ��, ���� Ƚ��
    static int result = Integer.MAX_VALUE;      //�ּ� ���� Ƚ��

    static void DFS(int multiple, String chanel) {  //1�� �ڸ����� 10���� �ڸ������� ���� ���ϰ�, ��ǥ������ �ּ� �Ÿ����� ã�´�.
        for (int i = 0; i < 10; i++)
            if (!check[i]) {    //�̿� ������ ���� ���
                String temp = chanel + Integer.toString(i); //���� ��*10 + ���� �̿� ������ ��
                count = Math.abs(target - Integer.parseInt(temp)) + temp.length();  //���� Ƚ�� = ��ǥ��-���簪+���簪�� �ڸ���
                result = Math.min(result, count);   //�ּ� ���� Ƚ�� ����
                if (multiple < 6)   //10���� �ڸ����� Ž������ �ʾҴٸ�
                    DFS(multiple + 1, temp); //���簪*10�� 1�� �ڸ� ��츦 Ž��
            }
    }

    public static void main(String[] args) throws IOException {
        target = Integer.parseInt(br.readLine());
        brokenButtons = Integer.parseInt(br.readLine());

        if (brokenButtons > 0) {    //�̿� �Ұ����� �� ����
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenButtons; i++)
                check[Integer.parseInt(st.nextToken())] = true;
        }

        if (target == 100) {    //������ �ʱⰪ�� 100����, ��ǥ���� ���ٸ� ��� �����Ѵ�.
            System.out.println(0);  //���ڸ��̹Ƿ� ������ ������ �ʾ� ���� Ƚ���� 0�̴�.
            return;
        }

        count = Math.abs(100 - target);     //�ʱⰪ�� ��ǥ���� �Ÿ�
        result = Math.min(result, count);   //�ּ� ���� Ƚ���� �ӽ÷� count�� �����Ѵ�.
        DFS(0, "");
        System.out.println(result);
    }
}