package api.org.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    List<String> mockList;

    @Test
    public void givenMock_thenOK() {
        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertThat(mockList.size()).isEqualTo(0);
        Mockito.when(mockList.size()).thenReturn(10);
        assertThat(mockList.size()).isEqualTo(10);
    }
}
