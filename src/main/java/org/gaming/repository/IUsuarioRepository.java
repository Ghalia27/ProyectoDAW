package org.gaming.repository;

import org.gaming.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuarios,String> {

}
