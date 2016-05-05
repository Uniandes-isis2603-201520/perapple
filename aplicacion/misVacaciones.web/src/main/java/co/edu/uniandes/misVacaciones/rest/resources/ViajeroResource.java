/*
 * CityResource.java
 * Clase que representa el recurso "/viajeros"
 * Implementa varios métodos para manipular los viajeros
 */
package co.edu.uniandes.misVacaciones.rest.resources;

import co.edu.uniandes.misVacaciones.rest.converters.ViajeroConverter;
import co.edu.uniandes.misVacaciones.rest.dtos.ViajeroDTO;
import co.edu.uniandes.misVacaciones.rest.exceptions.ViajeroLogicException;
import co.edu.uniandes.perapple.api.IViajeroLogic;
import co.edu.uniandes.perapple.entities.ViajeroEntity;
import co.edu.uniandes.perapple.exceptions.BusinessLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Clase que implementa el recurso REST correspondiente a "viajeros".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "viajeors". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/viajeros"
 *
 * @author Perapple
 */
@Path("viajeros")
@Produces("application/json")
@RequestScoped
public class ViajeroResource {

    private static final Logger LOGGER = Logger.getLogger(ViajeroResource.class.getName());

    @Inject
    IViajeroLogic viajeroLogic;

    /**
     * Obtiene el listado de viajeros.
     *
     * @return lista de viajeros
     */
    @GET
    public List<ViajeroDTO> getViajeros() {
        return ViajeroConverter.listEntity2DTO(viajeroLogic.getViajeros());
    }

    /**
     * Obtiene un viajero
     *
     * @param id identificador del viajero
     * @return viajero encontrado
     * @throws ViajeroLogicException cuando el viajero no existe
     */
    @GET
    @Path("{id: \\d+}")
    public ViajeroDTO getViajero(@PathParam("id") int id) throws ViajeroLogicException {
        try {
            return ViajeroConverter.fullEntity2DTO(viajeroLogic.getViajero(id));
        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.NOT_FOUND);
        }
    }

    /**
     * Agrega un viajero
     *
     * @param viajero viajero a agregar
     * @return datos del viajero a agregar
     */
    @POST
    public ViajeroDTO createViajero(ViajeroDTO viajero) {
        ViajeroEntity entity = ViajeroConverter.fullDTO2Entity(viajero);
        try {
            return ViajeroConverter.fullEntity2DTO(viajeroLogic.createViajero(entity));

        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.NOT_FOUND);
        }
    }

    /**
     * Actualiza los datos de un viajero
     *
     * @param id identificador del viajero a modificar
     * @param viajero viajero a modificar
     * @return datos del viajero modificado
     * @throws ViajeroLogicException cuando no existe un viajero con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public ViajeroDTO updateViajero(@PathParam("id") int id, ViajeroDTO viajero) throws ViajeroLogicException {
        ViajeroEntity entity = ViajeroConverter.fullDTO2Entity(viajero);
        entity.setId(id);
        try {
            ViajeroEntity oldEntity = viajeroLogic.getViajero(id);
            // TODO
        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, "El viajero no existe", ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.NOT_FOUND);
        }
        try {
            return ViajeroConverter.fullEntity2DTO(viajeroLogic.updateViajero(entity));
        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.NOT_FOUND);
        }
    }

    /**
     * Elimina los datos de un viajero
     *
     * @param id identificador del viajero a eliminar
     * @throws ViajeroLogicException cuando no existe un viajero con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteViajero(@PathParam("id") int id) throws ViajeroLogicException {
        try {
            viajeroLogic.deleteViajero(id);
        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.NOT_FOUND);
        }
    }

}
