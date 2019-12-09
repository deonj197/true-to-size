package com.size.truetosize.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TrueToSizeCalculation implements Serializable {
    private static final long serialVersionUID = 2758791074874369135L;
    private Long shoeId;
    private String shoeName;
    private Double trueToSizeCalculationOutput;
}
