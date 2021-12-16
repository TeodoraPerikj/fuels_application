package mk.ukim.finki.dians_lab2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    @ManyToOne
    private Street street;

    public Fuel() {
    }

    public Fuel(String name, Long id, Float latitude,Float longitude, Street street) {
        this.name = name;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
    }
}
