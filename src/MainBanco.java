


import java.util.*;
import java.io.*;

/**
 * Inserte aqu� la descripci�n del tipo.
 * Fecha de creaci�n: (31/08/2005 15:21:06)
 * @author: Maria Paula Sarasa
 */
public class MainBanco 
{
	private Banco banco;
/**
 * Comentario de constructor MainBanco.
 */
public MainBanco() 
{
	banco = new Banco();
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void abrirCuenta()
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("ALTA DE CUENTA");
		System.out.println("---------------");
		System.out.print("Ingrese DNI:");
		String dni = reader.readLine();
		System.out.print("Seleccione si la nueva cuenta sera Caja Ahorro, Cuenta Corriente o Cuenta Universal (CA - CC- CU):");
		String tipoCuenta = reader.readLine();
		if (tipoCuenta.equalsIgnoreCase("CA"))
		{
			System.out.print("Ingrese Comision: ");
			String comision = reader.readLine();
			System.out.print("Ingrese Interes: ");
			String interes = reader.readLine();
			System.out.print("Ingrese Moneda: ($ - d)");
			String moneda = reader.readLine();
			if (moneda.equals("$"))
			{
				int nro = banco.crearCajaAhorroPesos(dni, Float.parseFloat(interes), Float.parseFloat(comision));
				if(nro != -1){
					System.out.println("La cuenta numero: " + nro +  " fue creada satisfactoriamente.");
				}else{
					System.out.println("Cliente inexistente");
				}
			}
			else
			{
				int nro = banco.crearCajaAhorroDolares(dni, Float.parseFloat(interes), Float.parseFloat(comision));
				if(nro != -1){
					System.out.println("La cuenta numero: " + nro +  " fue creada satisfactoriamente.");
				}else{
					System.out.println("Cliente inexistente");
				}
			}			
		}
		else if (tipoCuenta.equalsIgnoreCase("CC"))
		{
			System.out.print("Ingrese Comisión:");
			String comision = reader.readLine();
			System.out.print("Ingrese Descubierto:");
			String descubierto = reader.readLine();
			System.out.print("Ingrese Moneda:($ - d)");
			String moneda = reader.readLine();
			if (moneda.equals("$"))
			{
				int nro = banco.crearCuentaCorrientePesos(dni, Float.parseFloat(descubierto), Float.parseFloat(comision));
				if(nro != -1){
					System.out.println("La cuenta numero: " + nro +  " fue creada satisfactoriamente.");
				}else{
					System.out.println("Cliente inexistente");
				}
			}
			else
			{
				int nro = banco.crearCuentaCorrienteDolares(dni, Float.parseFloat(descubierto), Float.parseFloat(comision));
				if(nro != -1){
					System.out.println("La cuenta numero: " + nro +  " fue creada satisfactoriamente.");
				}else{
					System.out.println("Cliente inexistente.");
				}
			}
		}
		else
		{
			System.out.print("Ingrese Interés:");
			String interes = reader.readLine();			
			int nro = banco.crearCuentaUniversal(dni, Float.parseFloat(interes));
			if(nro != -1){
				System.out.println("La cuenta numero: " + nro +  " fue creada satisfactoriamente.");
			}else{
				System.out.println("Cliente inexistente.");
			}
		}
			
		mostrarMenu();
	}
	catch(Exception e){}

}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void debitarComisiones() 
{
	
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void depositar() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("DEPOSITAR");
		System.out.println("---------------");
		System.out.print("Ingrese nro Cuenta: ");
		String nroCuenta = reader.readLine();
		System.out.print("Ingrese Monto: ");
		String monto = reader.readLine();
		banco.depositar(Integer.parseInt(nroCuenta), Float.parseFloat(monto));
		CuentaView nuevoSaldo = banco.buscarDatosCuenta(Integer.parseInt(nroCuenta));			
		System.out.println("El nuevo saldo es: " + nuevoSaldo.getSaldoCuenta());
		mostrarMenu();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void extraer() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("EXTRAER");
		System.out.println("---------------");
		System.out.print("Ingrese nro Cuenta: ");
		String nroCuenta = reader.readLine();
		System.out.print("Ingrese Monto: ");
		String monto = reader.readLine();
		banco.extraer(Integer.parseInt(nroCuenta), Float.parseFloat(monto));
		CuentaView nuevoSaldo = banco.buscarDatosCuenta(Integer.parseInt(nroCuenta));
		System.out.println("El saldo actual es: " + nuevoSaldo.getSaldoCuenta());
		mostrarMenu();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void crearCliente() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("ALTA DE CLIENTE");
		System.out.println("---------------");
		System.out.print("Ingrese DNI: ");
		String dni = reader.readLine();
		System.out.print("Ingrese Nombre: ");
		String nombre = reader.readLine();
		System.out.print("Ingrese Domicilio: ");
		String domicilio = reader.readLine();
		
		banco.crearCliente(dni, nombre, domicilio);
			
		mostrarMenu();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:35:15)
 * @return demo.paula.Banco
 */
