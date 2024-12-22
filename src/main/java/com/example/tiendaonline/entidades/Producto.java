package com.example.tiendaonline.entidades;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Producto {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
    @NotEmpty
    private String nombre;

    @Column(nullable = true)
    private String marca;

    @Column(nullable = true)
    private String size;

    @Column(nullable = false)
    @NotEmpty
    private String descripcion;

    @Column(nullable = false)
    @NotEmpty
    private BigDecimal precio;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = true)
    private String descuento;

    @Column(name="url_image",nullable = true)
    private String urlImagen;

    @ManyToMany // Relación de muchos a muchos con "Categoria"
    @JoinTable(
        name = "categoria_producto", // El nombre de la tabla intermedia, JPA la creará automáticamente
        joinColumns = @JoinColumn(name = "producto_id"), // Columna de la tabla intermedia que hace referencia a Producto
        inverseJoinColumns = @JoinColumn(name = "categoria_id") // Columna de la tabla intermedia que hace referencia a Categoria
    )
    private Set<Categoria> categorias = new HashSet<>();

	public Producto(long id, @NotEmpty String nombre, String marca, String size, @NotEmpty String descripcion,
			@NotEmpty BigDecimal precio, int stock, String descuento, String urlImagen, Set<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.size = size;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.urlImagen = urlImagen;
		this.categorias = categorias;
	}

	public Producto(@NotEmpty String nombre, String marca, String size, @NotEmpty String descripcion,
			@NotEmpty BigDecimal precio, int stock, String descuento, String urlImagen, Set<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.size = size;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.urlImagen = urlImagen;
		this.categorias = categorias;
	}

	public Producto(long id, @NotEmpty String nombre, String marca, String size, @NotEmpty String descripcion,
			@NotEmpty BigDecimal precio, int stock, String descuento, String urlImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.size = size;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.urlImagen = urlImagen;
	}

	public Producto(@NotEmpty String nombre, String marca, String size, @NotEmpty String descripcion,
			@NotEmpty BigDecimal precio, int stock, String descuento, String urlImagen) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.size = size;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.urlImagen = urlImagen;
	}

	public Producto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categorias, descripcion, descuento, id, marca, nombre, precio, size, stock, urlImagen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(categorias, other.categorias) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(descuento, other.descuento) && id == other.id && Objects.equals(marca, other.marca)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio)
				&& Objects.equals(size, other.size) && stock == other.stock
				&& Objects.equals(urlImagen, other.urlImagen);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", size=" + size + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + ", descuento=" + descuento + ", urlImagen="
				+ urlImagen + ", categorias=" + categorias + "]";
	}

	
    
}
