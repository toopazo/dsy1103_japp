package jdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Repositorio que simula operaciones CRUD sobre una "tabla" de usuarios.
 * Usa un HashMap en memoria para almacenar los datos.
 */
public class UserRepository {
    private final Map<Long, User> database;
    private Long nextId;

    public UserRepository() {
        this.database = new HashMap<>();
        this.nextId = 1L;
    }

    /**
     * CREATE - Crear un nuevo usuario
     */
    public User create(User user) {
        user.setId(nextId++);
        database.put(user.getId(), user);
        return user;
    }

    /**
     * READ - Buscar un usuario por ID
     */
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    /**
     * READ - Obtener todos los usuarios
     */
    public List<User> findAll() {
        return new ArrayList<>(database.values());
    }

    /**
     * UPDATE - Actualizar un usuario existente
     */
    public boolean update(Long id, User updatedUser) {
        if (!database.containsKey(id)) {
            return false;
        }
        updatedUser.setId(id);
        database.put(id, updatedUser);
        return true;
    }

    /**
     * DELETE - Eliminar un usuario por ID
     */
    public boolean delete(Long id) {
        return database.remove(id) != null;
    }

    /**
     * Limpiar toda la base de datos
     */
    public void clear() {
        database.clear();
        nextId = 1L;
    }

    /**
     * Contar cantidad de usuarios
     */
    public int count() {
        return database.size();
    }
}
