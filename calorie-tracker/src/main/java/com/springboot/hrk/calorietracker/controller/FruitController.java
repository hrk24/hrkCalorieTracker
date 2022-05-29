package com.springboot.hrk.calorietracker.controller;

import com.springboot.hrk.calorietracker.exception.ResourceNotFoundException;
import com.springboot.hrk.calorietracker.model.Fruit;
import com.springboot.hrk.calorietracker.repository.FruitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calorieTracker/fruits")
public class FruitController {

    Logger log = LoggerFactory.getLogger(FruitController.class);

    @Autowired
    private FruitRepository fruitRepository;

    //API to fetch all fruits -- GET
    @GetMapping("/fetchAllFruits")
    public List<Fruit> getAllFruits(){
        log.info("logging enabled for the calorie tracker application");
        log.info("Fetching all fruits");
        return fruitRepository.findAll();
    }

    //API to create fruits -- CREATE
    @PutMapping("/saveAllFruits")
    public void insertFruits(){
        Fruit f1 = new Fruit();
        f1.setFruitName("Apple");
        f1.setCaloriesPerServing("100");
        fruitRepository.saveAndFlush(f1);

        Fruit f2 = new Fruit();
        f2.setFruitName("Banana");
        f2.setCaloriesPerServing("125");
        fruitRepository.saveAndFlush(f2);

        Fruit f3 = new Fruit();
        f3.setFruitName("mango");
        f3.setCaloriesPerServing("150");
        fruitRepository.saveAndFlush(f3);
    }

    //API to create fruits -- CREATE
    @PostMapping("/createFruit")
    public Fruit createFruit(@RequestBody Fruit fruit) {
        log.info("Rest Call Received to create and persist fruit");
        return fruitRepository.save(fruit);
    }

    //API to fetch fruits by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable long id){
        Fruit fruitObj =  fruitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return ResponseEntity.ok(fruitObj);
    }

    //API to update fruit -- UPDATE
    @PostMapping("/updateById/{id}")
    public ResponseEntity<Fruit> updateFruitById(@PathVariable long id, @RequestBody Fruit fruitDetails) {

        //Demonstrating the concept of functional interfaces with lambda expressions
        Fruit fruitObj =  fruitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));

        fruitObj.setId(fruitDetails.getId());
        fruitObj.setFruitName(fruitDetails.getFruitName());
        fruitObj.setCaloriesPerServing(fruitDetails.getCaloriesPerServing());

        fruitRepository.save(fruitObj);
        return ResponseEntity.ok(fruitObj);
    }

    //API to fetch fruits by ID
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Fruit> deleteFruitById(@PathVariable long id){

        //Demonstrating the concept of method reference using Scope operator
        Fruit fruitObj =  fruitRepository.findById(id)
                .orElseThrow(ResourceNotFoundException :: new);

        fruitRepository.delete(fruitObj);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}
