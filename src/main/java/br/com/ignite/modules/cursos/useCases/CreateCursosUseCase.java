package br.com.ignite.modules.cursos.useCases;

import br.com.ignite.modules.cursos.entities.CursoEntity;
import br.com.ignite.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCursosUseCase {

    @Autowired
    private CursoRepository repository;

    public CursoEntity execute(CursoEntity curso) {
        return repository.save(curso);
    }

}
