import java.util.*;

public class Test9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String base = sc.nextLine();
        String target = sc.nextLine();
        int targetStringLength = target.length();
        int index = 0;
        char[] resultArray = new char[base.length()];

        for (int i = 0; i < base.length(); i++) {
            resultArray[index] = base.charAt(i);
            index++;
            if (index >= targetStringLength) {
                boolean isMatch = true;
                for (int j = 0; j < targetStringLength; j++) {
                    if (resultArray[index - targetStringLength + j] != target.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch)
                    index -= targetStringLength;
            }
        }

        if (index == 0)
            System.out.println("FRULA");
        else {
            for (int i = 0; i < index; i++)
                sb.append(resultArray[i]);
            System.out.println(sb);
        }

        sc.close();
    }
}
