package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Meal extends BaseModel {
    private Integer price;
    private String name;
    private Restaurant restaurant;

    public Meal(Integer id, Integer price, String name) {
        super(id);
        this.price = price;
        this.name = name;
    }
}