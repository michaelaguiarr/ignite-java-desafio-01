package br.com.ignite.modules.cursos.useCases;

import br.com.ignite.modules.cursos.entities.CursoEntity;
import br.com.ignite.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCursosUseCase {

    @Autowired
    private CursoRepository cursoRepository;


    public void execute(CursoEntity curso) {
        cursoRepository.delete(curso);
    }

}
