package com.example.pacbackend.Vestito;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;


// Data Access Layer
// @Repository

public interface VestitoRepository extends JpaRepository<Vestito,Long>{ 

    @Query("SELECT v from Vestito v where v.id = ?1") // business logic
    Optional<Vestito> findById(long id);

    // @Query("SELECT v from Vestito v where v.tipo = ?1 and v.taglia = ?2 and v.stagione = ?3")
    // List<Vestito> findByTTS(String tipo, String taglia, String stagione);
    
}

/*
 * 

One of the biggest, most powerful features of Spring Data is its ability to write JPA queries for you. This not only cuts down on your development time, but it also reduces the risk of bugs and errors. Spring Data looks at the name of methods in a repository class and figures out the operations you need, including saving, deleting, and finding.

That is how we can write an empty interface and inherit already built save, find, and delete operations.

 * 
 * 
 */