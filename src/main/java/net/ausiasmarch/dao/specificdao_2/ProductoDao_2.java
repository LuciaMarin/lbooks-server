package net.ausiasmarch.dao.specificdao_2;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;
import net.ausiasmarch.exceptions.MyException;

public class ProductoDao_2 extends GenericDao implements DaoInterface {

    public ProductoDao_2(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "producto", oUsuarioBeanSession);
    }

    @Override
    public Integer remove(int id) throws Exception {
        throw new MyException(5000, "Error en Dao remove de " + ob + ": No autorizado");
    }

}
