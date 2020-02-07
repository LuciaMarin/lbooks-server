package net.ausiasmarch.factory;

import java.sql.Connection;
import java.sql.SQLException;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.daointerface.DaoInterface;
import net.ausiasmarch.dao.specificdao_0.ProductoDao_0;
import net.ausiasmarch.dao.specificdao_0.UsuarioDao_0;
import net.ausiasmarch.dao.specificdao_1.CompraDao_1;
import net.ausiasmarch.dao.specificdao_1.FacturaDao_1;
import net.ausiasmarch.dao.specificdao_1.ProductoDao_1;
import net.ausiasmarch.dao.specificdao_1.TipoProductoDao_1;
import net.ausiasmarch.dao.specificdao_1.TipoUsuarioDao_1;
import net.ausiasmarch.dao.specificdao_1.UsuarioDao_1;
import net.ausiasmarch.dao.specificdao_2.CompraDao_2;
import net.ausiasmarch.dao.specificdao_2.FacturaDao_2;
import net.ausiasmarch.dao.specificdao_2.ProductoDao_2;
import net.ausiasmarch.dao.specificdao_2.TipoProductoDao_2;
import net.ausiasmarch.dao.specificdao_2.TipoUsuarioDao_2;
import net.ausiasmarch.dao.specificdao_2.UsuarioDao_2;
import net.ausiasmarch.exceptions.MyException;

public class DaoFactory {

    public static DaoInterface getDao(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) throws MyException, SQLException {
        DaoInterface oDao = null;
        int idSessionUserTipe;
        if (oUsuarioBeanSession != null) {
            idSessionUserTipe = oUsuarioBeanSession.getTipo_usuario_obj().getId();
        } else {
            idSessionUserTipe = 0;
        }

        switch (idSessionUserTipe) {
            case 1:
                switch (ob) {
                    case "producto":
                        oDao = new ProductoDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "compra":
                        oDao = new CompraDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "factura":
                        oDao = new FacturaDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "tipo_producto":
                        oDao = new TipoProductoDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "tipo_usuario":
                        oDao = new TipoUsuarioDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "usuario":
                        oDao = new UsuarioDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                }
                break;
            case 2:
                switch (ob) {
                    case "producto":
                        oDao = new ProductoDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "compra":
                        oDao = new CompraDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "factura":
                        oDao = new FacturaDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "tipo_producto":
                        oDao = new TipoProductoDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "tipo_usuario":
                        oDao = new TipoUsuarioDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "usuario":
                        oDao = new UsuarioDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                }
                break;
            case 0:
                switch (ob) {
                    case "usuario":
                        oDao = new UsuarioDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "producto":
                        oDao = new ProductoDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "compra":
                        throw new MyException(7000, "Not allowed operation, error en Dao factory de " + ob);
                }
                break;
            default:
                throw new MyException(7000, "Error en Dao factory de " + ob);
        }
        return oDao;
    }
}
