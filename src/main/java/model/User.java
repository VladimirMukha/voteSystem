package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "voted_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "r_id"))
    private List<Restaurant> restaurants;

    public User(Integer id, String name, Set<Role> roles) {
        super(id);
        this.name = name;
        setRole(roles);
    }

    public void setRole(Set<Role> roles) {
        this.roles = EnumSet.copyOf(roles);
    }
}