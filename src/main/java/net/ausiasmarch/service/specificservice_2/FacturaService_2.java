package net.ausiasmarch.service.specificservice_2;

import net.ausiasmarch.service.genericservice.GenericService;
import javax.servlet.http.HttpServletRequest;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;

public class FacturaService_2 extends GenericService implements ServiceInterface {

    public FacturaService_2(HttpServletRequest request) {
        super(request);
        ob = oRequest.getParameter("ob");
    }
}
