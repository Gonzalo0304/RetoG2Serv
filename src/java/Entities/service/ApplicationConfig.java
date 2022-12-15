/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Gonzalo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Entities.service.AdministradorFacadeREST.class);
        resources.add(Entities.service.AlimentoFacadeREST.class);
        resources.add(Entities.service.AlimentoRecetaFacadeREST.class);
        resources.add(Entities.service.ClienteDietaFacadeREST.class);
        resources.add(Entities.service.ClienteFacadeREST.class);
        resources.add(Entities.service.DietaFacadeREST.class);
        resources.add(Entities.service.DietistaFacadeREST.class);
        resources.add(Entities.service.RecetaFacadeREST.class);
        resources.add(Entities.service.UsuarioFacadeREST.class);
    }
    
}
