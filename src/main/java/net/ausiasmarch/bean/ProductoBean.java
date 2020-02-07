package net.ausiasmarch.bean;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import net.ausiasmarch.dao.daointerface.DaoInterface;
import net.ausiasmarch.factory.DaoFactory;

public class ProductoBean implements BeanInterface {

    @Expose
    private Integer id;
    @Expose
    private String codigo;
    @Expose
    private String autor;
    @Expose
    private Integer existencias;
    @Expose
    private Double precio;
    @Expose
    private String imagen;
    @Expose
    private String descripcion;
    @Expose(serialize = false)
    private Integer tipo_producto_id;
    @Expose(deserialize = false)
    private TipoProductoBean tipo_producto_obj;
    @Expose(deserialize = false)
    private Integer link_compra;
    @Expose
    private Boolean canCreate;
    @Expose
    private Boolean canUpdate;
    @Expose
    private Boolean canDelete;

    public Boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Boolean canCreate) {
        this.canCreate = canCreate;
    }

    public Boolean getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Integer getLink_compra() {
        return link_compra;
    }

    public void setLink_compra(Integer link_compra) {
        this.link_compra = link_compra;
    }

    public ProductoBean() {
    }

    public ProductoBean(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo_producto_id() {
        return tipo_producto_id;
    }

    public void setTipo_producto_id(Integer tipo_producto_id) {
        this.tipo_producto_id = tipo_producto_id;
    }

    public TipoProductoBean getTipo_producto_obj() {
        return tipo_producto_obj;
    }

    public void setTipo_producto_obj(TipoProductoBean tipo_producto_obj) {
        this.tipo_producto_obj = tipo_producto_obj;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    @Override
    public ProductoBean fill(ResultSet oResultSet, Connection oConnection,
            int spread, UsuarioBean oUsuarioBeanSession) throws Exception {
        this.setId(oResultSet.getInt("id"));
        this.setCodigo(oResultSet.getString("codigo"));
        this.setAutor(oResultSet.getString("autor"));
        this.setExistencias(oResultSet.getInt("existencias"));
        this.setPrecio(oResultSet.getDouble("precio"));
        this.setImagen(oResultSet.getString("imagen"));
        this.setDescripcion(oResultSet.getString("descripcion"));
        this.setTipo_producto_id(oResultSet.getInt("tipo_producto_id"));

        if (oUsuarioBeanSession != null) {
            DaoInterface oProductoDao = DaoFactory.getDao(oConnection, "compra", oUsuarioBeanSession);
            this.setLink_compra(oProductoDao.getCount(id, "producto"));

            if (this.getLink_compra() > 0) {
                this.setCanDelete(false);
            } else {
                this.setCanDelete(true);
            }

            if (spread > 0) {
                spread--;
                DaoInterface oTipoProductoDao = DaoFactory.getDao(oConnection, "tipo_producto", oUsuarioBeanSession);
                TipoProductoBean oTipoProductoBean;
                oTipoProductoBean = (TipoProductoBean) oTipoProductoDao.get(this.tipo_producto_id);
                this.tipo_producto_obj = oTipoProductoBean;
            }
        }
        return this;
    }

    @Override
    public PreparedStatement orderSQL(List<String> orden, PreparedStatement oPreparedStatement)
            throws Exception {
        for (int i = 1; i < orden.size(); i++) {
            if (orden.get((i - 1)).equalsIgnoreCase("id")) {
                oPreparedStatement.setInt(i, 1);
            } else if (orden.get((i - 1)).equalsIgnoreCase("codigo")) {
                oPreparedStatement.setInt(i, 2);
                } else if (orden.get((i - 1)).equalsIgnoreCase("autor")) {
                oPreparedStatement.setInt(i, 3);
            } else if (orden.get((i - 1)).equalsIgnoreCase("existencias")) {
                oPreparedStatement.setInt(i, 4);
            } else if (orden.get((i - 1)).equalsIgnoreCase("precio")) {
                oPreparedStatement.setInt(i, 5);
            } else if (orden.get((i - 1)).equalsIgnoreCase("imagen")) {
                oPreparedStatement.setInt(i, 6);
            } else if (orden.get((i - 1)).equalsIgnoreCase("descripcion")) {
                oPreparedStatement.setInt(i, 7);
            }
        }
        return oPreparedStatement;
    }

    @Override
    public String getFieldInsert() {
        return " (codigo,autor,existencias,precio,imagen,descripcion,tipo_producto_id) VALUES(?,?,?,?,?,?,?)";
    }

    private String getFieldFilter(String campo) {
        return " OR UPPER(" + campo + ") LIKE ?";
    }

    @Override
    public String getFieldConcat() {

        return " id LIKE ?"
                + getFieldFilter("codigo")
                + getFieldFilter("autor")
                + getFieldFilter("existencias")
                + getFieldFilter("precio")
                + getFieldFilter("imagen")
                + getFieldFilter("descripcion");

    }

    @Override
    public PreparedStatement setFilter(int numparam,
            PreparedStatement oPreparedStatement, String word, int rpp, int offset)
            throws Exception {

        for (int i = 0; i <= 6; i++) {
            oPreparedStatement.setString(++numparam, "%"+word+"%");
        }
        oPreparedStatement.setInt(++numparam, rpp);
        oPreparedStatement.setInt(++numparam, offset);
        return oPreparedStatement;
    }

    @Override
    public PreparedStatement setFieldInsert(BeanInterface oBeanParam,
            PreparedStatement oPreparedStatement) throws Exception {
        ProductoBean oProductoBean = (ProductoBean) oBeanParam;
        oPreparedStatement.setString(1, oProductoBean.getCodigo());
        oPreparedStatement.setString(2, oProductoBean.getAutor());
        oPreparedStatement.setInt(3, oProductoBean.getExistencias());
        oPreparedStatement.setDouble(4, oProductoBean.getPrecio());
        oPreparedStatement.setString(5, oProductoBean.getImagen());
        oPreparedStatement.setString(6, oProductoBean.getDescripcion());
        oPreparedStatement.setInt(7, oProductoBean.getTipo_producto_id());
        return oPreparedStatement;
    }

    @Override
    public String getFieldUpdate() {
        return " codigo=?,autor=?,existencias=?,precio=?,imagen=?,descripcion=?,tipo_producto_id=? ";
    }

    @Override
    public PreparedStatement setFieldUpdate(BeanInterface oBeanParam,
            PreparedStatement oPreparedStatement) throws Exception {
        ProductoBean oProductoBean = (ProductoBean) oBeanParam;
        oPreparedStatement.setString(1, oProductoBean.getCodigo());
        oPreparedStatement.setString(2, oProductoBean.getAutor());
        oPreparedStatement.setInt(3, oProductoBean.getExistencias());
        oPreparedStatement.setDouble(4, oProductoBean.getPrecio());
        oPreparedStatement.setString(5, oProductoBean.getImagen());
        oPreparedStatement.setString(6, oProductoBean.getDescripcion());
        oPreparedStatement.setInt(7, oProductoBean.getTipo_producto_id());
        oPreparedStatement.setInt(8, oProductoBean.getId());
        return oPreparedStatement;
    }

    @Override
    public String getFieldLink() {
        return "link_compra";
    }

    @Override
    public String getFieldId(String filter) {
        return "tipo_producto_id";
    }

    @Override
    public PreparedStatement setFieldId(int numparam,
            PreparedStatement oPreparedStatement, int id, int rpp, int offset)
            throws Exception {
        oPreparedStatement.setInt(++numparam, id);
        oPreparedStatement.setInt(++numparam, rpp);
        oPreparedStatement.setInt(++numparam, offset);
        return oPreparedStatement;
    }

    @Override
    public String getFieldOrder(String orden) {
        return orden.matches("id|codigo|autor|existencias|descripcion|precio") ? orden : null;
    }

}