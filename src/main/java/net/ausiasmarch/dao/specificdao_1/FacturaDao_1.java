package net.ausiasmarch.dao.specificdao_1;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;

public class FacturaDao_1 extends GenericDao implements DaoInterface {

    public FacturaDao_1(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "factura", oUsuarioBeanSession);
    }

}
