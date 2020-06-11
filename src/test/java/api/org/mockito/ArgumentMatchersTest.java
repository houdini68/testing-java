package api.org.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatchersTest {

    public static final String RETURNED_A_VALUE = "returned a value";
    public static final String ACTION = "action";
    public static final String ANOTHER_ACTION = "ANOTHER_ACTION";
    public static final String ANOTHER = "ANOTHER";

    @Mock
    Service service;

    @Test
    public void givenMock_whenMethodFixedParameter_thenReturnedValue() {
        //        doReturn(RETURNED_A_VALUE).when(service).doSomething(ACTION);
        when(service.doSomething(ACTION)).thenReturn(RETURNED_A_VALUE);
        assertThat(service.doSomething(ACTION)).isEqualTo(RETURNED_A_VALUE);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void givenMock_whenMethodParameterAnyString_thenReturnedValue() {
        when(service.doSomething(anyString())).thenReturn(RETURNED_A_VALUE);
        assertThat(service.doSomething(ACTION)).isEqualTo(RETURNED_A_VALUE);
        verifyNoMoreInteractions(service);
    }

    @Test(expected = org.mockito.exceptions.misusing.InvalidUseOfMatchersException.class)
    public void givenMock_whenFirstParamFixedAndSecondAnyInt_thenInvalidUseOfMatchers() {
        when(service.doSomething(ACTION, anyInt())).thenReturn(RETURNED_A_VALUE);
        // both must be matchers!
        assertThat(service.doSomething(ACTION, 1)).isEqualTo(RETURNED_A_VALUE);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void givenMock_whenFirstParamAnyStringAndSecondAnyInt_thenReturnedValue() {
        // corr of the previous unit test givenMock_whenFirstParamFixedAndSecondAnyInt_thenInvalidUseOfMatchers
        when(service.doSomething(eq(ACTION), anyInt())).thenReturn(RETURNED_A_VALUE);
        assertThat(service.doSomething(ACTION, 1)).isEqualTo(RETURNED_A_VALUE);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void givenMock_whenAdditonalMatchers() {
        when(service.doSomething(eq(ANOTHER_ACTION), anyInt())).thenReturn(RETURNED_A_VALUE);
        assertThat(service.doSomething(ANOTHER_ACTION, 1)).isEqualTo(RETURNED_A_VALUE);
        verify(service).doSomething(or(eq(ACTION), startsWith(ANOTHER)), anyInt());
        verifyNoMoreInteractions(service);
    }

}

class Service {
    String doSomething(String param) {
        return format("did something param:%s", param);
    }

    String doSomething(String param1, int param2) {
        return format("did something parm1:%s, param2:%d", param1, param2);
    }
}