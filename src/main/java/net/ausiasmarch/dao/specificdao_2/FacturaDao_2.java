package net.ausiasmarch.dao.specificdao_2;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import java.util.ArrayList;
import net.ausiasmarch.bean.BeanInterface;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;
import net.ausiasmarch.exceptions.MyException;

public class FacturaDao_2 extends GenericDao implements DaoInterface {

    public FacturaDao_2(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "factura", oUsuarioBeanSession);
        this.strSQL = "SELECT * FROM " + ob;
        this.strCountSQL = "SELECT COUNT(*) FROM " + ob;
    }

    @Override
    public BeanInterface get(int id) throws Exception {
        strGetSQL += " WHERE usuario_id=" + oUsuarioBeanSession.getId();
        return super.get(id);
    }

    @Override
    public Integer getCount(Integer id, String filter) throws Exception {
        strCountSQL += " WHERE usuario_id=" + oUsuarioBeanSession.getId();
        return super.getCount(id, filter);
    }

    @Override
    public ArrayList<BeanInterface> getPage(int page, int rpp, String orden, String direccion, String word, Integer id, String filter) throws Exception {
        strSQL += " WHERE usuario_id = " + oUsuarioBeanSession.getId();
        return super.getPage(page, rpp, orden, direccion, word, id, filter);
    }

    @Override
    public Integer remove(int id) throws Exception {
        throw new MyException(4000, "Error en Dao remove de " + ob + ": No autorizado");
    }

    @Override
    public Integer update(BeanInterface oBeanParam) throws Exception {
        throw new MyException(4001, "Error en Dao update de " + ob + ": No autorizado");
    }

}
