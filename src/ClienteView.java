public class ClienteView {

	public String getDniCliente() {
		return dniCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	private String dniCliente;
	private String nombre;
	private String domicilio;
	
	public ClienteView(String dniCliente, String nombre, String domicilio) {
		this.dniCliente = dniCliente;
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

}