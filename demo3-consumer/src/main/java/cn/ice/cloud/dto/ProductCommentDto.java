package cn.ice.cloud.dto;

import cn.ice.cloud.entity.Product;
import cn.ice.cloud.entity.ProductComment;

import java.util.Date;

public class ProductCommentDto {
    private Long id;

    private Product product;

    private UserDto author;

    private String content;

    private Date created;

    public ProductCommentDto(ProductComment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
        this.created = comment.getCreated();
    }

    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
