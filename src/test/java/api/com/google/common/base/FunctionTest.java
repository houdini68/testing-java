package api.com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @Test
    public void When_FunctionOnDateAndString_Expect_String() {

        // A Guava Function is a Java function.
        Function<Date, String> function = date -> new SimpleDateFormat("dd/MM/yyyy").format(date);

        Date date = new Date(1585031976022L);
        String simpleDateFormat = function.apply(date);

        assertThat(simpleDateFormat).isEqualTo("24/03/2020");
    }

}
