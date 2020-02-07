package net.ausiasmarch.service.specificservice_2;

import javax.servlet.http.HttpServletRequest;
import net.ausiasmarch.service.genericservice.GenericService;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;

public class ProductoService_2 extends GenericService implements ServiceInterface {

    public ProductoService_2(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }
}
