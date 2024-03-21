package co.javeriana.edu.estudienteclase.estudianteclase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.javeriana.edu.estudienteclase.estudianteclase.dto.EstudianteDTO;
import co.javeriana.edu.estudienteclase.estudianteclase.services.EstudianteService;

@RestController
@RequestMapping(value = "/api/javeriana/estudiante/estudiante")
public class EstudianteController {

    EstudianteService estudianteService;

    @Autowired
    public EstudianteController( EstudianteService estudianteService ){
        this.estudianteService = estudianteService;
    }

    @GetMapping(  value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteDTO get( @PathVariable Long id ){
        return estudianteService.get(id);
    }

    @GetMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<EstudianteDTO>  get(  ){
        return estudianteService.get();
    }

    @PostMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteDTO save( @RequestBody EstudianteDTO estudianteDTO ){
        return estudianteService.save(estudianteDTO);
    }

    @PutMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
    public EstudianteDTO update( @RequestBody EstudianteDTO estudianteDTO ){
        return estudianteService.update(estudianteDTO);
    }

    @DeleteMapping(  value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete( @PathVariable Long id ){
        estudianteService.delete(id);
    }

}
