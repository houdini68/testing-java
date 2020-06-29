package model.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class Engine {
    private final String id;
    private final String name;
    private final String type;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Engine(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("type") String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("type", type)
                .toString();
    }

}
