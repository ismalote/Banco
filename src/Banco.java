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
			Vector<CuentaView> ctas = buscarCuentasCliente(dni);
			if(ctas != null){
				for(CuentaView cuenta : ctas)
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

	public Vector<CuentaView> buscarCuentasCliente(String dni)
	{
		Vector<CuentaView> ctaView = new Vector<CuentaView>();
		Cliente cliente = buscarCliente(dni);
		if(cliente != null)
		{	
			ctaView = getCuentasViewFromCliente(cliente);
		}
		
		return ctaView;
	}
	
	private Vector<CuentaView> getCuentasViewFromCliente(Cliente cliente) {
		Vector<CuentaView> ctasView = new Vector<CuentaView>();
		String dni = cliente.getDniCliente();
		for(Cuenta cta : this.cuentas){
			String dniCuenta = cta.getCliente().getDniCliente();
			if(dni.equalsIgnoreCase(dniCuenta)){
				ctasView.add(cta.getView());
			}
		}
		
		return ctasView;
	}

	public int crearCajaAhorroPesos(String dni, float interes, float comision)
	{
		CajaAhorroPesos cap = null;
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			cap = new CajaAhorroPesos(cliente, interes, comision);
			cuentas.add(cap);			
		}
		
		if(cap != null){
			return cap.getNroCuenta();
		}else{
			return -1;
		}
	}
	
	public int crearCajaAhorroDolares(String dni, float interes, float comision)
	{
		
		CajaAhorroDolares cad = null;
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			cad = new CajaAhorroDolares(cliente, interes, comision);
			cuentas.add(cad);
		}
		
		if(cad != null){
			return cad.getNroCuenta();
		}else{
			return -1;
		}
	}
	
	public int crearCuentaCorrientePesos(String dni, float descubierto, float comision)
	{
		CuentaCorrientePesos ccp = null;
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			ccp = new CuentaCorrientePesos(cliente, descubierto, comision);
			cuentas.add(ccp);
		}
		
		if(ccp != null){
			return ccp.getNroCuenta();
		}else{
			return -1;
		}
	}
	
	public int crearCuentaCorrienteDolares(String dni, float descubierto, float comision)
	{
		CuentaCorrienteDolares ccd = null;
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			ccd = new CuentaCorrienteDolares(cliente, descubierto, comision);
			cuentas.add(ccd);
		}
		
		if(ccd != null){
			return ccd.getNroCuenta();
		}else{
			return -1;
		}
	}
	
	public int crearCuentaUniversal(String dni, float interes)
	{
		CuentaUniversal cu = null;
		Cliente cliente = buscarCliente(dni);
		if(cliente != null){
			cu = new CuentaUniversal(cliente, interes);
			cuentas.add(cu);
		}
		
		if(cu != null){
			return cu.getNroCuenta();
		}else{
			return -1;
		}
	}
	
	public float extraer(int nroCuenta, float monto)
	{
		Cuenta cuenta = buscarCuenta(nroCuenta);
		float s = -1;
		if(cuenta != null)
		{
			cuenta.extraer(monto);
			s = cuenta.getSaldoCuenta();
		}		
		return s;
	}
	
	public float depositar(int nroCuenta, float monto)
	{
		Cuenta cuenta = buscarCuenta(nroCuenta);
		float s = -1;
		if(cuenta != null)
		{
			cuenta.depositar(monto);
			s = cuenta.getSaldoCuenta();
		}
		return s;
	}
	
	public float transferir(int nroCuentaOrigen, int nroCuentaDestino, float monto)
	{
		Cuenta origen = buscarCuenta(nroCuentaOrigen);
		Cuenta destino = buscarCuenta(nroCuentaDestino);
		if(origen != null && destino != null && origen.podesExtraer(monto))
		{
			origen.saldoCuenta = origen.saldoCuenta - monto;
			destino.saldoCuenta = destino.saldoCuenta + monto;
			Movimiento mov = new Movimiento(monto, "Transferencia", origen.saldoCuenta);
			Movimiento mov2 = new Movimiento(monto, "Transferencia", destino.saldoCuenta);
			origen.movimientos.add(mov);
			destino.movimientos.add(mov2);						
		}
		return origen.getSaldoCuenta();
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
	
	public Vector<MovimientoView> listarMovimientosPorCuenta(int nroCuenta){
		Vector<MovimientoView> movView = new Vector<MovimientoView>();
		Cuenta cta = buscarCuenta(nroCuenta);
		if(cta != null){
			Vector<Movimiento> mov = cta.getMovimientos();			
			for(int i = 0; i < mov.size();i++){
				movView.add(mov.elementAt(i).getView());
			}
		}
		return movView;
	}
	
}
