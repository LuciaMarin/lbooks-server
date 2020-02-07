package net.ausiasmarch.dao.genericdao;

import net.ausiasmarch.dao.daointerface.DaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.ausiasmarch.bean.BeanInterface;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.BeanFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.setting.ConfigurationSettings;

public class GenericDao implements DaoInterface {

    protected Connection oConnection = null;
    protected String ob = null;
    protected String strSQL = null;
    protected String strCountSQL = null;
    protected String strGetSQL = null;
    protected UsuarioBean oUsuarioBeanSession;
    protected int idSessionUser;
    protected int idSessionUserTipe;

    public GenericDao(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        this.oConnection = oConnection;
        this.ob = ob;
        //Sentencias SQL
        this.strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
        this.strCountSQL = "SELECT COUNT(*) FROM " + ob + " WHERE 1=1 ";
        this.strGetSQL = "SELECT * FROM " + ob + " WHERE id=?";

        if (oUsuarioBeanSession != null) {
            this.oUsuarioBeanSession = oUsuarioBeanSession;
            this.idSessionUser = oUsuarioBeanSession.getId();
            this.idSessionUserTipe = oUsuarioBeanSession.getTipo_usuario_id();
        }
    }

    @Override
    public BeanInterface get(int id) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        BeanInterface oBean = null;
        strSQL = "Select * From " + ob + " WHERE id=?";
        oPreparedStatement = oConnection.prepareStatement(strSQL);
        oPreparedStatement.setInt(1, id);
        oResultSet = oPreparedStatement.executeQuery();
        try {
            if (oResultSet.next()) {
                oBean = BeanFactory.getBean(ob);
                oBean = oBean.fill(oResultSet, oConnection, ConfigurationSettings.spread, oUsuarioBeanSession);
            } else {
                oBean = null;
            }
            return oBean;
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
    }

    @Override
    public Integer getCount(Integer id, String filter) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        BeanInterface oBean = BeanFactory.getBean(ob);
        try {
            if (id != null && filter != null) {
                strCountSQL += " AND " + oBean.getFieldId(filter) + " = " + id;
            }
            oPreparedStatement = oConnection.prepareStatement(strCountSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                return oResultSet.getInt(1);
            } else {
                return -1;
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

    }

    @Override
    public ArrayList<BeanInterface> getPage(int page, int rpp, String orden, String direccion, String word, Integer id, String filter) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        ArrayList<BeanInterface> listaBean = new ArrayList<>();
        try {
            BeanInterface oBean = BeanFactory.getBean(ob);
            int offset;
            if (page == 1) {
                offset = 0;
            } else {
                offset = (rpp * page) - rpp;
            }
            int numparam = 0;
            //Condicion de ordenar
            if (orden == null) {
                strSQL += " LIMIT ? OFFSET ?";
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oPreparedStatement.setInt(++numparam, rpp);
                oPreparedStatement.setInt(++numparam, offset);
            } else {
                strSQL += " ORDER BY " + oBean.getFieldOrder(orden);
                if (direccion.equalsIgnoreCase("asc")) {
                    strSQL += " ASC ";
                } else if (direccion.equalsIgnoreCase("desc")) {
                    strSQL += " DESC ";
                }
                strSQL += "LIMIT ? OFFSET ?";

                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oPreparedStatement.setInt(++numparam, rpp);
                oPreparedStatement.setInt(++numparam, offset);
            }
            numparam = 0;
            if (word != null) {
                strSQL = "SELECT * FROM " + ob + " WHERE 1=1 AND " + oBean.getFieldConcat() + " LIMIT ? OFFSET ?";
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oPreparedStatement = oBean.setFilter(numparam, oPreparedStatement, word, rpp, offset);
            }
            //Condicion de busqueda
            numparam = 0;
            //Condicion de filtro de objeto
            if (id != null && filter != null) {
                if (idSessionUser == 1) {
                    strSQL += "";
                    oPreparedStatement = oConnection.prepareStatement("SELECT * FROM " + ob + " INNER JOIN " + filter
                            + " ON " + filter + ".id = " + ob + "." + oBean.getFieldId(filter)
                            + " WHERE " + oBean.getFieldId(filter) + " = ?  LIMIT ? OFFSET ?");
                    oPreparedStatement = oBean.setFieldId(numparam, oPreparedStatement, id, rpp, offset);

                }
            }

            oResultSet = oPreparedStatement.executeQuery();

            while (oResultSet.next()) {
                oBean = BeanFactory.getBean(ob);
                oBean = oBean.fill(oResultSet, oConnection, ConfigurationSettings.spread, oUsuarioBeanSession);
                listaBean.add(oBean);
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
        return listaBean;
    }

    @Override
    public Integer insert(BeanInterface oBeanParam) throws Exception {
        BeanInterface oBean = BeanFactory.getBean(ob);
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        int iResult = 0;
        try {
            String strsql = "INSERT INTO " + ob + oBean.getFieldInsert();
            oPreparedStatement = oConnection.prepareStatement(strsql, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement = oBean.setFieldInsert(oBeanParam, oPreparedStatement);
            iResult = oPreparedStatement.executeUpdate();
            oResultSet = oPreparedStatement.getGeneratedKeys();
            oResultSet.next();
            iResult = oResultSet.getInt(1);
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
        PreparedStatement oPreparedStatement = null;
        int iResult = 0;
        try {
            String strSQL = "DELETE FROM " + ob + " WHERE id=?";
            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement.setInt(1, id);
            iResult = oPreparedStatement.executeUpdate();
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
        return iResult;
    }

    @Override
    public Integer update(BeanInterface oBeanParam) throws Exception {
        BeanInterface oBean = BeanFactory.getBean(ob);
        PreparedStatement oPreparedStatement = null;
        int iResult = 0;
        try {
            String strSQL = "UPDATE " + ob + " SET " + oBean.getFieldUpdate() + " WHERE id = ?";
            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            oPreparedStatement = oBean.setFieldUpdate(oBeanParam, oPreparedStatement);
            iResult = oPreparedStatement.executeUpdate();
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
        return iResult;
    }

}
