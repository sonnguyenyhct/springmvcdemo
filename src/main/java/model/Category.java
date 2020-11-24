package model;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idCategory;
    String nameCategory;

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
