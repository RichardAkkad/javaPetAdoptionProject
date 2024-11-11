package com.postgresql.ytdemo2.repo;

import com.postgresql.ytdemo2.model.Dog;
import com.postgresql.ytdemo2.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PetRepo extends JpaRepository<Dog,Long> {

    Dog findById(long id);

     List<Dog> findByBreedContainingIgnoreCase(String breed);


    List<Dog> findByBreed(String breed);
}
