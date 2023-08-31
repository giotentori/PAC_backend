package com.example.pacbackend.Vestito;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/*
    1 	@Entity is a JPA annotation that denotes the whole class for storage in a relational table.
    2 	@Id and @GeneratedValue are JPA annotations to note the primary key and that is generated automatically when needed. 
*/

@Entity
@Table
public class Vestito {
    @Id
    @SequenceGenerator(
        name = "vestito_sequence",
        sequenceName="vestito_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator="vestito_sequence"
    )
    
    private long id; 
    private String taglia;
    private String colore;
    private String stagione;
    private String description;

    @Transient // questo dato non deve occupare una colonna del database
    private String tipo;
    
    public Vestito(){
        super();
     }
    public Vestito(long id,String taglia, String colore, String stagione, String description /* ,String tipo */){
        this.id=id;
        this.taglia=taglia;
        this.stagione=stagione;
        this.colore=colore;
        this.description=description;
        // this.tipo=tipo;
    }
    public Long getId() {
        return id;
    }
    public String getStagione() {
        return stagione;
    }
    public String getTaglia() {
        return taglia;
    }
    public String getColore() {
        return colore;
    }
    public String getTipo() { // quando poniamo @transient il tipo possiamo calcolarlo qua dentro
        return tipo;
    }
    public String getDescription() {
        return description;
    }
    
}
