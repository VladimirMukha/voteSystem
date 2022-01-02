package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseModel {
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Meal> menu = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> userList;
    @Column(name = "name")
    private String name;
    @Column(name = "count_votes")
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