public Banco getBanco() {
	return banco;
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void listarCuentas()
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("LISTAR CUENTAS");
		System.out.println("---------------");
		System.out.print("Ingrese DNI:");
		String dni = reader.readLine();
		
		Vector<CuentaView> cuentas = banco.buscarCuentasCliente(dni);
		
		if(cuentas.size() > 0){
			for (int i=0;i<cuentas.size();i++)
			{
				CuentaView c = cuentas.elementAt(i);
				System.out.println("Nro. Cuenta: "+ c.getNroCuenta());
				System.out.println("Saldo: "+ c.getSaldoCuenta());
				System.out.println("----------------------------------------------------");			
			}
		}else{
			System.out.println("El cliente no posee cuentas.");
		}

		mostrarMenu();
	}
	catch(Exception e)
	{
	}
}
/**
 * Inicia la aplicaci�n.
 * @param args una matriz de argumentos de l�nea de mandatos
 */
public static void main(java.lang.String[] args) 
{
	// Inserte aqu� c�digo para iniciar la aplicaci�n.
	MainBanco main = new MainBanco();
	main.mostrarMenu();
	
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:22:26)
 */
public void mostrarMenu() 
{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 	
	//Imprimo menu de opciones
	System.out.println("MENU DE OPCIONES");
	System.out.println("-------------------------------------------------------");
	System.out.println("1.- Crear Cliente");
	System.out.println("2.- Abrir Cuenta");
	System.out.println("3.- Listar cuentas");
	System.out.println("4.- Depositar");
	System.out.println("5.- Extraer");
	System.out.println("6.- Consultar saldo");
	System.out.println("7.- Consultar movimientos");
	System.out.println("8.- Debitar mantenimiento");
	System.out.println("9.- Transferir entre cuentas");
	System.out.println("A.- Salir");
	System.out.println("-------------------------------------------------------");
	System.out.print("Opcion:");
	try
	{
		char s = (char)reader.read();
		
	  	switch (s)
	  	{
	  		case '1' : {
	  			this.crearCliente();
	  			break;
	  		}
		  	case '2' : {
		  		this.abrirCuenta();
		  		break;
		  	}
		  	case '3' : {
		  		this.listarCuentas();
		  		break;
		  	}
		  	case '4' :  {
		  		this.depositar();
		  		break;
		  	}
		  	case '5' :  {
		  		this.extraer();
		  		break;
		  	}
		  	case '6' :{
		  		this.consultarSaldo();
		  		break;
		  	}
		  	
		  	case '7' : {
		  		this.consultarMovimientos();
		  		break;
		  	}
		  	case '8' : {
		  		this.debitarMantenimiento();
		  		break;
		  	}
		  	case '9' : {
		  		this.transferirEntreCuentas();
		  		break;
		  	}
		  	case 'A' : {
		  		this.salir();
		  	}
	  	}
	}
	catch (Exception e)
	{
	}

}
private void transferirEntreCuentas() {
	// TODO Auto-generated method stub
	
}
private void debitarMantenimiento() {
	// TODO Auto-generated method stub
	
}
private void consultarMovimientos() {
	// TODO Auto-generated method stub
	
}
private void consultarSaldo() {
	// TODO Auto-generated method stub
	
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:27:02)
 */
public void salir() 
{
	System.exit(0);
}
/**
 * Inserte aqu� la descripci�n del m�todo.
 * Fecha de creaci�n: (31/08/2005 15:35:15)
 * @param newBanco demo.paula.Banco
 */
public void setBanco(Banco newBanco) {
	banco = newBanco;
}
}
