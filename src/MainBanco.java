


import java.util.*;
import java.io.*;

/**
 * Inserte aquí la descripción del tipo.
 * Fecha de creación: (31/08/2005 15:21:06)
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
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:27:02)
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
		System.out.print("Seleccione si la nueva cuenta sera Caja Ahorro o Cuenta Corriente (CA - CC- CU):");
		String tipoCuenta = reader.readLine();
		if (tipoCuenta.equalsIgnoreCase("CA"))
		{
			System.out.print("Ingrese Moneda:($ - d)");
			String moneda = reader.readLine();
			if (moneda.equals("$"))
			{
				int nro = banco.crearCajaAhorroPesos(Long.parseLong(dni));
				System.out.println("El numero de su cuenta es: " + nro);
			}
			else
			{
				int nro = banco.crearCajaAhorroDolares(Long.parseLong(dni));
				System.out.println("El numero de su cuenta es: " + nro);
			}
		}
		if (tipoCuenta.equalsIgnoreCase("CC"))
		{
			System.out.print("Ingrese Moneda:($ - d)");
			String moneda = reader.readLine();
			if (moneda.equals("$"))
			{
				int nro = banco.crearCuentaCorrientePesos(Long.parseLong(dni));
				System.out.println("El numero de su cuenta es: " + nro);
			}
			else
			{
				int nro = banco.crearCuentaCorrienteDolares(Long.parseLong(dni));
				System.out.println("El numero de su cuenta es: " + nro);
			}
		}
		else
		{
			int nro = banco.crearCuentaUniversal(Long.parseLong(dni));
			System.out.println("El numero de su cuenta es: " + nro);
		}
			
		mostrarMenu();
	}
	catch(Exception e){}

}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:27:02)
 */
public void debitarComisiones() 
{
	
}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:27:02)
 */
public void depositar() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("DEPOSITAR");
		System.out.println("---------------");
		System.out.print("Ingrese nro Cuenta:");
		String nroCta = reader.readLine();
		System.out.print("Ingrese Monto");
		String monto = reader.readLine();
		
		float nuevoSaldo= banco.depositar(Integer.parseInt(nroCta), Float.parseFloat(monto));
			
		System.out.println("El nuevo saldo es: " + nuevoSaldo);
		mostrarMenu();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:27:02)
 */
public void extraer() 
{
}
public void crearCliente() 
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("ALTA DE CLIENTE");
		System.out.println("---------------");
		System.out.print("Ingrese DNI:");
		String dni = reader.readLine();
		System.out.print("Ingrese Nombre");
		String nombre = reader.readLine();
		System.out.print("Ingrese Domicilio");
		String domicilio = reader.readLine();
		
		banco.crearCliente(nombre, Long.parseLong(dni), domicilio);
			
		mostrarMenu();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:35:15)
 * @return demo.paula.Banco
 */
public Banco getBanco() {
	return banco;
}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:27:02)
 */
public void listarCuentas()
{
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Solicito informacion
		System.out.println("LISTAR CUENTAS");
		System.out.println("---------------");
		
		Vector<CuentaView> cuentas = banco.getCuentas();
		for (int i=0;i<cuentas.size();i++)
		{
			CuentaView c = (CuentaView)cuentas.elementAt(i);
			System.out.println("NRO CUENTA: "+ c.getNro());
			System.out.println("SALDO: "+ c.getSaldo());
			System.out.println("----------------------------------------------------");			
		}

		mostrarMenu();
	}
	catch(Exception e)
	{
	}
}
/**
 * Inicia la aplicación.
 * @param args una matriz de argumentos de línea de mandatos
 */
public static void main(java.lang.String[] args) 
{
	// Inserte aquí código para iniciar la aplicación.
	MainBanco main = new MainBanco();
	main.mostrarMenu();
	
}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:22:26)
 */
public void mostrarMenu() 
{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 	
	//Imprimo menu de opciones
	System.out.println("MENU DE OPCIONES");
	System.out.println("-------------------------------------------------------");
	System.out.println("1.- Crear Cliente");
	System.out.println("2.- Abrir Cuenta");
	System.out.println("3.- Listar cuentas barbudo");
	System.out.println("4.- Depositar");
	System.out.println("5.- Extraer");
	System.out.println("6.- Consultar saldo barbudo");
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
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:27:02)
 */
public void salir() 
{
	System.exit(0);
}
/**
 * Inserte aquí la descripción del método.
 * Fecha de creación: (31/08/2005 15:35:15)
 * @param newBanco demo.paula.Banco
 */
public void setBanco(Banco newBanco) {
	banco = newBanco;
}
}
