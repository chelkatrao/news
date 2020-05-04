package com.chelkatrao.news.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    public static final String ADMIN_ROLE = "administrator";

    @Column(name = "role_name", length = 64)
    private String roleName;

    @NaturalId
    @Column(name = "role_info", length = 64, unique = true)
    private String roleInfo;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, targetEntity = Permission.class)
    @JoinTable(name = "u_roles_permissions", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions = new LinkedHashSet<>();

}
