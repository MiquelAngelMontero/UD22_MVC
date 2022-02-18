package Modelo;

public class asignado_a {

	private String cientifico;
	private String proyecto;
	
	public asignado_a(String cientifico, String proyecto) {
		super();
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	public String getCientifico() {
		return cientifico;
	}

	public void setCientifico(String cientifico) {
		this.cientifico = cientifico;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
}
