package com.size.truetosize.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Shoe implements Serializable {
    private static final long serialVersionUID = 8711620898180416298L;
    private Long shoeId;
    private String name;
}
