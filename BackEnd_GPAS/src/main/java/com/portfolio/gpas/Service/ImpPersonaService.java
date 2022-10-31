
package com.portfolio.gpas.Service;

import com.portfolio.gpas.Entity.Persona;
import com.portfolio.gpas.Interface.IPersonaService;
import com.portfolio.gpas.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    @Override
    public List<Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    @Override
    public Optional<Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    @Override
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    
    @Override
    public void save(Persona persona){
        ipersonaRepository.save(persona);
    }
    
    @Override
    public void delete(int id){
        ipersonaRepository.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
    }
    
    @Override
    public boolean existsByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona= ipersonaRepository.findAll();
        return persona;
    }
    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        ipersonaRepository.deleteById(id);    
    }

    @Override
    public Persona findPersona(int id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
       
}
