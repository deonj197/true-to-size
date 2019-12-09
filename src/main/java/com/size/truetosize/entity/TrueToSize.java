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
@Table(name = "true_to_size")
public class TrueToSize implements Serializable {

    private static final long serialVersionUID = 7212329916916176684L;

    @Id
    @Column(name = "true_to_size_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trueToSizeId;

    @Column(name = "true_to_size_value")
    private Long trueToSizeValue;

    @Column(name = "shoe_id")
    private Long shoeId;
}
