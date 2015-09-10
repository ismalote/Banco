import java.util.Calendar;
import java.util.Date;


public class Movimiento {

	private float monto;
	private String detalle;
	private float saldo;
	private Date fecha;
	private int nroMovimiento;
	private static int proxNroMovimiento;	
	
	public Movimiento(float monto, float saldo, String detalle){
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
	
	
}
