package net.ausiasmarch.factory;

import javax.servlet.http.HttpServletRequest;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.service.specificservice_0.CarritoService_0;
import net.ausiasmarch.service.specificservice_0.ProductoService_0;
import net.ausiasmarch.service.specificservice_0.UsuarioService_0;
import net.ausiasmarch.service.specificservice_1.CompraService_1;
import net.ausiasmarch.service.specificservice_1.FacturaService_1;
import net.ausiasmarch.service.specificservice_1.ProductoService_1;
import net.ausiasmarch.service.specificservice_1.TipoProductoService_1;
import net.ausiasmarch.service.specificservice_1.TipoUsuarioService_1;
import net.ausiasmarch.service.specificservice_1.UsuarioService_1;
import net.ausiasmarch.service.specificservice_2.CarritoService_2;
import net.ausiasmarch.service.specificservice_2.CompraService_2;
import net.ausiasmarch.service.specificservice_2.FacturaService_2;
import net.ausiasmarch.service.specificservice_2.ProductoService_2;
import net.ausiasmarch.service.specificservice_2.TipoProductoService_2;
import net.ausiasmarch.service.specificservice_2.TipoUsuarioService_2;
import net.ausiasmarch.service.specificservice_2.UsuarioService_2;

public class ServiceCall {

    HttpServletRequest oRequest;

