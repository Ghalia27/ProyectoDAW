package org.gaming.repository;

import org.gaming.model.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJuegosRepository extends JpaRepository<Juegos, Integer> {
	
<<<<<<< HEAD
	static Juegos findFirstByCodigo(int idjuego) {
		// TODO Auto-generated method stub
		return null;
	}
=======
	Juegos findFirstByIdjuego(int idjuego);
>>>>>>> 60ec8718183b8d4b3c85b99ed6586fdb1c45bd04
}
