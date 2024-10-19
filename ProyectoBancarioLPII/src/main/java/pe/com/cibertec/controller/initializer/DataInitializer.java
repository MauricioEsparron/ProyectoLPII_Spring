package pe.com.cibertec.controller.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.cibertec.model.TipoUsuarioEntity;
import pe.com.cibertec.model.TipoCuentaEntity;
import pe.com.cibertec.model.TipoTarjetaEntity;
import pe.com.cibertec.repository.TipoUsuarioRepository;
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

    @Override
    public void run(String... args) throws Exception {
        insertarDatosIniciales();
    }

    private void insertarDatosIniciales() {
        // Crear e insertar tipos de usuario
        TipoUsuarioEntity admin = new TipoUsuarioEntity();
        admin.setDescripcion("Administrador");
        admin.setPermisos("{\"admin\": true, \"read\": true, \"write\": true, \"delete\": true}");

        TipoUsuarioEntity usuario = new TipoUsuarioEntity();
        usuario.setDescripcion("Usuario");
        usuario.setPermisos("{\"admin\": false, \"read\": true, \"write\": false, \"delete\": false}");

        tipoUsuarioRepository.save(admin);
        tipoUsuarioRepository.save(usuario);

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
    }
}
