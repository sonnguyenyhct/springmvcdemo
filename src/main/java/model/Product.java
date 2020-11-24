package model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    private String nameProduct;
    private Double price;
    private int amount;
    private String image;
    @Transient
    private MultipartFile imageProduct;
//    private int idCategory;
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String nameProduct, Double price, int amount, String image, MultipartFile imageProduct, Category category) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.image = image;
        this.imageProduct = imageProduct;
        this.category = category;
    }

    public Product(Long idProduct, String nameProduct, Double price, int amount, String image, Category category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.image = image;
        this.category = category;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(MultipartFile imageProduct) {
        this.imageProduct = imageProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
