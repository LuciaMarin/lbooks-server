package net.ausiasmarch.service.specificservice_0;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.bean.ResponseBean;
import net.ausiasmarch.bean.UsuarioBean;
import net.ausiasmarch.connection.ConnectionInterface;
import net.ausiasmarch.dao.specificdao_0.UsuarioDao_0;
import net.ausiasmarch.exceptions.MyException;
import net.ausiasmarch.factory.ConnectionFactory;
import net.ausiasmarch.factory.GsonFactory;
import net.ausiasmarch.helper.Log4jHelper;
import net.ausiasmarch.service.genericservice.GenericService;
import net.ausiasmarch.service.serviceinterface.ServiceInterface;
import net.ausiasmarch.setting.ConnectionSettings;

public class UsuarioService_0 extends GenericService implements ServiceInterface {

    ResponseBean oResponseBean = null;
    UsuarioBean oUsuarioBeanSession;
    ConnectionInterface oConnectionImplementation = null;
    Connection oConnection = null;
    Gson oGson = GsonFactory.getGson();
    HttpSession oSession = oRequest.getSession();

    public UsuarioService_0(HttpServletRequest oRequest) {
        super(oRequest);
        ob = oRequest.getParameter("ob");
    }

    public String login() throws Exception {
        UsuarioBean oUsuarioBean;
        String token = oRequest.getParameter("token");
        try {
            if (token == null || token.equalsIgnoreCase("")) {
                oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
                oConnection = oConnectionImplementation.newConnection();
                UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);
                String login = oRequest.getParameter("username");
                String password = oRequest.getParameter("password");
                oUsuarioBean = oUsuarioDao.get(login, password);

                if (oUsuarioBean != null) {
                    if (oRequest.getParameter("username").equals(oUsuarioBean.getLogin()) && oRequest.getParameter("password").equalsIgnoreCase(oUsuarioBean.getPassword())) {
                        if (oUsuarioBean.getValidate() != false) {
                            oSession.setAttribute("usuario", oUsuarioBean);
                            oResponseBean = new ResponseBean(200, "Welcome");
                        } else {
                            oResponseBean = new ResponseBean(500, "Necesitas validar la cuenta.");
                        }
                    } else {
                        oResponseBean = new ResponseBean(500, "Wrong password");
                    }
                } else {
                    oResponseBean = new ResponseBean(500, "Wrong password");
                }
            } else {
                GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
                        .setAudience(Collections.singletonList("165552183735-umlcclrgi0vpu7u5pp6mg1burt8fohiv.apps.googleusercontent.com")).build();
                GoogleIdToken idToken = verifier.verify(token);

                if (idToken != null) {
                    String email = idToken.getPayload().getEmail();
                    int index = email.indexOf('@');
                    String username = email.substring(0, index);
                    oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
                    oConnection = oConnectionImplementation.newConnection();
                    UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);
                    oUsuarioBean = oUsuarioDao.get(username);
                    if (oUsuarioBean != null) {
                        oSession.setAttribute("usuario", oUsuarioBean);
                        oResponseBean = new ResponseBean(200, "Bienvenid@ a L-Books");
                    } else {
                        if (oUsuarioDao.insert(email, username) == 0) {
                            oResponseBean = new ResponseBean(500, "Esta cuenta no ha sido creada");
                        } else {
                            oUsuarioBean = oUsuarioDao.get(username);
                            oSession.setAttribute("usuario", oUsuarioBean);
                            oResponseBean = new ResponseBean(200, "Bienvenid@ a L-Books");
                        }
                    }
                } else {
                    oResponseBean = new ResponseBean(500, "Authentication failed");
                }

            }
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

    public String logout() {
        oRequest.getSession().invalidate();
        oResponseBean = new ResponseBean(200, "No active session");
        return oGson.toJson(oResponseBean);
    }

    public String check() throws Exception {
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioBean oUsuarioBean;
            oUsuarioBean = (UsuarioBean) oSession.getAttribute("usuario");
            UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);

