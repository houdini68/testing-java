package api.org.mockito;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.AbstractList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VerifyTest {

    @Test
    public void givenMockObject_whenMockMethod_thenVerifyMockMethod() {
        List mockList = mock(ListOverwritten.class);
        when(mockList.size()).thenReturn(1);
        Assertions.assertThat(mockList.size()).isEqualTo(1);
        verify(mockList).size();
        verify(mockList, times(1)).size();
    }

    @Test
    public void givenMockObject_whenMockMethodIsNotCalled_thenVerifyNoInteractions() {
        List mockList = mock(ListOverwritten.class);
        verify(mockList, times(0)).size();
    }

    @Test(expected = NoInteractionsWanted.class)
    public void givenMockObject_whenMockMethodNotVerified_thenNoInteractionsWantedIsRaised() {
        List mockList = mock(ListOverwritten.class);
        mockList.size();
        mockList.clear();
        verify(mockList).size();
        verify(mockList, times(1)).size();
        //                verify(mockList).clear();
        verifyNoMoreInteractions(mockList);
    }

    @Test
    public void givenMockObject_whenInOrder_thenOrderIsVerified() {
        List<String> mockList = mock(ListOverwritten.class);
        mockList.size(); // 1
        mockList.add("a string"); // 2
        mockList.clear(); // 3
        InOrder inOrder = inOrder(mockList);
        inOrder.verify(mockList).size(); // 1
        inOrder.verify(mockList).add("a string"); // 2
        inOrder.verify(mockList).clear(); // 3
    }

    @Test
    public void givenMockObject_thenVerifyMethodIsNotUsed() {
        List<String> mockList = mock(ListOverwritten.class);
        mockList.size();
        verify(mockList).size();
        verify(mockList, never()).clear();
    }

    @Test
    public void givenMockObject_thenVerifyAtLeastAndAtMost() {
        List<String> mockList = mock(ListOverwritten.class);
        mockList.clear();
        mockList.clear();
        mockList.clear();
        verify(mockList, atLeast(1)).clear();
        verify(mockList, atMost(10)).clear();
    }

    @Test
    public void givenMockObject_thenVerifyExactSameArgumentsArePassed() {
        List<String> mockList = mock(ListOverwritten.class);
        mockList.add("string");
        verify(mockList).add("string");
    }

    @Test
    public void givenMockObject_thenVerifyAnyStringWasPassed() {
        List<String> mockList = mock(ListOverwritten.class);
        mockList.add("string");
        verify(mockList).add(anyString());
    }

    static class ListOverwritten<S> extends AbstractList<String> {

        @Override
        public String get(final int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}

