package cn.ice.cloud.entity;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbProductComment")
public class ProductComment implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;

    private Long authorId;

    private String content;

    private Date created;

    @Override
    public String toString() {
        // commons-lang3 ToStringBuilder
        return ToStringBuilder.reflectionToString(this);
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
