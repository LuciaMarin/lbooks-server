package net.ausiasmarch.bean;

import com.google.gson.annotations.Expose;

public class ItemBean {

    @Expose
    private int id;
    @Expose
    private int cantidad;
    @Expose(deserialize = false)
    private ProductoBean producto_obj;

    public ItemBean(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public ItemBean(int cantidad, ProductoBean producto_obj) {
        this.cantidad = cantidad;
        this.producto_obj = producto_obj;
    }

    public ProductoBean getProducto_obj() {
        return producto_obj;
    }

    public void setProducto_obj(ProductoBean producto_obj) {
        this.producto_obj = producto_obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}