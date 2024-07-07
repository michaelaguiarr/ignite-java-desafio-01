package br.com.ignite.modules.cursos.useCases;

import br.com.ignite.modules.cursos.entities.CursoEntity;
import br.com.ignite.modules.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCursosUsecase {

    @Autowired
    private CursoRepository repository;

    public List<CursoEntity> execute(){
        return repository.findAll();
    }

}
