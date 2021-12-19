package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Restaurant extends BaseModel {
    private Set<Meal> menu = new HashSet<>();
    private List<User> userList;
    private String name;
    private Integer countVotes;

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Restaurant(Integer id, String name, Collection<Meal> meals) {
        super(id);
        this.name = name;
        this.menu.addAll(meals);
    }

    public Integer countingOfVotes() {
        countVotes = getUserList().size();
        return countVotes;
    }
}