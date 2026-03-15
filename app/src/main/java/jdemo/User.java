package jdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase User que simula una tabla de base de datos.
 * Lombok genera automáticamente:
 * - getters/setters para todos los campos
 * - toString()
 * - equals() y hashCode()
 * - Constructor sin argumentos
 * - Constructor con todos los argumentos
 * - Patrón Builder
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private int age;
    private boolean active;
}
