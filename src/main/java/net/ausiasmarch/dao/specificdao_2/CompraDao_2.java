package net.ausiasmarch.dao.specificdao_2;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import java.util.ArrayList;
import net.ausiasmarch.bean.BeanInterface;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;
import net.ausiasmarch.exceptions.MyException;

public class CompraDao_2 extends GenericDao implements DaoInterface {

    public CompraDao_2(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "compra", oUsuarioBeanSession);
    }

    @Override
    public BeanInterface get(int id) throws Exception {
        strGetSQL += "SELECT compra.* FROM compra "
                + "INNER JOIN factura ON "
                + "factura.id = compra.factura_id "
                + "INNER JOIN usuario ON usuario.id = factura.usuario_id "
                + "WHERE compra.id = ? AND factura.usuario_id = " + oUsuarioBeanSession.getId();
        return super.get(id);
    }

    @Override
    public Integer getCount(Integer id, String filter) throws Exception {
        strCountSQL = "SELECT COUNT(*) FROM compra "
                + "INNER JOIN factura ON "
                + "factura.id = compra.factura_id "
                + "INNER JOIN usuario ON usuario.id = factura.usuario_id "
                + "WHERE factura.usuario_id = " + oUsuarioBeanSession.getId();
        return super.getCount(id, filter);
    }

    @Override
    public ArrayList<BeanInterface> getPage(int page, int rpp, String orden,
            String direccion, String word, Integer id, String filter) throws Exception {
        if (id == null) {
            strSQL = "SELECT compra.* FROM compra "
                    + "INNER JOIN factura ON "
                    + "factura.id = compra.factura_id "
                    + "INNER JOIN usuario ON usuario.id = factura.usuario_id "
                    + "WHERE factura.usuario_id = " + oUsuarioBeanSession.getId();
        } else {
            strSQL = "SELECT compra.* FROM compra "
                    + "INNER JOIN factura ON "
                    + "factura.id = compra.factura_id "
                    + "INNER JOIN usuario ON usuario.id = factura.usuario_id "
                    + "WHERE factura_id = " + id + " "
                    + "AND usuario_id = " + oUsuarioBeanSession.getId();
        }
        return super.getPage(page, rpp, orden, direccion, word, id, filter);
    }

    @Override
    public Integer remove(int id) throws Exception {
        throw new MyException(3000, "Error en Dao remove de " + ob + ": No autorizado");
    }

    @Override
    public Integer update(BeanInterface oBeanParam) throws Exception {
        throw new MyException(3001, "Error en Dao update de " + ob + ": No autorizado");
    }

}
