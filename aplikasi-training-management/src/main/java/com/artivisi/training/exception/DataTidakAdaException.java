package com.artivisi.training.exception;

public class DataTidakAdaException extends RuntimeException {

    public DataTidakAdaException() {
    }

    public DataTidakAdaException(String string) {
        super(string);
    }

    public DataTidakAdaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DataTidakAdaException(Throwable thrwbl) {
        super(thrwbl);
    }

    public DataTidakAdaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
