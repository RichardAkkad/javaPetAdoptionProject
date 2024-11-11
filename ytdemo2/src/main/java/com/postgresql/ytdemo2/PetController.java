package com.postgresql.ytdemo2;

import com.postgresql.ytdemo2.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.postgresql.ytdemo2.model.Dog;
import com.postgresql.ytdemo2.repo.PetRepo;

import java.util.List;
import java.util.Optional;
@Controller

public class PetController {
    @Autowired
    PetRepo repo;

   @GetMapping("/homePage")
   public String homePage(){
       return "homePage";
   }


    @GetMapping("/addPet")
    public String getPage(Model model) {
        model.addAttribute("request", new Dog());

        return "dog";
    }

    @PostMapping("/addPet")
    public String submitPage(@ModelAttribute ("request") Dog dog) {

        repo.save(dog);
        return"index";
    }


    //@GetMapping("/success")
    //public String successPage() {
    //    return "index";
    //}


    @GetMapping("/searchPet")
    public String getPage2(){

       return "dogSearch";
    }



    @GetMapping({"/searchPetResult"})
    public String searchForm(@RequestParam("id") Long id, Model model) {
       Optional<Dog> dog = repo.findById(id);
        if (dog.isPresent()) {
            model.addAttribute("dog", dog.get());//"dog.get()" just returns a object which is stored in the Optional container, and then we are reassigning this object to another variable called "dog" again
            return "dogDetails"; // This page will display the dog's details
        } else {
            model.addAttribute("message", "Dog not found");
            return "dogDetails"; // Redirect back to search page with error message
        }
    }


    @GetMapping("/searchPetResult2")
    public String getDogs(@RequestParam(required = false) String breed, Model model) {
        List<Dog> dogs = repo.findByBreedContainingIgnoreCase(
                breed );

         System.out.println(dogs.size()+"-----------");


        model.addAttribute("dogs", dogs);
        return "filterDogs";
    }






}
