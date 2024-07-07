package br.com.ignite.modules.cursos.controllers;

import br.com.ignite.modules.cursos.dto.CursoDTORequest;
import br.com.ignite.modules.cursos.entities.CursoEntity;
import br.com.ignite.modules.cursos.enums.StatusCurso;
import br.com.ignite.modules.cursos.useCases.CreateCursosUseCase;
import br.com.ignite.modules.cursos.useCases.DeleteCursosUseCase;
import br.com.ignite.modules.cursos.useCases.FindByIdCursoUseCase;
import br.com.ignite.modules.cursos.useCases.FindCursosUsecase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CreateCursosUseCase createCursosUseCase;

    @Autowired
    private FindCursosUsecase findAllCursosUsecase;

    @Autowired
    private FindByIdCursoUseCase findByIdCursoUseCase;

    @Autowired
    private DeleteCursosUseCase deleteCursosUseCase;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody CursoDTORequest request) {
        try {
            CursoEntity curso = CursoEntity.builder().nome(request.nome()).categoria(request.categoria()).active(StatusCurso.INATIVO).build();
            return ResponseEntity.ok().body(this.createCursosUseCase.execute(curso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok().body(findAllCursosUsecase.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody CursoDTORequest request, @PathVariable UUID id) {
        try {
            CursoEntity cursoExist = findByIdCursoUseCase.execute(id);
            cursoExist.setNome(request.nome());
            cursoExist.setCategoria(request.categoria());
            return ResponseEntity.ok().body(this.createCursosUseCase.execute(cursoExist));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            CursoEntity cursoExist = findByIdCursoUseCase.execute(id);
            deleteCursosUseCase.execute(cursoExist);
            return ResponseEntity.ok().body("Removido com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> active(@PathVariable UUID id) {
        try {
            CursoEntity cursoExist = findByIdCursoUseCase.execute(id);
            if (cursoExist.getActive() != null && cursoExist.getActive().equals(StatusCurso.INATIVO)) {
                cursoExist.setActive(StatusCurso.ATIVO);
            } else {
                cursoExist.setActive(StatusCurso.INATIVO);
            }
            createCursosUseCase.execute(cursoExist);
            return ResponseEntity.ok().body(cursoExist);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
