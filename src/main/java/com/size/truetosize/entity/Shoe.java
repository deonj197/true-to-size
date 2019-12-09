package com.size.truetosize.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "shoe")
public class Shoe implements Serializable {

    private static final long serialVersionUID = 2664293426374350504L;

    @Id
    @Column(name = "shoe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoeId;

    @Column(name = "name")
    private String name;
}
