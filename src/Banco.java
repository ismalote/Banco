import java.util.Vector;

public class Banco 
{
	private Vector<Cliente>clientes;	
	private Vector<Cuenta>cuentas;
		
	public Banco()
	{
		clientes = new Vector<Cliente>();
		cuentas = new Vector<Cuenta>();
	}
	
	public void crearCliente(String dni, String nombre, String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if (c==null)
		{
			c = new Cliente(dni, nombre, domicilio, true);
			clientes.add(c);
			System.out.println("Cliente " + dni + " creado satisfactoriamente.");
		}
		else
		{
			System.out.println("Cliente " + dni + " ya existe.");
		}
	}
	
	public void modificarCliente(String dni, String nombre, String domicilio)
	{
		Cliente c = buscarCliente(dni);
		if(c!=null)
		{
			c.setDomicilio(domicilio);
			c.setNombre(nombre);
			System.out.println("Cliente " + dni + " modificado satisfactoriamente.");
		}
		else
		{
			System.out.println("Cliente " + dni + " no existe.");
		}		
	}
	
	public void bajaCliente(String dni)
	{
		boolean noDarDeBaja = false;
		Cliente c = buscarCliente(dni);
		if(c!=null)
		{
			Vector<Cuenta> ctas = buscarCuentasCliente(dni);
			if(ctas != null){
				for(Cuenta cuenta : ctas)
				{
					if(cuenta.getSaldoCuenta() > 0)
					{
						noDarDeBaja = true;
					}
				}
			}
			if(!noDarDeBaja)
			{
				c.setEstado(false);
			}else
			{
				System.out.println("Usted posee saldo en alguna de sus cuentas");
			}
		}
	}
	
	public void activarCliente(String dni)
	{
		Cliente c = buscarCliente(dni);
		if(c!=null)
		{
			c.setEstado(true);
		}
	}
	
	public ClienteView buscarDatosCliente(String dni)
	{
		ClienteView cv = null;
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			cv = cliente.getView();
		}		
		return cv;
	}
	
	private Cliente buscarCliente(String dni) 
	{
		for (int i=0;i<clientes.size();i++)
		{
			if (clientes.elementAt(i).sosCliente(dni)){
				return clientes.elementAt(i);
			}
		}
		return null;
	}

	private Vector<Cuenta> buscarCuentasCliente(String dni)
	{
		Vector<Cuenta> cuentas = new Vector<Cuenta>();
		Cliente cliente = buscarCliente(dni);
		if(cliente != null)
		{	
			cuentas = getCuentasFromCliente(cliente, cuentas);
		}
		return cuentas;
	}
	
	private Vector<Cuenta> getCuentasFromCliente(Cliente cliente, Vector<Cuenta> cuentas) {
		String dni = cliente.getDniCliente();
		for(Cuenta cta : cuentas){
			String dniCuenta = cta.getCliente().getDniCliente();
			if(dni == dniCuenta){
				cuentas.add(cta);
			}
		}
		
		return cuentas;
	}

	public void crearCajaAhorroPesos(String dni, float interes, float comision)
	{
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			CajaAhorroPesos cap = new CajaAhorroPesos(cliente, interes, comision);
			cuentas.add(cap);			
		}
	}
	
	public void crearCajaAhorroDolares(String dni, float interes, float comision)
	{
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			CajaAhorroDolares cad = new CajaAhorroDolares(cliente, interes, comision);
			cuentas.add(cad);
		}
	}
	
	public void crearCuentaCorrientePesos(String dni, float descubierto, float comision)
	{
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			CuentaCorrientePesos ccp = new CuentaCorrientePesos(cliente, descubierto, comision);
			cuentas.add(ccp);
		}
	}
	
	public void crearCuentaCorrienteDolares(String dni, float descubierto, float comision)
	{
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			CuentaCorrienteDolares ccd = new CuentaCorrienteDolares(cliente, descubierto, comision);
			cuentas.add(ccd);
		}
	}
	
	public void crearCuentaUniversal(String dni, float interes)
	{
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			CuentaUniversal cu = new CuentaUniversal(cliente, interes);
			cuentas.add(cu);
		}
	}
	
	public float extraer(int nroCuenta, float monto)
	{
		Cuenta cuenta = buscarCuenta(nroCuenta);
		if(cuenta != null)
		{
			cuenta.extraer(monto);
		}
		
		return cuenta.getSaldoCuenta();
	}
	
	public void depositar(int nroCuenta, float monto)
	{
		Cuenta cuenta = buscarCuenta(nroCuenta);
		if(cuenta != null)
		{
			cuenta.depositar(monto);
		}
	}
	
	public void transferir(int nroCuentaOrigen, int nroCuentaDestino, float monto)
	{
		Cuenta origen = buscarCuenta(nroCuentaOrigen);
		Cuenta destino = buscarCuenta(nroCuentaDestino);
		if(origen != null && destino != null && origen.podesExtraer(monto))
		{
			origen.saldoCuenta = origen.saldoCuenta - monto;
			destino.saldoCuenta = destino.saldoCuenta + monto;
			Movimiento mov = new Movimiento(monto, origen.saldoCuenta, "Transferencia");
			Movimiento mov2 = new Movimiento(monto, destino.saldoCuenta, "Transferencia");
			origen.movimientos.add(mov);
			destino.movimientos.add(mov2);						
		}
	}
	
	private Cuenta buscarCuenta(int nroCuenta)
	{
		for (int i=0;i<cuentas.size();i++)
		{
			if (cuentas.elementAt(i).getNroCuenta() == nroCuenta && cuentas.elementAt(i).getCliente().getEstado())
			{
				return cuentas.elementAt(i);
			}
		}
		return null;
	}
	
	public CuentaView buscarDatosCuenta(int nroCuenta)
	{
		CuentaView cv = null;
		Cuenta cuenta = buscarCuenta(nroCuenta);
		if(cuenta != null)
		{
			cv = cuenta.getView();
		}
		return cv;
	}
	
	public MovimientoView buscarDatosMovimiento(int nroMovimiento)
	{
		MovimientoView mv = null;
		Movimiento movimiento = buscarMovimiento(nroMovimiento);
		if(movimiento != null)
		{
			mv = movimiento.getView();
		}
		return mv;		
	}
	
	private Movimiento buscarMovimiento(int nroMovimiento)
	{
		for (int i=0;i<cuentas.size();i++)
		{
			for(int j=0;j<cuentas.elementAt(i).movimientos.size();j++)
			{
				if (cuentas.elementAt(i).movimientos.elementAt(j).getNroMovimiento() == nroMovimiento)
				{
					return cuentas.elementAt(i).movimientos.elementAt(j);
				}			
			}
		}
		return null;
	}

	public Vector<Cuenta> buscarDatosCuentasCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
