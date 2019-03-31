package cn.ice.cloud.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbProduct")
public class Product implements Serializable {

    private static final long serailVersionUID = 2L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String coverImage;

    private int price;

//    @OneToMany(targetEntity = ProductComment.class, cascade = CascadeType.REMOVE)
//    @JoinTable(name = "tbProductComment", joinColumns = {@JoinColumn(name = "productId")}, inverseJoinColumns = {@JoinColumn(name = "id")})
//    private List<ProductComment> productComments;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName()).toString();
    }

    // Getter & Setter

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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
