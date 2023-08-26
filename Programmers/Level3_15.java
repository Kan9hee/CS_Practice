import java.util.*;

class Music {
    int genreCount;
    int play;
    int index;

    public Music(int genreCount, int play, int index) {
        this.genreCount = genreCount;
        this.play = play;
        this.index = index;
    }
}

public class Level3_15 {
    public static void main(String[] args) {
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        for (int i : solution(genres, plays)) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Comparator<Music> genreCompare = (s1, s2) -> s2.genreCount - s1.genreCount;
        Comparator<Music> playCompare = (s1, s2) -> s2.play - s1.play;
        HashMap<String, Integer> genrePlayMap = new HashMap<>();
        ArrayList<Music> playList = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int genreMax = 0, before = 0;

        for (int i = 0; i < genres.length; i++)
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);

        for (int i = 0; i < genres.length; i++)
            playList.add(new Music(genrePlayMap.get(genres[i]), plays[i], i));

        Collections.sort(playList, genreCompare.thenComparing(playCompare));

        for (int i = 0; i < genres.length; i++) {
            Music gen = playList.get(i);
            if (before != gen.genreCount) {
                before = gen.genreCount;
                genreMax = 0;
            }
            if (genreMax == 2)
                continue;
            genreMax++;
            answer.add(gen.index);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
