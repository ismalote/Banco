import java.util.Vector;

public class CuentaView {
	private int nroCuenta;
	private float saldoCuenta;	
	private Cliente cliente;
	private Vector<Movimiento> movimientos;
	
	public CuentaView(Cliente cliente, int nroCuenta, float saldoCuenta) {
		this.nroCuenta = nroCuenta;
		this.saldoCuenta = saldoCuenta;		
		this.cliente = cliente;
		this.movimientos = new Vector<Movimiento>();
	}
	
	public int getNroCuenta() {
		return nroCuenta;
	}

	public float getSaldoCuenta() {
		return saldoCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Vector<Movimiento> getMovimientos() {
		return movimientos;
	}

}