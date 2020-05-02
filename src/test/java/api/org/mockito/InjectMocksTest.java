package api.org.mockito;

import api.org.mockito.injectsmocks.Service;
import api.org.mockito.injectsmocks.Service1;
import api.org.mockito.injectsmocks.Service2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Mockito uses the Service constructor Service(Service1 service1, Service2 service2) to inject/pass the dependencies.
 * The purpose of the test is not to test/check Service1 and Service2!
 * It is why both Service1 and Service2 are mocked.
 * The purpose of the test is to test/check the behaviour of Service.
 */
public class InjectMocksTest {

    // When service1.operation is called, it is recorded but nothing happens because it was mocked.
    @Mock
    Service1 service1;

    @Mock
    Service2 service2;

    // As you want to unit test Service, you pass by constructor injection the dependencies.
    // In this case Service1 and Service2.
    // This is not Spring dependency injection!
    // It is a way to make your life easy as the dependencies are aut passed to the constructor of Service.
    @InjectMocks
    Service service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mainClass_givenMockedDependencies_thenOK() {
        assertThat(service.operation()).isTrue();
        verify(service1, times(1)).operation();
        verify(service2, times(1)).operation();
        verifyNoMoreInteractions(service1);
        verifyNoMoreInteractions(service2);
    }
}