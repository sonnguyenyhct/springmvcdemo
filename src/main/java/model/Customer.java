package model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String image;

    public Customer() {
    }

    public Customer(Long id, String name, String address, String email, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    public Customer(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
