package infsus.closet.closet.DTO;

import infsus.closet.closet.model.Category;
import infsus.closet.closet.model.Profile;
import jakarta.persistence.*;

public class ClothesDTO {
    private String name;

    private String description;

    private String size;

    private double price;

    private byte[] picture;

    private ProfileDTO profile;

    private CategoryDTO category;

    public ClothesDTO() {
        // default constructor
    }

    public ClothesDTO(String name, String description, String size, double price, byte[] picture, ProfileDTO profile, CategoryDTO category) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.picture = picture;
        this.profile = profile;
        this.category = category;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

}
