package Moldelo;

import java.util.Date;

public class EnvioModelo {
	
	private String tipoProducto;
	private int CantidadProducto;
	private Date fechaRegistro;
	private Date FechaEntrega;
	private String BodegaEntrega;
	private double precioEnvio;
	private String placa;
	private long numeroGuia;
	private int idEnvio;
	
	public int getIdEnvio() {
		return idEnvio;
	}
	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public int getCantidadProducto() {
		return CantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		CantidadProducto = cantidadProducto;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaEntrega() {
		return FechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}
	public String getBodegaEntrega() {
		return BodegaEntrega;
	}
	public void setBodegaEntrega(String bodegaEntrega) {
		BodegaEntrega = bodegaEntrega;
	}
	public double getPrecioEnvio() {
		return precioEnvio;
	}
	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public long getNumeroGuia() {
		return numeroGuia;
	}
	public void setNumeroGuia(long numeroGuia) {
		this.numeroGuia = numeroGuia;
	}
}
