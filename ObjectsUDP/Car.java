package ObjectsUDP;

import java.io.Serializable;

public class Car implements Serializable {

    String id, plate;

    private static final long serialVersionUID = 1L;

    public Car (String id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public String toString() {
        return "Plate: " + this.plate + " / Client ID: " + this.id;
    }
}
