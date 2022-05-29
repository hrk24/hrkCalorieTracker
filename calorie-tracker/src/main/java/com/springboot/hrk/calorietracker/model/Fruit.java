package com.springboot.hrk.calorietracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="fruit_name")
    private String fruitName;

    @Column(name="calories_per_serving")
    private String caloriesPerServing;

    @Override
    public String toString(){
        return fruitName + "::" +caloriesPerServing;
    }


}
