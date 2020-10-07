package util;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void givenStringNotNull_whenCountDuplicateCharactersForeach_thenOK() {
        Map<Character, Long> result = new StringUtil().countDuplicateCharactersForeach("HelloWorld!");
        assertCountOK(result);
    }
    @Test
    public void givenStringNotNull_whenCountDuplicateCharactersStream_thenOK() {
        Map<Character, Long> result = new StringUtil().countDuplicateCharactersStream("HelloWorld!");
        assertCountOK(result);
    }

    private void assertCountOK(Map<Character, Long> result) {
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.get('H')).isEqualTo(1);
        assertThat(result.get('e')).isEqualTo(1);
        assertThat(result.get('l')).isEqualTo(3);
        assertThat(result.get('o')).isEqualTo(2);
        assertThat(result.get('W')).isEqualTo(1);
        assertThat(result.get('r')).isEqualTo(1);
        assertThat(result.get('d')).isEqualTo(1);
        assertThat(result.get('!')).isEqualTo(1);
        assertThat(result.get('a')).isNull(); // returning a null if the key is absent
    }

    @Test
    public void givenStringNull_whenCountDupCharForeach_thenResultIsNull() {
        Map<Character, Long> result = new StringUtil().countDuplicateCharactersForeach(null);
        assertThat(result).isNull();
    }

    @Test
    public void givenEmptyStringNull_whenCountDupCharForEach_thenResultIsEmpty() {
        Map<Character, Long> result = new StringUtil().countDuplicateCharactersForeach("");
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
    }

    @Test
    public void givenStringNull_whenCountDupCharStream_thenResultIsNull() {
        Map<Character, Long> result = new StringUtil().countDuplicateCharactersStream(null);
        assertThat(result).isNull();
    }

    @Test
    public void givenEmptyStringNull_whenCountDupCharStream_thenResultIsEmpty() {
        Map<Character, Long> result = new StringUtil().countDuplicateCharactersStream("");
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
    }
}