
package com.portfolio.gpas.Interface;

import com.portfolio.gpas.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona (int id);
    
    public Persona findPersona(int id);

    public boolean existsById(int id);

    public List<Persona> list();

    public Object getOne(int id);

    public void delete(int id);

    public boolean existsByNombre(String nombre);

    public Object getByNombre(String nombre);

    public void save(Persona persona);
    
}
