package net.ausiasmarch.service.specificservice_2;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.bean.CompraBean;
import net.ausiasmarch.bean.FacturaBean;
import net.ausiasmarch.bean.ItemBean;
import net.ausiasmarch.bean.ProductoBean;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_2.CompraDao_2;
import net.ausiasmarch.dao.specificdao_2.FacturaDao_2;
import net.ausiasmarch.dao.specificdao_2.ProductoDao_2;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.setting.ConnectionSettings;

public class CarritoService_2 {

    HttpServletRequest oRequest = null;
    UsuarioBean oUsuarioBeanSession;
    String ob = null;
    Gson oGson = GsonFactory.getGson();
    Connection oConnection = null;

    public CarritoService_2(HttpServletRequest oRequest) {
        super();
        this.oRequest = oRequest;
        ob = oRequest.getParameter("ob");
    }

    private Boolean checkPermission() throws Exception {
        oUsuarioBeanSession = (UsuarioBean) oRequest.getSession().getAttribute("usuario");
        return oUsuarioBeanSession != null;
    }

    public String add() throws Exception {
        HttpSession oSession = oRequest.getSession();
        int id = Integer.parseInt(oRequest.getParameter("id"));
        int cantidad = Integer.parseInt(oRequest.getParameter("cantidad"));
        ProductoDao_2 oProductoDao;
        ConnectionInterface oConnectionImplementation = null;
        ResponseBean oResponseBean = null;
        @SuppressWarnings("unchecked")
        ItemBean oItemBean;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            ProductoBean oProductoBean = new ProductoBean(id);
            oProductoDao = new ProductoDao_2(oConnection, ob, oUsuarioBeanSession);
            oProductoBean = (ProductoBean) oProductoDao.get(id);
            if (oProductoBean != null) {
                if (cantidad != 0) {
                    oItemBean = new ItemBean(cantidad, oProductoBean);
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
        ProductoDao_2 oProductoDao;
        ProductoBean oProductoBean;
        HttpSession oSession = oRequest.getSession();
        ConnectionInterface oConnectionImplementation = null;
        ResponseBean oResponseBean = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            oProductoDao = new ProductoDao_2(oConnection, ob, oUsuarioBeanSession);
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

    public String list() throws MyException, SQLException {
        HttpSession oSession = oRequest.getSession();
        try {
            @SuppressWarnings("unchecked")
            ArrayList<ItemBean> alCarrito = (ArrayList<ItemBean>) oSession.getAttribute("carrito");
            return "{\"status\":200,\"message\":" + oGson.toJson(alCarrito) + "}";
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new MyException(1002, msg, ex);
        }
    }

    public String empty() throws MyException, SQLException {
        HttpSession oSession = oRequest.getSession();
        try {
            oSession.setAttribute("carrito", null);
            return oGson.toJson(new ResponseBean(200, "OK"));
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new MyException(1003, msg, ex);
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

    public String buy() throws Exception {
        HttpSession oSession = oRequest.getSession();
        ArrayList<ItemBean> alCarrito = (ArrayList) oSession.getAttribute("carrito");
        UsuarioBean oUsuarioBean = (UsuarioBean) oSession.getAttribute("usuario");
        ConnectionInterface oConnectionImplementation = null;
        ResponseBean oResponseBean = null;
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
                if (this.checkPermission()) {
                if (alCarrito != null && alCarrito.size() > 0) {
                    oConnection.setAutoCommit(false);
                    //CREA FACTURA
                    FacturaBean oFacturaBean = new FacturaBean();
                    ProductoDao_2 oProductoDao = new ProductoDao_2(oConnection, "producto", oUsuarioBeanSession);
                    oFacturaBean.setUsuario_id(oUsuarioBean.getId());
                    oFacturaBean.setIva(21);
                    oFacturaBean.setFecha(Calendar.getInstance().getTime());
                    FacturaDao_2 oFacturaDao = new FacturaDao_2(oConnection, "factura", oUsuarioBeanSession);
                    oFacturaBean.setId(oFacturaDao.insert(oFacturaBean));
                    //----------------------------------------------------                         
                    Iterator<ItemBean> iterator = alCarrito.iterator();
                    while (iterator.hasNext()) {
                        ItemBean oItemBean = iterator.next();
                        ProductoBean oProductoBean = oItemBean.getProducto_obj();
                        ProductoBean oProductoBeanDeDB = (ProductoBean) oProductoDao.get(oProductoBean.getId());
                        //COMPRUEBA EXISTENCIAS Y CREA COMPRA
                        if (oProductoBeanDeDB.getExistencias() >= oItemBean.getCantidad()) {
                            CompraBean oCompraBean = new CompraBean();
                            oCompraBean.setCantidad(oItemBean.getCantidad());
                            oCompraBean.setFactura_id(oFacturaBean.getId());
                            oCompraBean.setProducto_id(oProductoBean.getId());
                            CompraDao_2 oCompraDao = new CompraDao_2(oConnection, "compra", oUsuarioBeanSession);
                            oCompraDao.insert(oCompraBean);
                            oCompraBean.setId(oCompraBean.getId());
                            oProductoBean.setExistencias(oProductoBean.getExistencias() - oItemBean.getCantidad());
                            oProductoDao.update(oProductoBean);
                            oProductoDao.insert(oProductoBean);
                            oResponseBean = new ResponseBean(200, "Se ha realizado la compra");
                        } else {
                            oResponseBean = new ResponseBean(400, "No hay suficientes existencias");
                            return oGson.toJson(oResponseBean);
                        }
                    }
                    alCarrito.clear();
                    oConnection.commit();
                } else {
                    oResponseBean = new ResponseBean(400, "El carrito está vacio");
                }
            } else {
                oResponseBean = new ResponseBean(400, "Regístrate para realizar la compra");
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
}
