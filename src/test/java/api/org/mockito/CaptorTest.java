package api.org.mockito;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CaptorTest {
    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argumentCaptor;

    @Test
    public void givenArgumentCaptor_thenArgumentIsCaptured() {
        mockedList.add("one");
        Mockito.verify(mockedList).add(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue()).isEqualTo("one");
    }
}
