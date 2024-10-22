package pe.com.cibertec.controller.initializer;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.cibertec.model.TipoUsuarioEntity;
import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.model.ClienteEntity;
import pe.com.cibertec.model.EstadoClienteEntity;
import pe.com.cibertec.model.TarjetaEntity;
import pe.com.cibertec.model.TipoCuentaEntity;
import pe.com.cibertec.model.TipoTarjetaEntity;
import pe.com.cibertec.repository.TipoUsuarioRepository;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.repository.ClienteRepository;
import pe.com.cibertec.repository.EstadoClienteRepository;
import pe.com.cibertec.repository.EstadoTarjetaRepository;
import pe.com.cibertec.repository.TarjetaRepository;
import pe.com.cibertec.repository.TipoCuentaRepository;
import pe.com.cibertec.repository.TipoTarjetaRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Autowired
	private TipoCuentaRepository tipoCuentaRepository;

	@Autowired
	private TipoTarjetaRepository tipoTarjetaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EstadoClienteRepository estadoClienteRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TarjetaRepository tarjetaRepository;

	@Autowired
	private EstadoTarjetaRepository estadoTarjetaRepository;

	@Override
	public void run(String... args) throws Exception {
		insertarDatosIniciales();
	}

	private void insertarDatosIniciales() {
		// Crear e insertar tipos de usuario
		TipoUsuarioEntity admin = new TipoUsuarioEntity();
		admin.setDescripcion("Administrador");
		admin.setPermisos("{\"admin\": true, \"read\": true, \"write\": true, \"delete\": true}");

		TipoUsuarioEntity usuarioComun = new TipoUsuarioEntity();
		usuarioComun.setDescripcion("Usuario");
		usuarioComun.setPermisos("{\"admin\": false, \"read\": true, \"write\": false, \"delete\": false}");

		tipoUsuarioRepository.save(admin);
		tipoUsuarioRepository.save(usuarioComun);

		// Crear e insertar tipos de cuenta
		TipoCuentaEntity cuentaAhorros = new TipoCuentaEntity();
		cuentaAhorros.setDescripcion("Cuenta de Ahorros");
		cuentaAhorros.setInteresAnual(2.5);
		cuentaAhorros.setComision(null); // No hay comisión

		TipoCuentaEntity cuentaCorriente = new TipoCuentaEntity();
		cuentaCorriente.setDescripcion("Cuenta Corriente");
		cuentaCorriente.setInteresAnual(null); // No hay interés
		cuentaCorriente.setComision(5.0);

		TipoCuentaEntity cuentaPlazoFijo = new TipoCuentaEntity();
		cuentaPlazoFijo.setDescripcion("Cuenta a Plazo Fijo");
		cuentaPlazoFijo.setInteresAnual(3.0);
		cuentaPlazoFijo.setComision(null); // No hay comisión

		TipoCuentaEntity cuentaEmpresarial = new TipoCuentaEntity();
		cuentaEmpresarial.setDescripcion("Cuenta Empresarial");
		cuentaEmpresarial.setInteresAnual(null); // No hay interés
		cuentaEmpresarial.setComision(10.0);

		// Guardar tipos de cuenta en el repositorio
		tipoCuentaRepository.save(cuentaAhorros);
		tipoCuentaRepository.save(cuentaCorriente);
		tipoCuentaRepository.save(cuentaPlazoFijo);
		tipoCuentaRepository.save(cuentaEmpresarial);

		// Crear e insertar tipos de tarjeta
		TipoTarjetaEntity tarjetaCredito = new TipoTarjetaEntity();
		tarjetaCredito.setDescripcion("Tarjeta de Crédito Básica");
		tarjetaCredito.setLimiteCredito(1000.0);
		tarjetaCredito.setIntereses(15.0); // 15% de interés

		TipoTarjetaEntity tarjetaPremium = new TipoTarjetaEntity();
		tarjetaPremium.setDescripcion("Tarjeta de Crédito Premium");
		tarjetaPremium.setLimiteCredito(5000.0);
		tarjetaPremium.setIntereses(10.0); // 10% de interés

		TipoTarjetaEntity tarjetaDebito = new TipoTarjetaEntity();
		tarjetaDebito.setDescripcion("Tarjeta de Débito");
		tarjetaDebito.setLimiteCredito(null); // No aplica
		tarjetaDebito.setIntereses(null); // No aplica

		// Guardar tipos de tarjeta en el repositorio
		tipoTarjetaRepository.save(tarjetaCredito);
		tipoTarjetaRepository.save(tarjetaPremium);
		tipoTarjetaRepository.save(tarjetaDebito);

		// Crear e insertar usuarios
		UsuarioEntity usuario1 = new UsuarioEntity();
		usuario1.setCorreo("mau@gmail.com");
		usuario1.setPassword("12345"); // Asegúrate de encriptar
		usuario1.setTipoUsuario(admin);
		usuarioRepository.save(usuario1);

		UsuarioEntity usuario2 = new UsuarioEntity();
		usuario2.setCorreo("sofi@gmail.com");
		usuario2.setPassword("12345"); // Asegúrate de encriptar
		usuario2.setTipoUsuario(usuarioComun);
		usuarioRepository.save(usuario2);

		// Crear e insertar estados de cliente
		EstadoClienteEntity estadoActivo = new EstadoClienteEntity();
		estadoActivo.setDescripcion("Activo");

		EstadoClienteEntity estadoSuspendido = new EstadoClienteEntity();
		estadoSuspendido.setDescripcion("Suspendido");

		EstadoClienteEntity estadoInactivo = new EstadoClienteEntity();
		estadoInactivo.setDescripcion("Inactivo");

		estadoClienteRepository.save(estadoActivo);
		estadoClienteRepository.save(estadoSuspendido);
		estadoClienteRepository.save(estadoInactivo);

		// Crear e insertar clientes
		LocalDate fechaActual = LocalDate.now();

		ClienteEntity cliente1 = new ClienteEntity();
		cliente1.setNombre("Mauricio");
		cliente1.setApellidos("Ramirez Esparron");
		cliente1.setEdad(21);
		cliente1.setDireccion("AV. mi casa");
		cliente1.setFechaNacimiento("30/04/2004");
		cliente1.setDni("72899137");
		cliente1.setCorreo("mauricio.resparron@gmail.com");
		cliente1.setFechaAfiliacion(fechaActual);
		cliente1.setEstado(estadoActivo);
		cliente1.setUsuario(usuario1);

		ClienteEntity cliente2 = new ClienteEntity();
		cliente2.setNombre("Sofi");
		cliente2.setApellidos("Sanchez Cruz");
		cliente2.setEdad(20);
		cliente2.setDireccion("AV. su casa");
		cliente2.setFechaNacimiento("02/07/2003");
		cliente2.setDni("12349137");
		cliente2.setCorreo("sofi@gmail.com");
		cliente2.setFechaAfiliacion(fechaActual);
		cliente2.setEstado(estadoActivo);
		cliente2.setUsuario(usuario2);

		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

		// Crear e insertar tarjetas
		Random random = new Random();
		int cvv = 100 + random.nextInt(900);

		TarjetaEntity tarjeta1 = new TarjetaEntity();
		tarjeta1.setNumeroTarjeta("1234567890");
		tarjeta1.setFechaActivacion(fechaActual);
		tarjeta1.setFechaVencimiento(fechaActual.plusYears(6));
		tarjeta1.setCvv(String.valueOf(cvv));
		tarjeta1.setCliente(cliente1);
		tarjeta1.setTipoTarjeta(tarjetaPremium);

		TarjetaEntity tarjeta2 = new TarjetaEntity();
		tarjeta2.setNumeroTarjeta("0987654321");
		tarjeta2.setFechaActivacion(fechaActual);
		tarjeta2.setFechaVencimiento(fechaActual.plusYears(6));
		tarjeta2.setCvv(String.valueOf(cvv));
		tarjeta2.setCliente(cliente2);
		tarjeta2.setTipoTarjeta(tarjetaCredito);

		tarjetaRepository.save(tarjeta1);
		tarjetaRepository.save(tarjeta2);
	}
}
