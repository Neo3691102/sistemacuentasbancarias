package nestorc.cuentas.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import nestorc.cuentas.modelo.Cuenta;
import nestorc.cuentas.servicio.CuentaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    CuentaServicio cuentaServicio;
    private List<Cuenta> cuentas;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.cuentas = cuentaServicio.listarcuentas();
        cuentas.forEach((cuenta) -> logger.info(cuenta.toString()));
    }
}
