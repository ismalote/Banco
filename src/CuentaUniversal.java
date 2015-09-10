
public class CuentaUniversal extends Cuenta {
	
	private float interes;

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public CuentaUniversal(Cliente cliente, float interes) {
		super(cliente);
		this.interes = interes;
	}

	@Override
	public void extraer(float monto) {
		if(saldoCuenta >= monto){
			saldoCuenta = saldoCuenta - monto;
			Movimiento mov = new Movimiento(monto, saldoCuenta, "Extraccion");
			movimientos.add(mov);
		}
	}
	
	@Override
	public boolean podesExtraer(float monto) 
	{
		if(saldoCuenta >= monto)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
