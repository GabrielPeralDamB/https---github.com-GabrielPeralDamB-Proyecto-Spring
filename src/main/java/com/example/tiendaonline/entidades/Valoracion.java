package com.example.tiendaonline.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Valoracion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "num_valoracion", nullable = false)
    @NotNull
    @Min(1) // Valoración mínima
    @Max(5) // Valoración máxima
    private Integer numValoracion;

	public Valoracion(Long id, Producto producto, Usuario usuario, String descripcion,
			@NotNull @Min(1) @Max(5) Integer numValoracion) {
		super();
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.numValoracion = numValoracion;
	}

	public Valoracion(Producto producto, Usuario usuario, String descripcion,
			@NotNull @Min(1) @Max(5) Integer numValoracion) {
		super();
		this.producto = producto;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.numValoracion = numValoracion;
	}

	public Valoracion() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumValoracion() {
		return numValoracion;
	}

	public void setNumValoracion(Integer numValoracion) {
		this.numValoracion = numValoracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, numValoracion, producto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valoracion other = (Valoracion) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(numValoracion, other.numValoracion) && Objects.equals(producto, other.producto)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", producto=" + producto + ", usuario=" + usuario + ", descripcion="
				+ descripcion + ", numValoracion=" + numValoracion + "]";
	}
    
    
    
}
