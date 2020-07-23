package com.iroshnk.testbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Cacheable(value = true)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", updatable = false, nullable = false, columnDefinition = "SMALLINT(5) UNSIGNED AUTO_INCREMENT")
    private Integer itemId;
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(name = "description", columnDefinition = "VARCHAR(1000)")
    private String description;
    @Column(name = "category", columnDefinition = "VARCHAR(40)")
    private String category;
    @Column(name = "image_url", columnDefinition = "VARCHAR(40)")
    private String imageUrl;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
