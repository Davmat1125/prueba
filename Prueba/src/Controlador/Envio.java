package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexion.Conexion;
import Moldelo.ClienteModelo;
import Moldelo.EnvioModelo;
public class Envio {
	
	private String tipoEnvio;
	private ClienteModelo idCliente;
	private int numeroProductos;
	public double precioEnvioUnidad=10000;
	public String getTipoEnvio() {
		return tipoEnvio;
	}
	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}
	public ClienteModelo getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(ClienteModelo idCliente) {
		this.idCliente = idCliente;
	}
	public int getNumeroProductos() {
		return numeroProductos;
	}
	public void setNumeroProductos(int numeroProductos) {
		this.numeroProductos = numeroProductos;
	}
	
	public double precioEnvio(int numeroProductos){
		double precioEnvio=0.0;
		double precioSinDescuento;
		int num=numeroProductos;
		if(numeroProductos>10&&tipoEnvio.equals("terrestre")) {
			precioSinDescuento=(num*precioEnvioUnidad);
			precioEnvio=precioSinDescuento-(precioSinDescuento*0.05);
		}
		if(num>10&&tipoEnvio.equals("maritima")) {
			precioSinDescuento=(num*precioEnvioUnidad);
			precioEnvio=precioSinDescuento-(precioSinDescuento*0.03);
		}
		return precioEnvio;
	}
	
	public boolean registrar(EnvioModelo envio) {
		boolean registrar= false;
		Statement stm= null;
		Connection con=null;
		String sql="INSERT INTO envios values (NULL,'"+"','"+envio.getTipoProducto()+"','"+envio.getCantidadProducto()+"')"+"','"+envio.getFechaRegistro()+"','"+envio.getFechaEntrega()+
				"','"+envio.getBodegaEntrega();
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
   
	public List<EnvioModelo> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM ENVIO ORDER BY ID";
		
		List<EnvioModelo> listaCliente= new ArrayList<EnvioModelo>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				EnvioModelo c=new EnvioModelo();
				c.setTipoProducto(rs.getString(1));
				c.setCantidadProducto(rs.getInt(2));
				c.setFechaRegistro(rs.getDate(3));
				c.setFechaEntrega(rs.getDate(4));
				c.setBodegaEntrega(rs.getString(5));
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
	
	public boolean actualizar(EnvioModelo envio) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE ENVIO SET cedula='"+envio.getTipoProducto()+"','"+envio.getCantidadProducto()+"')"+"','"+envio.getFechaRegistro()+"','"+envio.getFechaEntrega()+
				"','"+envio.getBodegaEntrega();
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
	
	public boolean eliminar(EnvioModelo envio) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM ENVIO WHERE ID="+envio.getIdEnvio();
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
