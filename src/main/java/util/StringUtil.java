package util;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {

    public Map<Character, Integer> countDuplicateCharacters(String str) {
        if(str == null) return null;
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
            // at the key 'ch', make usage of a function
            // pass the key 'k', that is equal to 'ch' and the value 'v' at the key 'k' ('ch')
            // if the value 'v' is null then assign 1
            // if the value 'v' is not null, initialized, then assign 'v' + 1
        }
        return result;
    }
}
