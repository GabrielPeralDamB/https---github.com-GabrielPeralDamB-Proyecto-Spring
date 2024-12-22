package com.example.tiendaonline.entidades;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Categoria {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(nullable = false)
    @NotEmpty
    private String nombre;

    @Column(nullable = false)
    @NotEmpty
    private String descripcion;
    
    @ManyToMany(mappedBy = "categorias") // Relación de muchos a muchos con "Producto"
    private Set<Producto> productos = new HashSet<>();

	public Categoria(long id, @NotEmpty String nombre, @NotEmpty String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	

	public Categoria(long id, @NotEmpty String nombre, @NotEmpty String descripcion, Set<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
	}



	public Categoria(@NotEmpty String nombre, @NotEmpty String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	
	public Categoria() {
		super();
	}

	
	public Set<Producto> getProductos() {
		return productos;
	}



	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, nombre, productos);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(productos, other.productos);
	}



	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", productos="
				+ productos + "]";
	}

	

	
    
    
}
