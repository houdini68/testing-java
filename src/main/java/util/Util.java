package util;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class Util {

    private static final String TRUE = "true";
    private static final String FALSE = "false";

    private static final Map<String, String> mapBoolean
            = ImmutableMap.of(
                    "0", FALSE,
                    "1", TRUE,
                    FALSE, FALSE,
                    TRUE, TRUE);

    String mapToBoolean(String value, String defaultValue) {
        return mapBoolean.getOrDefault(value.toLowerCase().trim(), defaultValue);
    }

}
