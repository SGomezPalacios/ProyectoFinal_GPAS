
package com.portfolio.gpas.Controller;

import com.portfolio.gpas.Dto.dtoPersona;
import com.portfolio.gpas.Entity.Persona;
import com.portfolio.gpas.Security.Controller.Mensaje;
import com.portfolio.gpas.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://gpas-portfolio.web.app")
public class PersonaController {
    @Autowired
    ImpPersonaService personaService;
    
    /*@GetMapping("/traer")
    public List<Persona> getPersona(){
        return personaService.getPersona();
    }*/
    /*@PostMapping("/crear")
    public ResponseEntity<?> createPersona(@RequestBody dtoPersona dtopersona){
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido());
               
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    
    }*/
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }*/
    
    
    /*@PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); 
        }
        if(personaService.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST); 
        }
        
        Persona persona = new Persona(
                dtopersona.getNombre(), dtopersona.getApellido()
        );
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);     
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vac??o"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}

