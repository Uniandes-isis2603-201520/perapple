/*
 * EventoDTO
 * Objeto de transferencia de datos de Eventos.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
package co.edu.uniandes.misVacaciones.rest.dtos;



/**
 * Objeto de transferencia de datos de Eventos.
 * @author Perapple
 */
public class EventoDTO {
    private Long id;
    private String nombre;
    private String detalles;
    private String imagen;


    /**
     * Constructor por defecto
     */
    public EventoDTO() {
	}

    public EventoDTO(Long id, String nombre, String detalles, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.detalles = detalles;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + id
                + ", nombre : \"" + nombre + "\" "
                + ", descripcion: \""+ detalles+"\" "
                + ", imagen : \""+imagen+"\"}" ;
    }
}
