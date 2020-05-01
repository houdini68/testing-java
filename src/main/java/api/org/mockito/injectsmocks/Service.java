package api.org.mockito.injectsmocks;

public class Service {

    private final Service1 service1;
    private final Service2 service2;

    // the annotation InjectMocks makes usage of the constructor
    public Service(Service1 service1, Service2 service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    // the operation is tested by the unit test InjectMocksTest but the dependencies are mocked
    // the purpose of the test is not to test Service1 and Service2 but to test Service
    // and it is why the dependencies are mocked
    public boolean operation() {
        // both services were mocked and injected within the constructor by InjectMocks
        service1.operation();
        service2.operation();
        return true;
    }
}
