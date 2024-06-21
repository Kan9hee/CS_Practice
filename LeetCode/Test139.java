package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, Boolean>());
    }

    private boolean DFS(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (s.isEmpty())
            return true;

        if (memo.containsKey(s))
            return memo.get(s);

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String nextString = s.substring(word.length());
                if (DFS(nextString, wordDict, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }
}
