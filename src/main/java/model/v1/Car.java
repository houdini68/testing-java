package model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private final String id;
    private final String brand;
    private final String type;
    final Engine engine;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Car(@JsonProperty("id") String id,
               @JsonProperty("brand") String brand,
               @JsonProperty("type") String type,
               @JsonProperty("engine") Engine engine) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.engine = engine;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public Engine getEngine() {
        return engine;
    }
}
