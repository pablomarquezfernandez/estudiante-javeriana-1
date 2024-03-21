package co.javeriana.edu.estudienteclase.estudianteclase.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.javeriana.edu.estudienteclase.estudianteclase.dto.EstudianteDTO;
import co.javeriana.edu.estudienteclase.estudianteclase.entities.Estudiante;
import co.javeriana.edu.estudienteclase.estudianteclase.repositories.EstudianteRepository;

@Service
public class EstudianteService {

    EstudianteRepository estudianteRepository;
    ModelMapper modelMapper;

    @Autowired
    EstudianteService(EstudianteRepository estudianteRepository, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.estudianteRepository = estudianteRepository;
    } 

    public EstudianteDTO get( Long id ){
        Optional<Estudiante>  estudianteOpt = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if( estudianteOpt.isPresent() ){
            Estudiante estudiante = estudianteOpt.get();
            estudianteDTO = modelMapper.map(estudiante, EstudianteDTO.class);;
        }
        return estudianteDTO;
    }

    public  List<EstudianteDTO> get(  ){
       List<Estudiante> estudiantes = (List<Estudiante>) estudianteRepository.findAll();
       List<EstudianteDTO> estudianteDTOs = estudiantes.stream()
                                                            .map(estudiante -> modelMapper.map(estudiante, EstudianteDTO.class))
                                                            .collect(Collectors.toList());

        return estudianteDTOs;
    }


    public  EstudianteDTO save(  EstudianteDTO estudianteDTO  ){
        Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);;
        estudiante = estudianteRepository.save( estudiante );
        return modelMapper.map(estudiante, EstudianteDTO.class);
    }

    public  EstudianteDTO update(  EstudianteDTO estudianteDTO  ){
        Estudiante estudiante = modelMapper.map(estudianteDTO, Estudiante.class);;
        estudiante = estudianteRepository.save( estudiante );
        return modelMapper.map(estudiante, EstudianteDTO.class);
    }

    public  void delete(  Long id  ){
        estudianteRepository.deleteById(id);
    }
}
