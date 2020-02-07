package net.ausiasmarch.dao.specificdao_1;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;

public class CompraDao_1 extends GenericDao implements DaoInterface {

    public CompraDao_1(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "compra", oUsuarioBeanSession);
    }

}
