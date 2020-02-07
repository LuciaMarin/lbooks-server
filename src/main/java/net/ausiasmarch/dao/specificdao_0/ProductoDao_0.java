package net.ausiasmarch.dao.specificdao_0;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import net.ausiasmarch.bean.BeanInterface;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;
import net.ausiasmarch.exceptions.MyException;

public class ProductoDao_0 extends GenericDao implements DaoInterface {

    public ProductoDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "producto", oUsuarioBeanSession);
    }

    @Override
    public Integer insert(BeanInterface oBean) throws Exception {
        throw new MyException(3000, "Error en Dao remove de " + ob + ": No autorizado");
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
