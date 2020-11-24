package model;

import org.springframework.web.multipart.MultipartFile;

public class CustomerForm {
    private Long id;
    private String name;
    private String address;
    private String email;
    private MultipartFile image;

    public CustomerForm(Long id, String name, String address, String email, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    public CustomerForm(Long id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public CustomerForm(String name, String address, String email, MultipartFile image) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    public CustomerForm() {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
