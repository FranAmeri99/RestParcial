package ar.edu.ubp.das.rest.beans;

public class SugerenciaBean {
	private String sugerencia;
	private String cod_tipo_servicio;
	private int nro_tema;
	
	
	
	public String getSugerencia() {
		return sugerencia;
	}
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}
	public String getCod_tipo_servicio() {
		return cod_tipo_servicio;
	}
	public void setCod_tipo_servicio(String cod_tipo_servicio) {
		this.cod_tipo_servicio = cod_tipo_servicio;
	}
	public int getNro_tema() {
		return nro_tema;
	}
	public void setNro_tema(int nro_tema) {
		this.nro_tema = nro_tema;
	}
}
