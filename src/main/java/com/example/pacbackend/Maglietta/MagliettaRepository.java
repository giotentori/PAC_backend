package com.example.pacbackend.Maglietta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// Data Access Layer
// @Repository
public interface MagliettaRepository extends JpaRepository<Maglietta,Long>{ 

    //@Query("SELECT v from Maglietta v where v.id = ?1") // business logic
    List<Maglietta> findById(long id);

    List<Maglietta> findByTaglia(String taglia);
    List<Maglietta> findByColore(String colore);
    List<Maglietta> findByTipo(String tipo);

    List<Maglietta> findByTagliaAndColoreAndTipo(String taglia, String colore, String tipo);
    List<Maglietta> findByTagliaAndColore(String taglia, String colore);

    void deleteById(String id);

    
}
