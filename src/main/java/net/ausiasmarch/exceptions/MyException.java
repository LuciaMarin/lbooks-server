package net.ausiasmarch.exceptions;

import java.util.ArrayList;

public class MyException extends RuntimeException {

    private Integer code = 5000;
    private ArrayList<String> descripcion;

    public MyException() {
        super();
    }

    public MyException(Integer code, String descripcion) {
        super(descripcion);
        this.code = code;
        this.descripcion.add(descripcion);
    }

    public MyException(Integer code, String descripcion, Throwable cause) {
        super(descripcion, cause);
        this.code = code;
        this.descripcion.add(descripcion);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescripcions() {
        return descripcion.toString();
    }

    public void addDescripcion(String descripcion) {
        this.descripcion.add(descripcion);
    }

}
