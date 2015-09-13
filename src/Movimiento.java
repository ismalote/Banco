import java.util.Calendar;
import java.util.Date;


public class Movimiento {

	private float monto;
	private String detalle;
	private float saldo;
	private Date fecha;
	private int nroMovimiento;
	private static int proxNroMovimiento;	
	
	public Movimiento(float monto, String detalle, float saldo){
		this.monto = monto;
		this.detalle = detalle;
		this.saldo = saldo;
		this.fecha = Calendar.getInstance().getTime();
		this.nroMovimiento = getProxNroMovimiento();
	}
	
	private static int getProxNroMovimiento(){
		return ++proxNroMovimiento;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNroMovimiento() {
		return nroMovimiento;
	}

	public void setNroMovimiento(int nroMovimiento) {
		this.nroMovimiento = nroMovimiento;
	}	
	
	public MovimientoView getView()
	{
		MovimientoView mv = new MovimientoView(this.fecha, this.nroMovimiento, this.monto, this.saldo, this.detalle);
		return mv;
	}
	
}
