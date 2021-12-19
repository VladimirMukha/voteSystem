package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "name")
@NoArgsConstructor
public class User extends BaseModel {
    private String name;

    public User(Integer id, String name) {
        this.name = name;
    }
}