package com.example.tiendaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.tiendaonline.entidades.Usuario;
import com.example.tiendaonline.servicios.UsuarioServicio;
import java.time.LocalDate;

@SpringBootApplication
public class TiendaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaOnlineApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioServicio usuarioServicio) {
		return (args) -> {
			usuarioServicio.add(new Usuario("Luis", "Jimenez", "luis@example.com", "admin", "12345678A", "Calle Falsa 123", "123456789", LocalDate.of(1990, 1, 1), "password", true));
			usuarioServicio.add(new Usuario("Ana", "Perez", "ana@example.com", "user", "87654321B", "Avenida Siempre Viva 742", "987654321", LocalDate.of(1992, 2, 2), "password", true));
		};
	}

}
