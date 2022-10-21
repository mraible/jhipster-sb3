package tech.jhipster.sample.service.mapper;

import java.util.*;
import java.util.stream.Collectors;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.Authority;
import tech.jhipster.sample.domain.UserEntity;
import tech.jhipster.sample.service.dto.AdminUser;
import tech.jhipster.sample.service.dto.User;

/**
 * Mapper for the entity {@link UserEntity} and its DTO called {@link User}.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class UserMapper {

    public List<User> usersToUserDTOs(List<UserEntity> users) {
        return users.stream().filter(Objects::nonNull).map(this::userToUserDTO).collect(Collectors.toList());
    }

    public User userToUserDTO(UserEntity user) {
        return new User(user);
    }

    public List<AdminUser> usersToAdminUserDTOs(List<UserEntity> users) {
        return users.stream().filter(Objects::nonNull).map(this::userToAdminUserDTO).collect(Collectors.toList());
    }

    public AdminUser userToAdminUserDTO(UserEntity user) {
        return new AdminUser(user);
    }

    public List<UserEntity> userDTOsToUsers(List<AdminUser> userDTOs) {
        return userDTOs.stream().filter(Objects::nonNull).map(this::userDTOToUser).collect(Collectors.toList());
    }

    public UserEntity userDTOToUser(AdminUser userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            UserEntity user = new UserEntity();
            user.setId(userDTO.getId());
            user.setLogin(userDTO.getLogin());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setImageUrl(userDTO.getImageUrl());
            user.setActivated(userDTO.isActivated());
            user.setLangKey(userDTO.getLangKey());
            Set<Authority> authorities = this.authoritiesFromStrings(userDTO.getAuthorities());
            user.setAuthorities(authorities);
            return user;
        }
    }

    private Set<Authority> authoritiesFromStrings(Set<String> authoritiesAsString) {
        Set<Authority> authorities = new HashSet<>();

        if (authoritiesAsString != null) {
            authorities =
                authoritiesAsString
                    .stream()
                    .map(string -> {
                        Authority auth = new Authority();
                        auth.setName(string);
                        return auth;
                    })
                    .collect(Collectors.toSet());
        }

        return authorities;
    }

    public UserEntity userFromId(Long id) {
        if (id == null) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setId(id);
        return user;
    }

    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    public User toDtoId(UserEntity user) {
        if (user == null) {
            return null;
        }
        User userDto = new User();
        userDto.setId(user.getId());
        return userDto;
    }

    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    public Set<User> toDtoIdSet(Set<UserEntity> users) {
        if (users == null) {
            return Collections.emptySet();
        }

        Set<User> userSet = new HashSet<>();
        for (UserEntity userEntity : users) {
            userSet.add(this.toDtoId(userEntity));
        }

        return userSet;
    }

    @Named("login")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    public User toDtoLogin(UserEntity user) {
        if (user == null) {
            return null;
        }
        User userDto = new User();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        return userDto;
    }

    @Named("loginSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    public Set<User> toDtoLoginSet(Set<UserEntity> users) {
        if (users == null) {
            return Collections.emptySet();
        }

        Set<User> userSet = new HashSet<>();
        for (UserEntity userEntity : users) {
            userSet.add(this.toDtoLogin(userEntity));
        }

        return userSet;
    }
}
