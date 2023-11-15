package ar.edu.ubp.das.rest.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.edu.ubp.das.rest.beans.TipoServiciosBean;

@WebService(targetNamespace = "http://ws.das.ubp.edu.ar/")
public interface SoapServiceClientImplementacion {
    @WebMethod(operationName = "getTipoServicios", action = "urn:getTipoServicios")
    List<TipoServiciosBean> getTipoServicios();
}