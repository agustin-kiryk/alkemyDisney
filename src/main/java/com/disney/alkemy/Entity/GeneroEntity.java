package com.disney.alkemy.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "Genero")
@Getter      //con lombok creo automaticamente los get y set//
@Setter
@SQLDelete(sql="UPDATE genero SET deleted= true WHERE id=?")
@Where(clause="deleted=false")


public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //Nos genera un Id de forma secuencial //
    //No hace falta poner el @columns por que el nombre es el mismo que el identificador //

    private Long id;
    private String nombre;
    private  String imagen;
    private boolean deleted=Boolean.FALSE;
}
