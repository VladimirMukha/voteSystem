package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseModel {
    private Set<Role> roles;
    private String name;
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