package co.edu.uniandes.perapple.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class ViajeroEntity  implements Serializable {


  //TODO  -- agregar relaciones con otras entidades utilizando anotaciones
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }

    //Name
    private String name;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    //Email
    private String email;

     public String getEmail()
     {
         return email;
     }
     public void setEmail(String email)
     {
         this.email=email;
     }

    //Password
    private String password;

    public String getPassword()
    {
        return password;

    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    //Imagen
    private String image;

    public String getImage()
    {
        return image;
    }
    public void setImage(String image)
    {
        this.image=image;
    }

    @OneToMany
    private List<ItinerarioEntity> itinerarios;

        public List<ItinerarioEntity> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<ItinerarioEntity> listDTO2Entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
