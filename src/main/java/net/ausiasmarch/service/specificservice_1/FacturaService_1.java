package net.ausiasmarch.service.specificservice_1;

import net.ausiasmarch.service.genericservice.GenericService;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpServletRequest;
import net.ausiasmarch.bean.FacturaBean;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_1.FacturaDao_1;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;
import net.ausiasmarch.setting.ConnectionSettings;

public class FacturaService_1 extends GenericService implements ServiceInterface {

    public FacturaService_1(HttpServletRequest request) {
        super(request);
        ob = oRequest.getParameter("ob");
    }

    public String fill() throws Exception {
        ConnectionInterface oConnectionImplementation = null;
        Connection oConnection = null;
        ResponseBean oResponseBean = null;
        Gson oGson = GsonFactory.getGson();
        try {
            oConnectionImplementation = ConnectionFactory
                    .getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            FacturaDao_1 oFacturaDao = new FacturaDao_1(oConnection, ob, oUsuarioBeanSession);
            Date date1 = new GregorianCalendar(2014, Calendar.JANUARY, 1).getTime();
            Date date2 = new GregorianCalendar(2019, Calendar.DECEMBER, 31).getTime();
            int numFactura = Integer.parseInt(oRequest.getParameter("number"));
            for (int i = 0; i < numFactura; i++) {
                FacturaBean oFacturaBean = new FacturaBean();
                Date randomDate = new Date(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));
                oFacturaBean.setIva(21);
                oFacturaBean.setFecha(randomDate);
                oFacturaBean.setUsuario_id((int) (Math.random() * 101) + 2);
                oFacturaDao.insert(oFacturaBean);
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
