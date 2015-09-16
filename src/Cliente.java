
public class Cliente {
	
	private String dniCliente;
	private String nombre;
	private String domicilio;
	private boolean estado;
	
	public Cliente(String dniCliente, String nombre, String domicilio, boolean estado) {
		super();
		this.dniCliente = dniCliente;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.estado = estado;
	}

	public Cliente(String dniCliente, String nombre, boolean estado) {
		super();
		this.dniCliente = dniCliente;
		this.nombre = nombre;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDniCliente() {
		return dniCliente;
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}		

	public boolean sosCliente(String dni) {
		return (this.dniCliente.equalsIgnoreCase(dni));
	}

	public ClienteView getView()
	{
		ClienteView cv = new ClienteView(this.dniCliente, this.nombre, this.domicilio);
		return cv;
	}
	
}
