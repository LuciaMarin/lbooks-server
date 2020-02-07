package net.ausiasmarch.service.specificservice_1;

import com.google.gson.Gson;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_1.UsuarioDao_1;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.service.genericservice.GenericService;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;
import net.ausiasmarch.setting.ConnectionSettings;

public class UsuarioService_1 extends GenericService implements ServiceInterface {

    Connection oConnection = null;
    ResponseBean oResponseBean = null;
    Gson oGson = GsonFactory.getGson();
    ConnectionInterface oConnectionImplementation = null;
    HttpSession oSession = oRequest.getSession();

    public UsuarioService_1(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public String login() throws Exception {
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioDao_1 oUsuarioDao = new UsuarioDao_1(oConnection, ob, oUsuarioBeanSession);
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
            UsuarioDao_1 oUsuarioDao = new UsuarioDao_1(oConnection, ob, oUsuarioBeanSession);

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
        oResponseBean = new ResponseBean(200, "No active session");
        return oGson.toJson(oResponseBean);
    }

    /*FILL*/
    String[] nombre = {"Marcel·li", "Pompeu", "Cirili", "Paco",
        "Josepa", "Vidal", "Domènec", "Maurici", "Eudald", "Miqueleta", "Bernat", "Jaumet", "Pepet"};
    String[] apellido1 = {"de Cal", "el de", "de la",
        "dels", "de Can", "de les", "Ca la", "Pacoco"};
    String[] apellido2 = {"Pacoco", "Clapés",
        "Trencapins", "Palla", "Cargols", "Metge", "Murallot", "Porrons", "Cigrons", "Llobarro", "Faves", "Cebes", "Freda"};

    public String fill() throws Exception {
        try {
            oConnectionImplementation = ConnectionFactory
                    .getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioDao_1 oUsuarioDao = new UsuarioDao_1(oConnection, ob, oUsuarioBeanSession);

            int numUsuario = Integer.parseInt(oRequest.getParameter("number"));
            for (int i = 0; i < numUsuario; i++) {
                UsuarioBean oUsuarioBean = new UsuarioBean();
                oUsuarioBean.setDni((int) Math.floor(Math.random() * (10000000 - 99999999) + 99999999) + "O");
                String nombrePersona = nombre[(int) (Math.random() * nombre.length) + 0];
                String apellido1Persona = apellido1[(int) (Math.random() * apellido1.length) + 0];
                String apellido2Persona = apellido2[(int) (Math.random() * apellido2.length) + 0];
                String username = nombrePersona.substring(0, 2).toLowerCase().trim()
                        + apellido1Persona.substring(0, 2).toLowerCase().trim()
                        + apellido2Persona.substring(0, 2).toLowerCase().trim()
                        + (int) Math.floor(Math.random() * (1000 - 9999) + 9999);
                oUsuarioBean.setNombre(nombrePersona);
                oUsuarioBean.setApellido1(apellido1Persona);
                oUsuarioBean.setApellido2(apellido2Persona);
                oUsuarioBean.setEmail(username + "@lbooks.com");
                oUsuarioBean.setLogin(username);
                oUsuarioBean.setPassword("ea24338a879ca3755cf7ff3fa05d4889664dc8fb7720dbe59dd0f9bfea187556");
                oUsuarioBean.setTipo_usuario_id(2);
                oUsuarioBean.setToken(null);
                oUsuarioBean.setValidate(Boolean.TRUE);
                oUsuarioDao.insert(oUsuarioBean);
            }
            oResponseBean = new ResponseBean(200, "Insertados los registros con exito");
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

}
