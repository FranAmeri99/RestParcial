package ar.edu.ubp.das.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.ubp.das.rest.beans.SugerenciaBean;
import ar.edu.ubp.das.rest.beans.TipoServiciosBean;
import ar.edu.ubp.das.rest.beans.TemaServicioBean;
import ar.edu.ubp.das.rest.beans.TemaServicioCriteriaBean;
import ar.edu.ubp.das.rest.repositories.ParcialRepository;
import ar.edu.ubp.das.rest.soap.SoapServiceClient;


@RestController
@RequestMapping(
  path="/servicios",
  produces={MediaType.APPLICATION_JSON_VALUE}
)
public class ParcialController {
    @Autowired
    ParcialRepository repository;
 	
	@Autowired
    SoapServiceClient clienteSOAP;

	@GetMapping(path="/tipo")
    public ResponseEntity<List<TipoServiciosBean>> getTipoServicio() {
      return new ResponseEntity<>(repository.getTipoServicio(), HttpStatus.OK);
    }
	/*
	@GetMapping("/tipos")
    public List<TipoServiciosBean> getTipos() {
    	List<TipoServiciosBean> temp = clienteSOAP.getTipoServicios();
    	return temp;
    }
	 
    
*/

@PostMapping(path = "/temas", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
public ResponseEntity<List<TemaServicioBean>> getTemas(@RequestParam("codTipoServicio") String codTipoServicio) {
    return new ResponseEntity<>(repository.getTemasServicios(codTipoServicio), HttpStatus.OK);
}
	

    

    @PutMapping(
    	path="/insertar_sugerencia",
    	consumes={MediaType.APPLICATION_JSON_VALUE}
    )
	public ResponseEntity<SugerenciaBean> insSugerencia(@RequestBody SugerenciaBean sugerencia) {
	  return new ResponseEntity<>(repository.insSugerencia(sugerencia), HttpStatus.CREATED);
	}
    
    
    
}
