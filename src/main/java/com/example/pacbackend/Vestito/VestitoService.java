package com.example.pacbackend.Vestito;

import java.util.List;
import java.util.Optional;


// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// Service Layer
@Service
public class VestitoService {

    private final VestitoRepository vestitoRepository;
    
    // @Autowired
    public VestitoService(VestitoRepository vestitoRepository){
        this.vestitoRepository = vestitoRepository;
    }
    // ritorna tutta la lista di vestiti che ci sono nel database
    public List<Vestito> getAllVestiti(){
        return vestitoRepository.findAll(); //cerca tutti i vestiti che ci sono nel DB
    }
    // ricerca di un vestito tramite ID
    public Optional<Vestito> getById(long id) {
        return vestitoRepository.findById(id); // cerca il vestico tramite ID
    }
    // inserimento di un nuovo vestito
    public void insertVestito(Vestito vestito) { //inserimento di un nuovo vestito
        Optional<Vestito> vestitoById = vestitoRepository.findById(vestito.getId());
        if(vestitoById.isPresent()){ // se l'id del vestito è gia presente lancio un'eccezione
            throw new IllegalStateException("Id taken , vestito gia preso");
        }

        vestitoRepository.save(vestito);
    }
    // cancellazione di un vestito
    public void deleteVestito(Long vestitoId){
        vestitoRepository.findById(vestitoId);
        boolean exists = vestitoRepository.existsById(vestitoId);
        if(!exists){
            
            throw new IllegalStateException("vestito con id " + vestitoId + "non esiste");

        }
        vestitoRepository.deleteById(vestitoId);
    }

    // sostituzione di un vestito con uno nuovo
    @Transactional
    public void updateVestito(Long vestitoId) {
        vestitoRepository.findById(vestitoId);
        boolean exists = vestitoRepository.existsById(vestitoId);
        if(!exists){
            
            throw new IllegalStateException("vestito con id " + vestitoId + "non esiste");

        }
    }
    // ricerca dei vestiti in base al tipo , taglia e stagione 
    // public List<Vestito> ricercaVestitoTTS(String tipo, String taglia, String stagione){
        
    //     return vestitoRepository.findByTTS(tipo,taglia,stagione);
    // }
}
