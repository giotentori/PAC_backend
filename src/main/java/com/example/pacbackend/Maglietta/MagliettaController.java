package com.example.pacbackend.Maglietta;

import java.util.List;

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
@RequestMapping("maglietta")
public class MagliettaController {
    private final MagliettaService MagliettaService;

    // @Autowired
    public MagliettaController(MagliettaService MagliettaService){
        this.MagliettaService=MagliettaService;
    }

    @GetMapping("/getAll") // potrei utilizzare anche la @RequestMapping 
    @ResponseBody
    public List<Maglietta> getAllMagliette(){
        return MagliettaService.getAllMagliette();
    }

    @GetMapping("/getById/{id}") //{id} indica che id è una parte dinamica cioè una parte che è decisa in fase di esecuzione non una parte statica del programma
    @ResponseBody
    public List<Maglietta> getById(@PathVariable long id){
        return MagliettaService.getById(id);
    }

    @PostMapping
    public void insertMaglietta(@RequestBody Maglietta Maglietta){ //@ requestbody significa che il nuovo Maglietta arriva dal client
        MagliettaService.insertMaglietta(Maglietta);
    }
    @DeleteMapping(path="MagliettaId")
    public void deleteMaglietta(@PathVariable("MagliettaId") Long MagliettaId){
        MagliettaService.deleteMaglietta(MagliettaId);
    }
    @PutMapping(path={"MagliettaId"})
    public void updateMaglietta(@PathVariable("MagliettaId") Long MagliettaId, @RequestParam(required=false) String name){
        MagliettaService.updateMaglietta(MagliettaId);
    }

    // @GetMapping("/getById/{tipo,taglia,stagione}") //{id} indica che id è una parte dinamica cioè una parte che è decisa in fase di esecuzione non una parte statica del programma
    // @ResponseBody
    // public List<Maglietta> ricercaMagliettaTTS(@PathVariable String tipo,@PathVariable String taglia, @PathVariable String stagione){
    //     return MagliettaService.ricercaMagliettaTTS(tipo,taglia,stagione);
    // }
    
}
