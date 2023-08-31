package com.example.pacbackend.Maglietta;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table
public class Maglietta {
    @Id
    @SequenceGenerator(
        name = "Maglietta_sequence",
        sequenceName="Maglietta_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator="Maglietta_sequence"
    )
    
    private long id; 
    private String taglia;
    private String colore;
    private String description;
    private String tipo;
    
    public Maglietta(){
        super();
     }
    public Maglietta(long id,String taglia, String colore,String tipo, String description) throws Exception{

        this.id=id;
        this.taglia=taglia;
        this.colore=colore;
        this.tipo=tipo;
        this.description=description;
    }
    public Long getId() {
        return id;
    }
    public String getTaglia() {
        return taglia;
    }
    public String getColore() {
        return colore;
    }
    public String getTipo() {
        return tipo;
    }
    public String getDescription() {
        return description;
    }
    
}
