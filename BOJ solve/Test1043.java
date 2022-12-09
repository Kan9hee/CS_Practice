import java.io.*;
import java.util.*;

public class Test1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer> truth = new ArrayList<>();
    static ArrayList<Integer>[] party;
    static boolean[] partyCheck, peopleCheck;
    static int people, list, result, temp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        people = Integer.parseInt(st.nextToken());
        list = Integer.parseInt(st.nextToken());
        result = list;

        partyCheck = new boolean[list];
        peopleCheck = new boolean[people + 1];
        party = new ArrayList[list];

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++)
            truth.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < list; i++) {
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            party[i] = new ArrayList<>();

            for (int j = 0; j < count; j++) {
                temp = Integer.parseInt(st.nextToken());
                party[i].add(temp);
            }
        }

        for (int i = 0; i < truth.size(); i++) {
            q.add(truth.get(i));
            peopleCheck[truth.get(i)] = true;
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list; i++) {
                if (partyCheck[i])
                    continue;
                if (!party[i].contains(now))
                    continue;
                for (int j = 0; j < party[i].size(); j++) {
                    int next = party[i].get(j);

                    if (peopleCheck[next])
                        continue;
                    peopleCheck[next] = true;
                    q.add(next);
                }

                partyCheck[i] = true;
                result--;
            }
        }

        System.out.println(result);
    }
}