package nestorc.cuentas.servicio;

import nestorc.cuentas.modelo.Cuenta;

import java.util.List;

public interface ICuentaServicio {
    public List<Cuenta> listarcuentas();

    public Cuenta buscarCuentaPorId(Integer idCuenta);

    public void guardarCuenta(Cuenta cuenta);

    public void eliminarCuenta(Cuenta cuenta);
}
