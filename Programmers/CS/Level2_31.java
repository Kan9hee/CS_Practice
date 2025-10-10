package CS;

public class Level2_31 {
    public String solution(String p) {
        return calculate(p);
    }

    public String calculate(String target) {
        if (target.isEmpty())
            return target;

        int cutLine = rule2(target);
        String u = target.substring(0, cutLine);
        String v = target.substring(cutLine);

        return isCorrect(u) ? u + calculate(v) : '(' + calculate(v) + ')' + rule4_4(u);
    }

    public int rule2(String w) {
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            count += (w.charAt(i) == '(') ? 1 : -1;
            if (count == 0)
                return i + 1;
        }
        return w.length();
    }

    public String rule4_4(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            char cur = (u.charAt(i) == '(') ? ')' : '(';
            sb.append(cur);
        }
        return sb.toString();
    }

    public boolean isCorrect(String u) {
        int count = 0;
        for (char c : u.toCharArray()) {
            count += (c == '(') ? 1 : -1;
            if (count < 0)
                return false;
        }
        return true;
    }
}