    public static String executeService(HttpServletRequest oRequest) throws Exception {
        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");
        String strResult;

        int idSessionUserTipe;
        UsuarioBean oUsuarioBeanSession = (UsuarioBean) oRequest.getSession().getAttribute("usuario");
        if (oUsuarioBeanSession != null) {
            idSessionUserTipe = oUsuarioBeanSession.getTipo_usuario_obj().getId();
        } else {
            idSessionUserTipe = 0;
        }
        switch (idSessionUserTipe) {
            case 0:
                switch (ob) {
                    case "usuario":
                        UsuarioService_0 oUsuarioService = new UsuarioService_0(oRequest);
                        switch (op) {
                            case "login":
                                strResult = oUsuarioService.login();
                                break;
                            case "loginValidate":
                                strResult = oUsuarioService.loginValidate();
                                break;
                            case "check":
                                strResult = oUsuarioService.check();
                                break;
                            case "signup":
                                strResult = oUsuarioService.signup();
                                break;
                            case "recover":
                                strResult = oUsuarioService.recover();
                                break;
                            case "changePassword":
                                strResult = oUsuarioService.changePassword();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "producto":
                        ProductoService_0 oProductoService = new ProductoService_0(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oProductoService.get();
                                break;
                            case "getcount":
                                strResult = oProductoService.getCount();
                                break;
                            case "getpage":
                                strResult = oProductoService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "carrito":
                        CarritoService_0 oCarritoService = new CarritoService_0(oRequest);
                        switch (op) {
                            case "add":
                                strResult = oCarritoService.add();
                                break;
                            case "list":
                                strResult = oCarritoService.list();
                                break;
                            case "empty":
                                strResult = oCarritoService.empty();
                                break;
                            case "remove":
                                strResult = oCarritoService.remove();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    default:
                        strResult = "Object doesn't exist";
                        break;
                }
                break;
            case 1:
                switch (ob) {
                    case "tipo_usuario":
                        TipoUsuarioService_1 oTipousuarioService = new TipoUsuarioService_1(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oTipousuarioService.get();
                                break;
                            case "insert":
                                strResult = oTipousuarioService.insert();
                                break;
                            case "update":
                                strResult = oTipousuarioService.update();
                                break;
                            case "remove":
                                strResult = oTipousuarioService.remove();
                                break;
                            case "getcount":
                                strResult = oTipousuarioService.getCount();
                                break;
                            case "getpage":
                                strResult = oTipousuarioService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "usuario":
                        UsuarioService_1 oUsuarioService = new UsuarioService_1(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oUsuarioService.get();
                                break;
                            case "insert":
                                strResult = oUsuarioService.insert();
                                break;
                            case "update":
                                strResult = oUsuarioService.update();
                                break;
                            case "remove":
                                strResult = oUsuarioService.remove();
                                break;
                            case "getcount":
                                strResult = oUsuarioService.getCount();
                                break;
                            case "getpage":
                                strResult = oUsuarioService.getPage();
                                break;
                            case "fill":
                                strResult = oUsuarioService.fill();
                                break;
                            case "login":
                                strResult = oUsuarioService.login();
                                break;
                            case "logout":
                                strResult = oUsuarioService.logout();
                                break;
                            case "check":
                                strResult = oUsuarioService.check();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "factura":
                        FacturaService_1 oFacturaService = new FacturaService_1(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oFacturaService.get();
                                break;
                            case "insert":
                                strResult = oFacturaService.insert();
                                break;
                            case "update":
                                strResult = oFacturaService.update();
                                break;
                            case "remove":
                                strResult = oFacturaService.remove();
                                break;
                            case "getcount":
                                strResult = oFacturaService.getCount();
                                break;
                            case "getpage":
                                strResult = oFacturaService.getPage();
                                break;
                            case "fill":
                                strResult = oFacturaService.fill();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "compra":
                        CompraService_1 oCompraService = new CompraService_1(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oCompraService.get();
                                break;
                            case "insert":
                                strResult = oCompraService.insert();
                                break;
                            case "update":
                                strResult = oCompraService.update();
                                break;
                            case "remove":
                                strResult = oCompraService.remove();
                                break;
                            case "getcount":
                                strResult = oCompraService.getCount();
                                break;
                            case "getpage":
                                strResult = oCompraService.getPage();
                                break;
                            case "fill":
                                strResult = oCompraService.fill();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "producto":
                        ProductoService_1 oProductoService = new ProductoService_1(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oProductoService.get();
                                break;
                            case "insert":
                                strResult = oProductoService.insert();
                                break;
                            case "update":
                                strResult = oProductoService.update();
                                break;
                            case "remove":
                                strResult = oProductoService.remove();
                                break;
                            case "fill":
                                strResult = oProductoService.fill();
                                break;
                            case "getcount":
                                strResult = oProductoService.getCount();
                                break;
                            case "getpage":
                                strResult = oProductoService.getPage();
                                break;
                            case "addimage":
                                strResult = oProductoService.addimage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "tipo_producto":
                        TipoProductoService_1 oTipoproductoService = new TipoProductoService_1(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oTipoproductoService.get();
                                break;
                            case "insert":
                                strResult = oTipoproductoService.insert();
                                break;
                            case "update":
                                strResult = oTipoproductoService.update();
                                break;
                            case "remove":
                                strResult = oTipoproductoService.remove();
                                break;
                            case "getcount":
                                strResult = oTipoproductoService.getCount();
                                break;
                            case "getpage":
                                strResult = oTipoproductoService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    default:
                        strResult = "Object doesn't exist";
                        break;
                }
                break;
            case 2:
                switch (ob) {
                    case "usuario":
                        UsuarioService_2 oUsuarioService = new UsuarioService_2(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oUsuarioService.get();
                                break;
                            case "update":
                                strResult = oUsuarioService.update();
                                break;
                            case "logout":
                                strResult = oUsuarioService.logout();
                                break;
                            case "check":
                                strResult = oUsuarioService.check();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "tipo_usuario":
                        TipoUsuarioService_2 oTipousuarioService = new TipoUsuarioService_2(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oTipousuarioService.get();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "factura":
                        FacturaService_2 oFacturaService = new FacturaService_2(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oFacturaService.get();
                                break;
                            case "getcount":
                                strResult = oFacturaService.getCount();
                                break;
                            case "getpage":
                                strResult = oFacturaService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "compra":
                        CompraService_2 oCompraService = new CompraService_2(oRequest);
                        String pepe = oRequest.getParameter("idfactura");
                        switch (op) {
                            case "get":
                                strResult = oCompraService.get();
                                break;
                            case "getcount":
                                strResult = oCompraService.getCount();
                                break;
                            case "getpage":
                                strResult = oCompraService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;

                    case "producto":
                        ProductoService_2 oProductoService = new ProductoService_2(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oProductoService.get();
                                break;
                            case "getcount":
                                strResult = oProductoService.getCount();
                                break;
                            case "getpage":
                                strResult = oProductoService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "tipo_producto":
                        TipoProductoService_2 oTipoproductoService = new TipoProductoService_2(oRequest);
                        switch (op) {
                            case "get":
                                strResult = oTipoproductoService.get();
                                break;
                            case "getcount":
                                strResult = oTipoproductoService.getCount();
                                break;
                            case "getpage":
                                strResult = oTipoproductoService.getPage();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    case "carrito":
                        CarritoService_2 oCarritoService = new CarritoService_2(oRequest);
                        switch (op) {
                            case "add":
                                strResult = oCarritoService.add();
                                break;
                            case "list":
                                strResult = oCarritoService.list();
                                break;
                            case "empty":
                                strResult = oCarritoService.empty();
                                break;
                            case "remove":
                                strResult = oCarritoService.remove();
                                break;
                            case "buy":
                                strResult = oCarritoService.buy();
                                break;
                            default:
                                strResult = "Operation doesn't exist";
                                break;
                        }
                        break;
                    default:
                        strResult = "object doesn't exist";
                        break;
                }
                break;
            default:
                strResult = "profile doesn't exist";
                break;
        }
        return strResult;
    }
}
