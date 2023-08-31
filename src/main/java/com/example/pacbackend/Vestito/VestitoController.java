package com.example.pacbackend.Vestito;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vestito")
public class VestitoController {
    private final VestitoService vestitoService;

    // @Autowired
    public VestitoController(VestitoService vestitoService){
        this.vestitoService=vestitoService;
    }

    @GetMapping("/getAll") // potrei utilizzare anche la @RequestMapping 
    @ResponseBody
    public List<Vestito> getAllVestiti(){
        return vestitoService.getAllVestiti();
    }

    @GetMapping("/getById/{id}") //{id} indica che id è una parte dinamica cioè una parte che è decisa in fase di esecuzione non una parte statica del programma
    @ResponseBody
    public Optional<Vestito> getById(@PathVariable long id){
        return vestitoService.getById(id);
    }

    @PostMapping
    public void insertVestito(@RequestBody Vestito vestito){ //@ requestbody significa che il nuovo vestito arriva dal client
        vestitoService.insertVestito(vestito);
    }
    @DeleteMapping(path="vestitoId")
    public void deleteVestito(@PathVariable("vestitoId") Long vestitoId){
        vestitoService.deleteVestito(vestitoId);
    }
    @PutMapping(path={"vestitoId"})
    public void updateVestito(@PathVariable("vestitoId") Long vestitoId, @RequestParam(required=false) String name){
        vestitoService.updateVestito(vestitoId);
    }

    // @GetMapping("/getById/{tipo,taglia,stagione}") //{id} indica che id è una parte dinamica cioè una parte che è decisa in fase di esecuzione non una parte statica del programma
    // @ResponseBody
    // public List<Vestito> ricercaVestitoTTS(@PathVariable String tipo,@PathVariable String taglia, @PathVariable String stagione){
    //     return vestitoService.ricercaVestitoTTS(tipo,taglia,stagione);
    // }
    
}
