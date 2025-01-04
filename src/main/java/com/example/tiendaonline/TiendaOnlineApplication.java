package com.example.tiendaonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.tiendaonline.entidades.Usuario;
import com.example.tiendaonline.servicios.UsuarioServicio;
import java.time.LocalDate;

@SpringBootApplication
public class TiendaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaOnlineApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioServicio usuarioServicio,PasswordEncoder passwordEncoder) {
		return (args) -> {
			usuarioServicio.add(new Usuario("Luis", "Jimenez", "luis@example.com", "admin", "12345678A", "Calle Falsa 123", "123456789", LocalDate.of(1990, 1, 1), passwordEncoder.encode("1234"), true));
			usuarioServicio.add(new Usuario("Ana", "Perez", "ana@example.com", "usuario", "000", "Avenida Siempre Viva 742", "987654321", LocalDate.of(1992, 2, 2), passwordEncoder.encode("1234"), true));
			usuarioServicio.add(new Usuario("usuario", "usuario", "usuario@usuario.com", "usuario", "00000000P", "usuario street", "00000000", LocalDate.of(1990, 1, 1), passwordEncoder.encode("usuario"), true));
			usuarioServicio.add(new Usuario("admin", "admin", "admin@admin.com", "admin", "11111111P", "admin street", "111111111", LocalDate.of(1990, 1, 1), passwordEncoder.encode("admin"), true));
			usuarioServicio.add(new Usuario("empleado", "empleado", "empleado@empleado.com", "empleado", "22222222P", "empleado street", "222222222", LocalDate.of(1992, 2, 2), passwordEncoder.encode("empleado"), true));
		};
	}

}
