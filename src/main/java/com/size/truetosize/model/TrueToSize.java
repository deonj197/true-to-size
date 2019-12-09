package com.size.truetosize.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TrueToSize implements Serializable {
    private static final long serialVersionUID = 6027917962767599814L;
    private Long trueToSizeId;
    private Long trueToSizeValue;
    private Long shoeId;
}
