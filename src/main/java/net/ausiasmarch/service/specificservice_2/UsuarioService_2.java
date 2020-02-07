package net.ausiasmarch.service.specificservice_2;

import com.google.gson.Gson;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_2.UsuarioDao_2;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.service.genericservice.GenericService;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;
import net.ausiasmarch.setting.ConnectionSettings;

public class UsuarioService_2 extends GenericService implements ServiceInterface {

    Connection oConnection = null;
    ResponseBean oResponseBean = null;
    Gson oGson = GsonFactory.getGson();
    ConnectionInterface oConnectionImplementation = null;
    HttpSession oSession = oRequest.getSession();

    public UsuarioService_2(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public String login() throws Exception {
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioDao_2 oUsuarioDao = new UsuarioDao_2(oConnection, ob, oUsuarioBeanSession);
            UsuarioBean oUsuarioBean;
            String login = oRequest.getParameter("username");
            String password = oRequest.getParameter("password");
            oUsuarioBean = oUsuarioDao.get(login, password);

            if (oUsuarioBean != null) {
                if (oRequest.getParameter("username").equals(oUsuarioBean.getLogin()) && oRequest.getParameter("password").equalsIgnoreCase(oUsuarioBean.getPassword())) {
                    oSession.setAttribute("usuario", oRequest.getParameter("username"));
                    oResponseBean = new ResponseBean(200, "Welcome");
                } else {
                    oResponseBean = new ResponseBean(500, "Wrong password");
                }
            } else {
                oResponseBean = new ResponseBean(500, "Wrong password");
            }

            return oGson.toJson(oResponseBean);
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oConnectionImplementation != null) {
                oConnectionImplementation.disposeConnection();
            }
        }
    }

    public String check() throws Exception {
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioBean oUsuarioBean;
            oUsuarioBean = (UsuarioBean) oSession.getAttribute("usuario");
            UsuarioDao_2 oUsuarioDao = new UsuarioDao_2(oConnection, ob, oUsuarioBeanSession);

            if (oUsuarioBean == null) {
                oResponseBean = new ResponseBean(500, "No autorizado");
            } else {
                oUsuarioBean = oUsuarioDao.get(oUsuarioBean.getLogin());
                return "{\"status\":200,\"message\":" + oGson.toJson(oUsuarioBean) + "}";
            }

        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oConnectionImplementation != null) {
                oConnectionImplementation.disposeConnection();
            }
        }
        return oGson.toJson(oResponseBean);
    }

    public String logout() {
        oRequest.getSession().invalidate();
        ResponseBean oResponseBean = new ResponseBean(200, "No active session");
        return oGson.toJson(oResponseBean);
    }
}
