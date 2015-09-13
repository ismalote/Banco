import java.util.Date;

public class MovimientoView {
	
	private float monto;
	private String detalle;
	private float saldo;
	private Date fecha;
	private int nroMovimiento;
	
	public MovimientoView(Date fecha, int nroMovimiento, float monto, float saldo, String detalle){
		this.fecha = fecha;
		this.nroMovimiento = nroMovimiento;
		this.monto = monto;
		this.detalle = detalle;
		this.saldo = saldo;
	}
	
	public float getMonto() {
		return monto;
	}

	public String getDetalle() {
		return detalle;
	}

	public float getSaldo() {
		return saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getNroMovimiento() {
		return nroMovimiento;
	}
	
}
