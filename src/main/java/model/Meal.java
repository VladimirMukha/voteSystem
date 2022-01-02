package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Meal extends BaseModel {
    @Column(name = "price")
    private Integer price;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @Column(name = "r_id")
    private Restaurant restaurant;

    public Meal(Integer id, Integer price, String name) {
        super(id);
        this.price = price;
        this.name = name;
    }
}