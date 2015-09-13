import java.util.Vector;


public abstract class Cuenta {
	
	protected float saldoCuenta;
	protected int nroCuenta;
	protected Cliente cliente;
	protected Vector<Movimiento> movimientos;
	private static int proxNroCuenta;
	
	private static int getProxNroCuenta(){
		return ++proxNroCuenta;
	}
	
	public Cuenta(Cliente cliente){
		this.nroCuenta = getProxNroCuenta();
		this.saldoCuenta = 0;
		this.cliente = cliente;
		this.movimientos = new Vector<Movimiento>();		
	}

	public float getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(float saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public CuentaView getView()
	{
		CuentaView cv = new CuentaView(this.cliente, this.nroCuenta, this.saldoCuenta);
		return cv;
	}
	
	//M�todos de negocio
	
	public void depositar(float monto){
		setSaldoCuenta(saldoCuenta + monto);
		Movimiento mov = new Movimiento(monto, saldoCuenta, "Deposito");
		movimientos.add(mov);
	}
	
	public abstract void extraer(float monto);
	
	public abstract boolean podesExtraer(float monto);

	
}
