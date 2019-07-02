package DBFS;

import java.util.*;

public class No17dianhuahaoma {
    Map<Character, List<String>> map=null;

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return resList;
        }
        map = new HashMap<Character, List<String>>(){};
        map.put('2',Arrays.asList("a","b","c"));
        map.put('3',Arrays.asList("d","e","f"));
        map.put('4',Arrays.asList("g","h","i"));
        map.put('5',Arrays.asList("j","k","l"));
        map.put('6',Arrays.asList("m","n","o"));
        map.put('7',Arrays.asList("p","q","r","s"));
        map.put('8',Arrays.asList("t","u","v"));
        map.put('9',Arrays.asList("w","x","y","z"));
        List<String> list = new ArrayList<>();
        dfs(resList, list, digits.toCharArray(), 0);
        return resList;
    }

    private void dfs(List<String> resList, List<String> list, char[] digits, int level) {
        if (list.size() == digits.length) {
            StringBuffer sb = new StringBuffer();
            for (String str :
                    list) {
                sb.append(str);
            }
            resList.add(sb.toString());
            return;
        }
        List<String> letters = map.get(digits[level]);
        for (String letter :
                letters) {
            list.add(letter);
            dfs(resList, list, digits, level + 1);
            list.remove(list.size() - 1);
        }
    }
}
