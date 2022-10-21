package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import tech.jhipster.sample.domain.UserEntity;

/**
 * A DTO representing a user, with only the public attributes.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String login;

    public User() {
        // Empty constructor needed for Jackson.
    }

    public User(UserEntity user) {
        this.id = user.getId();
        // Customize it here if you need, or not, firstName/lastName/etc
        this.login = user.getLogin();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", login='" + login + '\'' +
            "}";
    }
}
