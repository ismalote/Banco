
public class CajaAhorro extends Cuenta {

	private float interes;
	private float comision;
	
	public CajaAhorro(Cliente cliente, float interes, float comision) {
		super(cliente);
		this.interes = interes;
		this.comision = comision;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	@Override
	public void extraer(float monto) {
		if(saldoCuenta >= monto){
			saldoCuenta = saldoCuenta - monto;
			Movimiento mov = new Movimiento(monto, "Extraccion", saldoCuenta);
			movimientos.add(mov);
		}else{
			System.out.println("Saldo insuficiente.");
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
