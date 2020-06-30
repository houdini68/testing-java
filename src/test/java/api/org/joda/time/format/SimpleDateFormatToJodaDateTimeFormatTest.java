package api.org.joda.time.format;

import org.assertj.core.api.Assertions;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatToJodaDateTimeFormatTest {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    @Test
    public void givenJavaDateAndSimpleDateFormat_whenDateTimeJoda_thenEqual() throws ParseException {
        String date = "2019-12-06";
        SimpleDateFormat yyyyMMddFormatter = new SimpleDateFormat(YYYY_MM_DD);
        Date javaDate = yyyyMMddFormatter.parse(date);
        DateTimeFormatter dtf  = DateTimeFormat.forPattern(YYYY_MM_DD);
        Date jodaDate = dtf.parseLocalDate(date).toDate();
        Assertions.assertThat(javaDate.equals(jodaDate)).isTrue();
    }
}
