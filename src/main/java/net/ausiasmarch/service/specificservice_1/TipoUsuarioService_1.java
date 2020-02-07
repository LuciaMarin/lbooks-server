package net.ausiasmarch.service.specificservice_1;

import javax.servlet.http.HttpServletRequest;
import net.ausiasmarch.service.genericservice.GenericService;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;

public class TipoUsuarioService_1 extends GenericService implements ServiceInterface {

    public TipoUsuarioService_1(HttpServletRequest oRequest) {
        super(oRequest);
    }
}
