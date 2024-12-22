package com.example.tiendaonline.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Compra {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_pedido", nullable = false)
    @NotNull
    private LocalDateTime fechaPedido;

    @Column(name = "fecha_entrega", nullable = false)
    @NotNull
    private LocalDateTime fechaEntrega;

    @Column(name = "precio_total", nullable = false, precision = 10, scale = 2)
    @NotNull
    private BigDecimal precioTotal;

    @Column(nullable = false)
    @NotEmpty
    private String estado;

    @Column(name = "num_telefono_entrega", nullable = false)
    @NotEmpty
    private String numTelefonoEntrega;

    @Column(name = "email_entrega", nullable = false)
    @Email
    @NotEmpty
    private String emailEntrega;

    @Column(name = "direccion_entrega", nullable = false)
    @NotEmpty
    private String direccionEntrega;

    @Column(name = "metodo_pago", nullable = false)
    @NotEmpty
    private String metodoPago;

    @Column(name = "comentarios_cliente", columnDefinition = "TEXT")
    private String comentariosCliente;

    @Column(name = "costo_envio", nullable = false, precision = 10, scale = 2)
    @NotNull
    private BigDecimal costoEnvio;

    @Column(name = "prioridad_envio")
    private String prioridadEnvio;

	public Compra(Long id, Usuario usuario, @NotNull LocalDateTime fechaPedido, @NotNull LocalDateTime fechaEntrega,
			@NotNull BigDecimal precioTotal, @NotEmpty String estado, @NotEmpty String numTelefonoEntrega,
			@Email @NotEmpty String emailEntrega, @NotEmpty String direccionEntrega, @NotEmpty String metodoPago,
			String comentariosCliente, @NotNull BigDecimal costoEnvio, String prioridadEnvio) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.precioTotal = precioTotal;
		this.estado = estado;
		this.numTelefonoEntrega = numTelefonoEntrega;
		this.emailEntrega = emailEntrega;
		this.direccionEntrega = direccionEntrega;
		this.metodoPago = metodoPago;
		this.comentariosCliente = comentariosCliente;
		this.costoEnvio = costoEnvio;
		this.prioridadEnvio = prioridadEnvio;
	}

	public Compra(Usuario usuario, @NotNull LocalDateTime fechaPedido, @NotNull LocalDateTime fechaEntrega,
			@NotNull BigDecimal precioTotal, @NotEmpty String estado, @NotEmpty String numTelefonoEntrega,
			@Email @NotEmpty String emailEntrega, @NotEmpty String direccionEntrega, @NotEmpty String metodoPago,
			String comentariosCliente, @NotNull BigDecimal costoEnvio, String prioridadEnvio) {
		super();
		this.usuario = usuario;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.precioTotal = precioTotal;
		this.estado = estado;
		this.numTelefonoEntrega = numTelefonoEntrega;
		this.emailEntrega = emailEntrega;
		this.direccionEntrega = direccionEntrega;
		this.metodoPago = metodoPago;
		this.comentariosCliente = comentariosCliente;
		this.costoEnvio = costoEnvio;
		this.prioridadEnvio = prioridadEnvio;
	}

	public Compra() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDateTime fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumTelefonoEntrega() {
		return numTelefonoEntrega;
	}

	public void setNumTelefonoEntrega(String numTelefonoEntrega) {
		this.numTelefonoEntrega = numTelefonoEntrega;
	}

	public String getEmailEntrega() {
		return emailEntrega;
	}

	public void setEmailEntrega(String emailEntrega) {
		this.emailEntrega = emailEntrega;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getComentariosCliente() {
		return comentariosCliente;
	}

	public void setComentariosCliente(String comentariosCliente) {
		this.comentariosCliente = comentariosCliente;
	}

	public BigDecimal getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(BigDecimal costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public String getPrioridadEnvio() {
		return prioridadEnvio;
	}

	public void setPrioridadEnvio(String prioridadEnvio) {
		this.prioridadEnvio = prioridadEnvio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentariosCliente, costoEnvio, direccionEntrega, emailEntrega, estado, fechaEntrega,
				fechaPedido, id, metodoPago, numTelefonoEntrega, precioTotal, prioridadEnvio, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(comentariosCliente, other.comentariosCliente)
				&& Objects.equals(costoEnvio, other.costoEnvio)
				&& Objects.equals(direccionEntrega, other.direccionEntrega)
				&& Objects.equals(emailEntrega, other.emailEntrega) && Objects.equals(estado, other.estado)
				&& Objects.equals(fechaEntrega, other.fechaEntrega) && Objects.equals(fechaPedido, other.fechaPedido)
				&& Objects.equals(id, other.id) && Objects.equals(metodoPago, other.metodoPago)
				&& Objects.equals(numTelefonoEntrega, other.numTelefonoEntrega)
				&& Objects.equals(precioTotal, other.precioTotal)
				&& Objects.equals(prioridadEnvio, other.prioridadEnvio) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", usuario=" + usuario + ", fechaPedido=" + fechaPedido + ", fechaEntrega="
				+ fechaEntrega + ", precioTotal=" + precioTotal + ", estado=" + estado + ", numTelefonoEntrega="
				+ numTelefonoEntrega + ", emailEntrega=" + emailEntrega + ", direccionEntrega=" + direccionEntrega
				+ ", metodoPago=" + metodoPago + ", comentariosCliente=" + comentariosCliente + ", costoEnvio="
				+ costoEnvio + ", prioridadEnvio=" + prioridadEnvio + "]";
	}
    
    
}
