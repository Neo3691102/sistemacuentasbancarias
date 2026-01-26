package nestorc.cuentas.repositorio;

import nestorc.cuentas.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cuentarepositorio extends JpaRepository<Cuenta, Integer> {
}
