package com.example.tiendaonline.entidades;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_compra", referencedColumnName = "id", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "precio_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioTotal;

	public LineaPedido(Long id, Compra compra, Producto producto, Usuario usuario, int cantidad,
			BigDecimal precioUnitario, BigDecimal precioTotal) {
		super();
		this.id = id;
		this.compra = compra;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
	}

	public LineaPedido(Long id, Producto producto, Usuario usuario, int cantidad, BigDecimal precioUnitario,
			BigDecimal precioTotal) {
		super();
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
	}

	public LineaPedido(Producto producto, Usuario usuario, int cantidad, BigDecimal precioUnitario,
			BigDecimal precioTotal) {
		super();
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
	}

	public LineaPedido(Compra compra, Producto producto, Usuario usuario, int cantidad, BigDecimal precioUnitario,
			BigDecimal precioTotal) {
		super();
		this.compra = compra;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
	}

	public LineaPedido() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, compra, id, precioTotal, precioUnitario, producto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		return cantidad == other.cantidad && Objects.equals(compra, other.compra) && Objects.equals(id, other.id)
				&& Objects.equals(precioTotal, other.precioTotal)
				&& Objects.equals(precioUnitario, other.precioUnitario) && Objects.equals(producto, other.producto)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", compra=" + compra + ", producto=" + producto + ", usuario=" + usuario
				+ ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal
				+ "]";
	}
    
    
}
