package com.example.pacbackend.Maglietta;

import java.util.List;
import java.util.Optional;


// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// Service Layer
@Service
public class MagliettaService {

    private final MagliettaRepository magliettaRepository;
    
    // @Autowired
    public MagliettaService(MagliettaRepository magliettaRepository){
        this.magliettaRepository = magliettaRepository;
    }


    // ritorna tutta la lista di Magliette che ci sono nel database
    public List<Maglietta> getAllMagliette(){
        return magliettaRepository.findAll(); //cerca tutti i Magliette che ci sono nel DB
    }
    // ricerca di un Maglietta tramite ID
    public List<Maglietta> getById(long id) {
        return magliettaRepository.findById(id); // cerca il vestico tramite ID
    }
    public List<Maglietta> getByTaglia(String taglia){
        return magliettaRepository.findByTaglia(taglia);
    }
    public List<Maglietta> getByColore(String colore){
        return magliettaRepository.findByColore(colore);
    }
    public List<Maglietta> getByTipo(String tipo){
        return magliettaRepository.findByTipo(tipo);
    }



    // inserimento di un nuovo Maglietta
    public void insertMaglietta(Maglietta Maglietta) { //inserimento di un nuovo Maglietta
        Optional<Maglietta> MagliettaById = magliettaRepository.findById(Maglietta.getId());
        if(MagliettaById.isPresent()){ // se l'id del Maglietta è gia presente lancio un'eccezione
            throw new IllegalStateException("Id taken , Maglietta gia preso");
        }

        magliettaRepository.save(Maglietta);
    }
    // cancellazione di un Maglietta
    public void deleteMaglietta(Long MagliettaId){
        magliettaRepository.findById(MagliettaId);
        boolean exists = magliettaRepository.existsById(MagliettaId);
        if(!exists){
            
            throw new IllegalStateException("Maglietta con id " + MagliettaId + "non esiste");

        }
        magliettaRepository.deleteById(MagliettaId);
    }

    // sostituzione di un Maglietta con uno nuovo
    @Transactional
    public void updateMaglietta(Long MagliettaId) {
        magliettaRepository.findById(MagliettaId);
        boolean exists = magliettaRepository.existsById(MagliettaId);
        if(!exists){
            
            throw new IllegalStateException("Maglietta con id " + MagliettaId + "non esiste");

        }
    }
}

