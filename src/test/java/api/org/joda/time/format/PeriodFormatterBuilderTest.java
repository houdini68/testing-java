package api.org.joda.time.format;

import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeriodFormatterBuilderTest {

    @Test
    public void minimumPrintedDigits() {
        assertThat(new PeriodFormatterBuilder()
                .printZeroAlways()
                .appendHours()
                .appendSuffix(":")
                .minimumPrintedDigits(2)
                .appendMinutes()
                .toFormatter()
                .print(Duration.standardHours(1).plus(Duration.standardMinutes(1)).toPeriod()))
                .isEqualTo("1:01");
    }
}
