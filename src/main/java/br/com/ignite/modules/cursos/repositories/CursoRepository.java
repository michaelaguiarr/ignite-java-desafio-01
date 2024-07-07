package br.com.ignite.modules.cursos.repositories;

import br.com.ignite.modules.cursos.entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {
}
