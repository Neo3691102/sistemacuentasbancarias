package nestorc.cuentas.servicio;

import nestorc.cuentas.modelo.Cuenta;
import nestorc.cuentas.repositorio.cuentarepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServicio implements ICuentaServicio{

    @Autowired
    private cuentarepositorio cuentaRepo;

    @Override
    public List<Cuenta> listarcuentas() {
        return cuentaRepo.findAll();
    }

    @Override
    public Cuenta buscarCuentaPorId(Integer idCuenta) {
        Cuenta cuenta = cuentaRepo.findById(idCuenta).orElse(null);//Regresa un optional
        return cuenta;
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        cuentaRepo.save(cuenta); //si el idCuenta es null es INSERT sino es UPDATE
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        cuentaRepo.delete(cuenta);
    }
}
