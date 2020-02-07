package net.ausiasmarch.dao.specificdao_1;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;

public class TipoUsuarioDao_1 extends GenericDao implements DaoInterface {

    public TipoUsuarioDao_1(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "tipo_usuario", oUsuarioBeanSession);
    }
}
