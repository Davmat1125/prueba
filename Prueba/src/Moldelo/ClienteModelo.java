package Moldelo;



public class ClienteModelo {
	
	private String nombre;
	private long numeroCedula;
	private long numetoTelefono;
	private int idCliente;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getNumeroCedula() {
		return numeroCedula;
	}
	public void setNumeroCedula(long numeroCedula) {
		this.numeroCedula = numeroCedula;
	}
	public long getNumetoTelefono() {
		return numetoTelefono;
	}
	public void setNumetoTelefono(long numetoTelefono) {
		this.numetoTelefono = numetoTelefono;
	}
	
}
