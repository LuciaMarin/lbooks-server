package net.ausiasmarch.service.genericservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.bean.BeanInterface;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.daointerface.DaoInterface;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.BeanFactory;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.DaoFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;
import net.ausiasmarch.setting.ConnectionSettings;

public class GenericService implements ServiceInterface {

    protected HttpServletRequest oRequest = null;
    protected String ob = null;
    protected UsuarioBean oUsuarioBeanSession;
    Gson oGson = GsonFactory.getGson();
    ResponseBean oResponseBean = null;

    public GenericService(HttpServletRequest request) {
        this.oRequest = request;
        this.ob = oRequest.getParameter("ob");
        oUsuarioBeanSession = (UsuarioBean) oRequest.getSession().getAttribute("usuario");
    }

    @Override
    public String get() throws Exception {
        ConnectionInterface oConnectionImplementation = null;
        Connection oConnection = null;
        String strJson = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            int id = Integer.parseInt(oRequest.getParameter("id"));
            DaoInterface oDao = DaoFactory.getDao(oConnection, ob, oUsuarioBeanSession);
            BeanInterface oBean = oDao.get(id);
            strJson = oGson.toJson(oBean);

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
        return "{\"status\":200,\"message\":" + strJson + "}";
    }

    @Override
    public String getPage() throws Exception {

        ConnectionInterface oConnectionImplementation = null;
        Connection oConnection = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            int iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
            int iPage = Integer.parseInt(oRequest.getParameter("page"));
            //opcional
            Integer id = null;
            String filter = null; //filtro objeto 
            String orden = null;
            String direccion = null;
            String word = null; // filtro para la busqueda

            if (oRequest.getParameter("filter") != null) {
                filter = oRequest.getParameter("filter");
            }
            if (oRequest.getParameter("id") != null) {
                id = Integer.parseInt(oRequest.getParameter("id"));
            }
            if (oRequest.getParameter("order") != null && oRequest.getParameter("direccion") != null) {
                orden = oRequest.getParameter("order").replace("\"", "`");
                direccion = oRequest.getParameter("direccion");
            }
            if (oRequest.getParameter("word") != null) {
                word = oRequest.getParameter("word");
            }
            // acaba opcional
            DaoInterface oDao = DaoFactory.getDao(oConnection, ob, oUsuarioBeanSession);
            ArrayList alBean = oDao.getPage(iPage, iRpp, orden, direccion, word, id, filter); //--------DAO GETPAGE--------
            String strJson = null;
            strJson = oGson.toJson(alBean);
            return "{\"status\":200,\"message\":" + strJson + "}";
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

    @Override
    public String getCount() throws Exception {
        ConnectionInterface oConnectionImplementation = null;
        Connection oConnection = null;
        Integer iCount = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            Integer id = null;
            String filter = null;
            if (oRequest.getParameter("filter") != null) {
                filter = oRequest.getParameter("filter");
            }
            if (oRequest.getParameter("id") != null) {
                id = Integer.parseInt(oRequest.getParameter("id"));
            }
            DaoInterface oDao = DaoFactory.getDao(oConnection, ob, oUsuarioBeanSession);
            iCount = oDao.getCount(id, filter);
            if (iCount < 0) {
                oResponseBean = new ResponseBean(500, iCount.toString());
            } else {
                oResponseBean = new ResponseBean(200, iCount.toString());
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

    @Override
    public String update() throws Exception {
        if (oUsuarioBeanSession.getTipo_usuario_obj().getId() == 1) {
            HttpSession oSession = oRequest.getSession();
            if (oSession.getAttribute("usuario") != null) {
                ConnectionInterface oConnectionImplementation = null;
                Connection oConnection = null;
                try {
                    oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
                    oConnection = oConnectionImplementation.newConnection();
                    BeanInterface oBean = BeanFactory.getBean(ob);
                    String data = oRequest.getParameter("data");
                    oBean = BeanFactory.getBeanFromJson(ob, data);
                    DaoInterface oDao = DaoFactory.getDao(oConnection, ob, oUsuarioBeanSession);
                    if (oDao.update(oBean) == 0) {
                        oResponseBean = new ResponseBean(500, "KO");
                    } else {
                        oResponseBean = new ResponseBean(200, "OK");
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
            } else {
                oResponseBean = new ResponseBean(401, "Error: No session");
            }
        } else {
            oResponseBean = new ResponseBean(401, "No autorizado");
        }
        return oGson.toJson(oResponseBean);
    }

    @Override
    public String insert() throws Exception {
        HttpSession oSession = oRequest.getSession();
        int tipousuario = 0;
        if (oSession.getAttribute("usuario") != null) {
            if (ob.equals("usuario")) {
                UsuarioBean oUsuarioBean = (UsuarioBean) oSession.getAttribute("usuario");
                tipousuario = oUsuarioBean.getTipo_usuario_id();
            }
            if (ob.equals("usuario") && tipousuario != 1) {
                oResponseBean = new ResponseBean(500, "Permiso denegado");
            } else {
                ConnectionInterface oConnectionImplementation = null;
                Connection oConnection = null;
                try {
                    oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
                    oConnection = oConnectionImplementation.newConnection();
                    final GsonBuilder builder = new GsonBuilder();
                    builder.excludeFieldsWithoutExposeAnnotation();
                    BeanInterface oBean = BeanFactory.getBean(ob);
                    oBean = BeanFactory.getBeanFromJson(ob, oRequest.getParameter("data"));
                    DaoInterface oDao = DaoFactory.getDao(oConnection, ob, oUsuarioBeanSession);
                    if (oDao.insert(oBean) == 0) {
                        oResponseBean = new ResponseBean(500, "KO");
                    } else {
                        oResponseBean = new ResponseBean(200, "OK");
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
        } else {
            oResponseBean = new ResponseBean(401, "Error: No session");
        }
        return oGson.toJson(oResponseBean);
    }

    @Override
    public String remove() throws Exception {
        HttpSession oSession = oRequest.getSession();
        if (oSession.getAttribute("usuario") != null) {
            ConnectionInterface oConnectionImplementation = null;
            Connection oConnection = null;
            try {
                oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
                oConnection = oConnectionImplementation.newConnection();
                DaoInterface oDao = DaoFactory.getDao(oConnection, ob, oUsuarioBeanSession);
                int id = Integer.parseInt(oRequest.getParameter("id"));
                if (oDao.remove(id) == 0) {
                    oResponseBean = new ResponseBean(500, "KO");
                } else {
                    oResponseBean = new ResponseBean(200, "OK");
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
        } else {
            oResponseBean = new ResponseBean(401, "Error: No session");
            return oGson.toJson(oResponseBean);
        }
    }
}
