package api.com.google.common.base;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @Test
    public void givenFunctionOnDateAndString_thenReturnString() {

        // by Google Guava
        com.google.common.base.Function<Date, String> functionGuava
                = dateGuava -> new SimpleDateFormat("dd/MM/yyyy").format(dateGuava);
        Date date = new Date(1585031976022L);
        String simpleDateFormatGuava = functionGuava.apply(date);
        assertThat(simpleDateFormatGuava).isEqualTo("24/03/2020");

        // by Java
        java.util.function.Function<Date, String> functionJava
                = dateJava -> new SimpleDateFormat("dd/MM/yyyy").format(dateJava);
        String simpleDateFormatJava = functionJava.apply(date);
        assertThat(simpleDateFormatJava).isEqualTo("24/03/2020");
    }

}
