package api.org.mockito;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    @Spy
    List<String> spyList = new ArrayList<String>();

    @Test
    public void givenSpy_thenOK() {
        spyList.add("item1");
        spyList.add("item2");

        Mockito.verify(spyList).add("item1");
        Mockito.verify(spyList).add("item2");

        assertThat(spyList.size()).isEqualTo(2); // real size()

        Mockito.doReturn(10).when(spyList).size();
        assertThat(spyList.size()).isEqualTo(10); // stubbed size()
    }
}
