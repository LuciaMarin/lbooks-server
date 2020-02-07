package net.ausiasmarch.service.specificservice_1;

import com.google.gson.Gson;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.TipoProductoBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_1.TipoProductoDao_1;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.service.genericservice.GenericService;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;
import net.ausiasmarch.setting.ConnectionSettings;

public class TipoProductoService_1 extends GenericService implements ServiceInterface {

    String[] frasesInicio = {"Alimentación ", "Juguetes ", "Electronica ", "Higiene "};
    String[] frasesFinal = {"del hogar. ", "de la empresa. ", "para centros educativos. ", "sanitaria. "};

    public TipoProductoService_1(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public String fill() throws Exception {
        ConnectionInterface oConnectionImplementation = null;
        Connection oConnection = null;
        try {
            oConnectionImplementation = ConnectionFactory
                    .getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            TipoProductoDao_1 oTipoProductoDao = new TipoProductoDao_1(oConnection, ob, oUsuarioBeanSession);
            Gson oGson = GsonFactory.getGson();
            int numProd = Integer.parseInt(oRequest.getParameter("number"));
            for (int i = 0; i < numProd; i++) {
                TipoProductoBean oTipoProductoBean = new TipoProductoBean();
                oTipoProductoBean.setDescripcion(this.generaTexto(1));
                oTipoProductoDao.insert(oTipoProductoBean);
            }
            ResponseBean oResponseBean = new ResponseBean(200, "Insertados los registros con exito");
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

    private String generaTexto(int longitud) {
        String fraseRandom = "";
        for (int i = 0; i < longitud; i++) {
            fraseRandom += frasesInicio[(int) (Math.random() * frasesInicio.length) + 0];
            fraseRandom += frasesFinal[(int) (Math.random() * frasesFinal.length) + 0];
        }
        return fraseRandom;
    }

}
