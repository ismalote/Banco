
public class CuentaCorriente extends Cuenta {

	private float descubierto;
	private float comision;
	
	public CuentaCorriente(Cliente cliente, float descubierto, float comision) {
		super(cliente);
		this.descubierto = descubierto;
		this.comision = comision;
	}
	
	public float getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(float descubierto) {
		this.descubierto = descubierto;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	@Override
	public void extraer(float monto) {
		if(monto <= saldoCuenta){
			saldoCuenta = saldoCuenta - monto;
			Movimiento mov = new Movimiento(monto, "Extraccion", saldoCuenta);
			movimientos.add(mov);
		}else if(monto <= saldoCuenta+descubierto){
			float montoAux = monto;
			montoAux = montoAux - saldoCuenta;
			saldoCuenta = 0;
			descubierto = descubierto - montoAux;
			Movimiento mov = new Movimiento(monto, "Extraccion", saldoCuenta);
			movimientos.add(mov);
		}else{
			System.out.println("Saldo más descubierto es insuficiente para realizar la operación.");
		}
	}
	
	@Override
	public boolean podesExtraer(float monto) 
	{
		if(saldoCuenta+descubierto >= monto)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
