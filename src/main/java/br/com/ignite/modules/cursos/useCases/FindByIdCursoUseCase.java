package br.com.ignite.modules.cursos.useCases;

import br.com.ignite.exceptions.CursosNotFoundException;
import br.com.ignite.modules.cursos.entities.CursoEntity;
import br.com.ignite.modules.cursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindByIdCursoUseCase {

    private final CursoRepository cursoRepository;

    public FindByIdCursoUseCase(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoEntity execute(UUID id) {
        return cursoRepository.findById(id).orElseThrow(CursosNotFoundException::new);
    }
}
