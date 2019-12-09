package com.size.truetosize.exception;

import lombok.Getter;

@Getter
public class TrueToSizeException extends RuntimeException {
    private static final long serialVersionUID = 8710223474901307223L;

    private final Integer code;

    private TrueToSizeException(final Integer code, final String message) {
        super(message);
        this.code = code;
    }

    public TrueToSizeException(Integer code, String format, Object... args) {
        this(code, String.format(format, args));
    }
}
