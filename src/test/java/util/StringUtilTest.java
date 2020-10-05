package util;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void givenStringNotNull_whenCountDuplicateCharacters_thenOK() {
        Map<Character, Integer> result = new StringUtil().countDuplicateCharacters("HelloWorld!");
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
    public void givenStringNull_whenCountDuplicateCharacters_thenResultIsNull() {
        Map<Character, Integer> result = new StringUtil().countDuplicateCharacters(null);
        assertThat(result).isNull();
    }

    @Test
    public void givenEmptyStringNull_whenCountDuplicateCharacters_thenResultIsEmpty() {
        Map<Character, Integer> result = new StringUtil().countDuplicateCharacters("");
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
    }
}