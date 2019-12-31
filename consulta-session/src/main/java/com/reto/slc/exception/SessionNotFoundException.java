package com.reto.slc.exception;

public class SessionNotFoundException extends Exception {
    private static final long serialVersionUID = -1344312132312323123L;

    private static final String DESCRIPTION = "Session no encontrada";

    public SessionNotFoundException(){
        super(DESCRIPTION);
    }

    public SessionNotFoundException(String detail){
        super(DESCRIPTION + ". "+ detail);
    }

}
