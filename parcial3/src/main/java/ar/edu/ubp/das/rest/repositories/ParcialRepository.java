package ar.edu.ubp.das.rest.repositories;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import ar.edu.ubp.das.rest.beans.SugerenciaBean;
import ar.edu.ubp.das.rest.beans.TemaServicioBean;
import ar.edu.ubp.das.rest.beans.TemaServicioCriteriaBean;


@Repository
public class ParcialRepository {
	 @Autowired
	    private JdbcTemplate jdbcTpl;
	    
	  
	 @SuppressWarnings("unchecked")
	    public List<TemaServicioBean> getTemasServicios(TemaServicioCriteriaBean criteria) {
	        SqlParameterSource in = new MapSqlParameterSource()
	           .addValue("cod_tipo_servicio", criteria.getCod_tipo_servicio());

	        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
	           .withProcedureName("get_temas_tipo_servicio")
	           .withSchemaName("dbo")
	           .returningResultSet("temas_tipo_servicio", BeanPropertyRowMapper.newInstance(TemaServicioBean.class));

	        Map<String, Object> out = jdbcCall.execute(in);
	        return (List<TemaServicioBean>)out.get("temas_tipo_servicio");
	    }
	 
	 
	 
	 
	 
	 @Transactional
	    public SugerenciaBean insSugerencia(SugerenciaBean data) {
	        SqlParameterSource in = new MapSqlParameterSource()
	 	       .addValue("cod_tipo_servicio", data.getCod_tipo_servicio())
		       .addValue("sugerencia", data.getSugerencia())
	           .addValue("nro_tema", data.getNro_tema());
	        
	        
	        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
	           .withProcedureName("ins_sugerencia")
	           .withSchemaName("dbo");
	        jdbcCall.execute(in);

	        
	        return data;
	    }
}
