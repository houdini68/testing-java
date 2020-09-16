package api.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.v1.Car;
import model.v1.Engine;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructorInjectionTest {

    public static final String ID_ENGINE = "id_engine";
    public static final String NAME_ENGINE = "name_engine";
    public static final String TYPE_ENGINE = "type_engine";
    public static final String ID_CAR = "id_car";
    public static final String BRAND = "brand";
    public static final String TYPE = "type";

    @Test
    public void givenEngineAndCart_thenWriteOK() throws JsonProcessingException {
        Engine engine = new Engine(ID_ENGINE, NAME_ENGINE, TYPE_ENGINE);
        String jsonEngine = new ObjectMapper().writeValueAsString(engine);
        assertThat(jsonEngine).isEqualTo("{\"id\":\"id_engine\",\"name\":\"name_engine\",\"type\":\"type_engine\"}");
        Car car = new Car(ID_CAR, BRAND, TYPE, engine);
        String jsonCar = new ObjectMapper().writeValueAsString(car);
        assertThat(jsonCar).isEqualTo("{\"id\":\"id_car\",\"brand\":\"brand\",\"type\":\"type\",\"engine\":{\"id\":\"id_engine\",\"name\":\"name_engine\",\"type\":\"type_engine\"}}");
    }

    @Test
    public void givenEngineAndCarJson_thenReadOK() throws JsonProcessingException {
        Engine engine = new ObjectMapper().readValue("{\"id\":\"id_engine\",\"name\":\"name_engine\",\"type\":\"type_engine\"}", Engine.class);
        assertThat(engine.getId()).isEqualTo(ID_ENGINE);
        assertThat(engine.getName()).isEqualTo(NAME_ENGINE);
        assertThat(engine.getType()).isEqualTo(TYPE_ENGINE);
        Car car = new ObjectMapper().readValue("{\"id\":\"id_car\",\"brand\":\"brand\",\"type\":\"type\",\"engine\":{\"id\":\"id_engine\",\"name\":\"name_engine\",\"type\":\"type_engine\"}}", Car.class);
        assertThat(car.getId()).isEqualTo(ID_CAR);
        assertThat(car.getBrand()).isEqualTo(BRAND);
        assertThat(car.getType()).isEqualTo(TYPE);
        assertThat(car.getEngine().getId()).isEqualTo(ID_ENGINE);
        assertThat(car.getEngine().getName()).isEqualTo(NAME_ENGINE);
        assertThat(car.getEngine().getType()).isEqualTo(TYPE_ENGINE);
    }
}

