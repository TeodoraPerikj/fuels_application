package mk.ukim.finki.dians_lab2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    @OneToMany(mappedBy = "street", fetch = FetchType.EAGER)
    private List<Fuel> fuels;

    @ManyToMany
    private List<Street> streets;

    public Street() {
    }

    public Street(Long id, String name, Float latitude, Float longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.fuels = new ArrayList<>();
        this.streets = new ArrayList<>();
    }
}
