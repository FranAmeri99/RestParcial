package ar.edu.ubp.das.rest.soap;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;
import ar.edu.ubp.das.rest.beans.TipoServiciosBean;
import java.util.List;

@Component
public class SoapServiceClient implements SoapServiceClientImplementacion {
    private static final String SERVICE_URL = "http://localhost:8080/parcial3-SOAP/services/TipoServiciosWSPort?wsdl";
	
	private final SoapServiceClientImplementacion soapServiceClientImplementacion;
	
	public SoapServiceClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SoapServiceClientImplementacion.class);
        factory.setAddress(SERVICE_URL);

        this.soapServiceClientImplementacion = (SoapServiceClientImplementacion) factory.create();
    }
	
	@Override
	public List<TipoServiciosBean> getTipoServicios() {
        return soapServiceClientImplementacion.getTipoServicios();
	}

}