            if (oUsuarioBean == null) {
                oResponseBean = new ResponseBean(500, "No autorizado");
            } else {
                oUsuarioBean = oUsuarioDao.get(oUsuarioBean.getLogin());
                return "{\"status\":200,\"message\":" + oGson.toJson(oUsuarioBean) + "}";
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

    public String signup() throws Exception {
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);
            UsuarioBean oUsuarioBean = new UsuarioBean();
            oUsuarioBean.setDni(oRequest.getParameter("dni"));
            oUsuarioBean.setNombre(oRequest.getParameter("nombre"));
            oUsuarioBean.setApellido1(oRequest.getParameter("apellido1"));
            oUsuarioBean.setApellido2(oRequest.getParameter("apellido2"));
            oUsuarioBean.setLogin(oRequest.getParameter("username"));
            oUsuarioBean.setPassword(oRequest.getParameter("password"));
            oUsuarioBean.setEmail(oRequest.getParameter("email"));
            oUsuarioBean.setToken(generaToken());
            oUsuarioBean.setValidate(Boolean.FALSE);
            String token = oUsuarioBean.getToken();
            String email = oRequest.getParameter("email");
            if (oUsuarioBean != null) {
                String username = oRequest.getParameter("username");
                String emailText = "Hola, " + username + "\n Hemos recibido su solicitud para acceder a L-Books. "
                        + "Si has sido tú, accede al siguiente enlace para "
                        + "la confirmación: http://localhost:8080/lbooks-client/login-validate/" + token + "\n Si no has solicitado el registro, puedes ignorar este correo.";
                EmailRegister.sendEmail("lbooksclient@gmail.com", email, "lbooks1234", "Registro en L-Books, se necesita confirmación", emailText, "html");
                oUsuarioDao.register(oUsuarioBean);
                oResponseBean = new ResponseBean(200, "Usuario registrado con exito, falta validar");
            } else {
                oResponseBean = new ResponseBean(500, "Este usuario ya está registrado con ese email.");
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

    private String generaToken() {
        int numAleatorio = (int) Math.floor(Math.random() * (100000 - 999999) + 999999);
        String tokenAleatorio = String.valueOf(numAleatorio) + "TROLL";
        return tokenAleatorio;
    }

    public String loginValidate() throws Exception {
        UsuarioBean oUsuarioBean;
        String token = oRequest.getParameter("token");
        try {

            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);
            if (oUsuarioDao.validateToken(token) == true) {
                String login = oRequest.getParameter("username");
                String password = oRequest.getParameter("password");
                oUsuarioBean = oUsuarioDao.get(login, password);

                if (oUsuarioBean != null) {
                    if (oRequest.getParameter("username").equals(oUsuarioBean.getLogin()) && oRequest.getParameter("password").equalsIgnoreCase(oUsuarioBean.getPassword())) {
                        if (oUsuarioDao.validateUser(oUsuarioBean.getLogin())) {
                            oSession.setAttribute("usuario", oUsuarioBean);
                            oUsuarioBean.setValidate(true);
                            oResponseBean = new ResponseBean(200, "El usuario ha sido validado");
                        } else {
                            oResponseBean = new ResponseBean(500, "No se ha podido validar la cuenta.");
                        }
                    } else {
                        oResponseBean = new ResponseBean(500, "Wrong password");
                    }
                } else {
                    oResponseBean = new ResponseBean(500, "Wrong password");
                }
            } else {
                oResponseBean = new ResponseBean(500, "No se ha podido validar la cuenta.");
            }
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

    public String recover() throws Exception {
        String email = oRequest.getParameter("email");
        UsuarioBean oUsuarioBean = new UsuarioBean();
        try {
            oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
            oConnection = oConnectionImplementation.newConnection();
            //Comprobación de email en base de datos
            UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);
            oUsuarioBean = oUsuarioDao.validateEmail(email);
            if (oUsuarioBean != null) {
                String token = generaToken();
                String login = oUsuarioBean.getLogin();
                oUsuarioBean.setToken(token);
                //Cambiar token por el nuevo
                if (oUsuarioDao.changeToken(login, token) != 0) {
                    //Envio de email
                    String emailText = "Hola, " + login + "\n Hemos recibido su solicitud para cambiar "
                            + "la contraseña de tu cuenta L-Books. "
                            + "Si has sido tú, accede al siguiente enlace para "
                            + "la confirmación: http://localhost:8080/lbooks-client/recover/password/" + token + "\n Si no has solicitado el registro, "
                            + "puedes ignorar este correo.";
                    EmailRegister.sendEmail("lbooksclient@gmail.com", email, "lbooks1234", "Recuperacion de contraseña en L-Books", emailText, "html");

                    oResponseBean = new ResponseBean(200, "Te hemos enviado un correo para recuperar la contraseña, revisalo.");
                } else {
                    oResponseBean = new ResponseBean(500, "Error al actualizar el token.");
                }
            } else {
                oResponseBean = new ResponseBean(500, "El email no existe en nuestra base de datos.");
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

    public String changePassword() throws Exception {
        String password = oRequest.getParameter("password");
        String token = oRequest.getParameter("token");
        if (token != null) {
            try {
                oConnectionImplementation = ConnectionFactory.getConnection(ConnectionSettings.connectionPool);
                oConnection = oConnectionImplementation.newConnection();
                //Comprobación de email en base de datos
                UsuarioDao_0 oUsuarioDao = new UsuarioDao_0(oConnection, "usuario", oUsuarioBeanSession);
                if (oUsuarioDao.validateToken(token) == true) {
                    if (oUsuarioDao.changePassword(password, token) != 0) {
                        oResponseBean = new ResponseBean(200, "Se ha actualizado la contraseña correctamente.");
                    } else {
                        oResponseBean = new ResponseBean(500, "No se ha podido actualizar la contraseña.");
                    }
                } else {
                    oResponseBean = new ResponseBean(500, "Permiso denegado.");
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
        } else {
            oResponseBean = new ResponseBean(500, "Permiso denegado.");
        }

        return oGson.toJson(oResponseBean);
    }
}
