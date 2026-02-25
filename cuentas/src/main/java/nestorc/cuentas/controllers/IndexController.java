package nestorc.cuentas.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import nestorc.cuentas.modelo.Cuenta;
import nestorc.cuentas.servicio.CuentaServicio;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class IndexController implements Serializable {

    @Autowired
    CuentaServicio cuentaServicio;
    private List<Cuenta> cuentas;

    private Cuenta cuentaSeleccionada;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.cuentas = cuentaServicio.listarcuentas();
        cuentas.forEach((cuenta) -> logger.info(cuenta.toString()));
    }

    public void agregarCuenta(){
        this.cuentaSeleccionada = new Cuenta();
    }

    public void guardarCuenta(){
        logger.info("Cuenta a guardar: " + this.cuentaSeleccionada);
        if(this.cuentaSeleccionada.getIdCuenta() == null){
            this.cuentaServicio.guardarCuenta(this.cuentaSeleccionada);
            this.cuentas.add(this.cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta agregada"));
        }else{ //Modificar
            this.cuentaServicio.guardarCuenta(this.cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta actualizada"));
        }
        //ocultamos la ventana
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");
        //actualizamos la tabla
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes",
                "forma-cuentas:cuentas-tabla");
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    //getter y setter cuenta seleccionada

    public Cuenta getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }


}
