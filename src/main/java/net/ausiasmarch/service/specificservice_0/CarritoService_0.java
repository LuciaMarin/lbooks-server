package net.ausiasmarch.service.specificservice_0;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.bean.ItemBean;
import net.ausiasmarch.bean.ProductoBean;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_0.ProductoDao_0;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.setting.ConnectionSettings;

public class CarritoService_0 {

    HttpServletRequest oRequest = null;
    UsuarioBean oUsuarioBeanSession;
    String ob = null;
    Gson oGson = GsonFactory.getGson();
    Connection oConnection = null;

    public CarritoService_0(HttpServletRequest oRequest) {
        super();
        this.oRequest = oRequest;
        ob = oRequest.getParameter("ob");
    }

    public String add() throws Exception {
        @SuppressWarnings("unchecked")
        ItemBean oItemBean = null;
        int id = Integer.parseInt(oRequest.getParameter("id"));
        int cantidad = Integer.parseInt(oRequest.getParameter("cantidad"));
        ConnectionInterface oConnectionImplementation = null;
        ProductoDao_0 oProductoDao = null;
        ResponseBean oResponseBean = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            ProductoBean oProductoBean = new ProductoBean(id);
            oProductoDao = new ProductoDao_0(oConnection, "producto", oUsuarioBeanSession);
            oProductoBean = (ProductoBean) oProductoDao.get(id);
            if (oProductoBean != null) {
                if (cantidad != 0) {
                    oItemBean = new ItemBean(cantidad, oProductoBean);
                    HttpSession oSession = oRequest.getSession();
                    ArrayList<ItemBean> alCarrito = (ArrayList<ItemBean>) oSession.getAttribute("carrito");
                    if (alCarrito == null) {
                        alCarrito = new ArrayList<ItemBean>();
                    }
                    oItemBean = find(alCarrito, oItemBean.getProducto_obj().getId());
                    if (oProductoBean.getExistencias() >= cantidad) {
                        if (oItemBean == null) {
                            oItemBean = new ItemBean(cantidad, oProductoBean);
                            alCarrito.add(oItemBean);
                            oRequest.getSession().setAttribute("carrito", alCarrito);
                            oResponseBean = new ResponseBean(200, "Nuevo producto añadido");
                        } else {
                            int oldCantidad = oItemBean.getCantidad();
                            int newCantidad = oldCantidad + cantidad;
                            if (oProductoBean.getExistencias() >= newCantidad) {
                                oItemBean.setCantidad(oldCantidad + cantidad);
                                oRequest.getSession().setAttribute("carrito", alCarrito);
                                oResponseBean = new ResponseBean(200, "Producto añadido");
                            } else {
                                oResponseBean = new ResponseBean(400, "No hay suficientes existencias para este producto");
                            }
                        }
                    } else {
                        oResponseBean = new ResponseBean(400, "No hay suficientes existencias para este producto");
                    }
                } else {
                    oResponseBean = new ResponseBean(400, "Selecciona una cantidad apropiada");
                }
            } else {
                oResponseBean = new ResponseBean(400, "Este producto no esta almacenador en la tienda");
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

    public String remove() throws Exception {
        int id = Integer.parseInt(oRequest.getParameter("id"));
        HttpSession oSession = oRequest.getSession();
        ConnectionInterface oConnectionImplementation = null;
        ProductoDao_0 oProductoDao = null;
        ProductoBean oProductoBean = null;
        ResponseBean oResponseBean = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            oProductoDao = new ProductoDao_0(oConnection, "producto", oUsuarioBeanSession);
            oProductoBean = (ProductoBean) oProductoDao.get(id);
            if (oProductoBean != null) {
                ArrayList<ItemBean> alCarrito = (ArrayList<ItemBean>) oSession.getAttribute("carrito");
                if (alCarrito != null) {
                    int resultadoFind = this.findRemove(alCarrito, id);
                    if (resultadoFind >= 0) {
                        alCarrito.remove(resultadoFind);
                        if (!alCarrito.isEmpty()) {
                            oRequest.getSession().setAttribute("carrito", alCarrito);
                            oResponseBean = new ResponseBean(200, "Ha eliminado el prodcto del carrito");
                        } else {
                            if (alCarrito.isEmpty()) {
                                oRequest.getSession().setAttribute("carrito", null);
                                oResponseBean = new ResponseBean(200, "El carrito se ha vaciado.");
                            }
                        }
                    } else {
                        oResponseBean = new ResponseBean(400, "El producto que quiere eliminar no esta en el carrito");
                    }
                } else {
                    oResponseBean = new ResponseBean(400, "El carrito esta vacio.");
                }
            } else {
                oResponseBean = new ResponseBean(400, "El producto que quieres eliminar no existe");
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

    public String list() throws Exception {
        try {
            HttpSession oSession = oRequest.getSession();
            @SuppressWarnings("unchecked")
            ArrayList<ItemBean> alCarrito = (ArrayList<ItemBean>) oSession.getAttribute("carrito");
            return "{\"status\":200,\"message\":" + oGson.toJson(alCarrito) + "}";
        } catch (Exception ex) {

            return oGson.toJson(new ResponseBean(500, ex.getMessage()));
        }
    }

    public String empty() throws MyException, SQLException {
        try {
            HttpSession oSession = oRequest.getSession();
            oSession.setAttribute("carrito", null);
            return oGson.toJson(new ResponseBean(200, "OK"));
        } catch (Exception ex) {
            return oGson.toJson(new ResponseBean(500, ex.getMessage()));
        }
    }

    private ItemBean find(ArrayList<ItemBean> alCarrito, int id) {
        for (int i = 0; i < alCarrito.size(); i++) {
            ItemBean oItemBean = alCarrito.get(i);
            if (id == (oItemBean.getProducto_obj().getId())) {
                return oItemBean;
            }
        }
        return null;
    }

    private int findRemove(ArrayList<ItemBean> alCarrito, int id) {
        for (int i = 0; i < alCarrito.size(); i++) {
            ItemBean oItemBean = alCarrito.get(i);
            if (oItemBean.getProducto_obj().getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
