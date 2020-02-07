package net.ausiasmarch.dao.specificdao_0;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import net.ausiasmarch.bean.BeanInterface;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.dao.genericdao.GenericDao;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.setting.ConfigurationSettings;

public class UsuarioDao_0 extends GenericDao implements DaoInterface {

    public UsuarioDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, "usuario", oUsuarioBeanSession);
    }

    public UsuarioBean get(String username, String password) throws Exception {
        strSQL += " AND login=?";
        strSQL += " AND password=?";

        UsuarioBean oUsuarioBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, username);
            oPreparedStatement.setString(2, password);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean = new UsuarioBean();
                oUsuarioBean.fill(oResultSet, oConnection, ConfigurationSettings.spread, oUsuarioBeanSession);
            } else {
                oUsuarioBean = null;
            }
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oUsuarioBean;
    }

    public UsuarioBean get(String username) throws Exception {
        strSQL = "SELECT * FROM usuario WHERE login=?";
        UsuarioBean oUsuarioBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, username);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean = new UsuarioBean();
                oUsuarioBean.fill(oResultSet, oConnection, ConfigurationSettings.spread, oUsuarioBeanSession);
            } else {
                oUsuarioBean = null;
            }
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oUsuarioBean;
    }

    public Integer register(UsuarioBean oUsuarioBean) throws Exception {
        strSQL = "INSERT INTO usuario (dni, nombre, apellido1, apellido2, login, password, email, tipo_usuario_id, token, validate) VALUES (?,?,?,?,?,?,?,2,?,0)";
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        int iResult = 0;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, oUsuarioBean.getDni());
            oPreparedStatement.setString(2, oUsuarioBean.getNombre());
            oPreparedStatement.setString(3, oUsuarioBean.getApellido1());
            oPreparedStatement.setString(4, oUsuarioBean.getApellido2());
            oPreparedStatement.setString(5, oUsuarioBean.getLogin());
            oPreparedStatement.setString(6, oUsuarioBean.getPassword());
            oPreparedStatement.setString(7, oUsuarioBean.getEmail());
            oPreparedStatement.setString(8, oUsuarioBean.getToken());
            iResult = oPreparedStatement.executeUpdate();
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public int insert(String email, String username) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        int iResult = 0;
        try {
            String strsql = "INSERT INTO " + ob + " (login, email, tipo_usuario_id, validate) VALUES (?, ?, 2, 1)";
            oPreparedStatement = oConnection.prepareStatement(strsql, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement.setString(1, username);
            oPreparedStatement.setString(2, email);
            iResult = oPreparedStatement.executeUpdate();
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public Boolean validateToken(String token) throws Exception {
        ResultSet oResultSet = null;
        Boolean result = false;
        PreparedStatement oPreparedStatement = null;
        String strSQL = "SELECT * FROM " + ob + " WHERE token=?";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, token);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                result = true;
            }
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    public Boolean validateUser(String login) throws Exception {
        int iResult = 0;
        Boolean result = false;
        PreparedStatement oPreparedStatement = null;
        String strSQL = "UPDATE " + ob + " SET validate = 1 WHERE login = ?";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, login);
            iResult = oPreparedStatement.executeUpdate();
            if (iResult != 0) {
                result = true;
            }
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return result;
    }

    public UsuarioBean validateEmail(String email) throws Exception {
        UsuarioBean oUsuarioBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;

        String strSQL = "SELECT * FROM " + ob + " WHERE email = ?";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, email);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean = new UsuarioBean();
                oUsuarioBean.fill(oResultSet, oConnection, ConfigurationSettings.spread, oUsuarioBeanSession);
            } else {
                oUsuarioBean = null;
            }

        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }

        return oUsuarioBean;
    }

    public int changeToken(String login, String token) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        int iResult = 0;
        try {
            String strSQL = "UPDATE " + ob + " SET token = ? WHERE login = ?";
            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement.setString(1, token);
            oPreparedStatement.setString(2, login);
            iResult = oPreparedStatement.executeUpdate();
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public int changePassword(String password, String token) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        int iResult = 0;
        try {
            String strSQL = "UPDATE " + ob + " SET password = ? WHERE token = ?";
            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement.setString(1, password);
            oPreparedStatement.setString(2, token);
            iResult = oPreparedStatement.executeUpdate();
        } catch (MyException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            ex.addDescripcion(msg);
            throw ex;
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
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
