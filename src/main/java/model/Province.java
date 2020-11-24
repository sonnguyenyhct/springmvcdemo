package model;

import javax.persistence.*;

@Table
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Province(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Province() {
    }
}
