package cn.ice.cloud.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbUser")
public class User implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
//    @SequenceGenerator(initialValue = 1, name = "userSeq", sequenceName = "USER_SEQUENCE")
//    private Long id;

    private String nickname;

    private String avatar;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("nickname", getNickname()).toString();
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
