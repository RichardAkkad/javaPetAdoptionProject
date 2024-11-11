package com.postgresql.ytdemo2.Controller;

import com.postgresql.ytdemo2.model.Dog;
import com.postgresql.ytdemo2.repo.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class restPetController {
    @Autowired
    PetRepo repo;

    @PostMapping("/insertPet")//whether we click on this endpoint(from the home page or manually type it in this method needs to happen
    public void addPet(@RequestBody Dog dog) {

        repo.save(dog);
        //Dog myDog=repo.save(dog);
        //return myDog;


    }
    @GetMapping("/getPetById")
    public Dog  GetPetId(@RequestParam long id ){

        return repo.findById(id);




    }







}
