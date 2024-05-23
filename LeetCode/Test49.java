package LeetCode;

import java.util.*;

public class Test49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> cases = new HashMap<>();
            for (String str : strs) {
                char[] stArr = str.toCharArray();
                Arrays.sort(stArr);
                String convertedStr = new String(stArr);
                if (!cases.containsKey(convertedStr))
                    cases.put(convertedStr, new ArrayList<>());
                cases.get(convertedStr).add(str);
            }

            return new ArrayList<>(cases.values());
        }
    }
}
