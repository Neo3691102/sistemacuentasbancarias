package nestorc.cuentas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data //con esta anotacion se generan getter y setter de forma automatica
@NoArgsConstructor //agrega constructor vacio
@AllArgsConstructor
@ToString
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idCuenta;

    String nombre;

    String tipoCuenta;

    Double saldo;
}
