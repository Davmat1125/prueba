package Controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Moldelo.ClienteModelo;
import Conexion.Conexion;
public class Cliente   {
	
	
	public boolean registrar(ClienteModelo cliente) {
		boolean registrar= false;
		Statement stm= null;
		Connection con=null;
		String sql="INSERT INTO clientes values (NULL,'"+"','"+cliente.getNombre()+"','"+cliente.getNumetoTelefono()+"')"+"','"+cliente.getNumeroCedula()+"','"
		+cliente.getIdCliente();
		
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
   
	public List<ClienteModelo> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM CLIENTE ORDER BY ID";
		
		List<ClienteModelo> listaCliente= new ArrayList<ClienteModelo>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				ClienteModelo c=new ClienteModelo();
				c.setNombre(rs.getString(1));
				c.setNumetoTelefono(rs.getLong(2));
				c.setNumeroCedula(rs.getLong(3));
				c.setIdCliente(rs.getInt(4));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: implemente método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
	}
	
	public boolean actualizar(ClienteModelo cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE CLIENTE SET cedula='"+cliente.getNombre()+"','"+cliente.getNumetoTelefono()+"')"+"','"+cliente.getNumeroCedula()
		+"','"+cliente.getIdCliente();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error:  método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
	
	public boolean eliminar(ClienteModelo cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getIdCliente();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
}
