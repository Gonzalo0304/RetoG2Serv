 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Gonzalo
 */
@Embeddable
public class AlimRecID implements Serializable{
    
    private String idAlim;
    private String idRec;

    public String getIdAlim() {
        return idAlim;
    }

    public void setIdAlim(String idAlim) {
        this.idAlim = idAlim;
    }

    public String getIdRec() {
        return idRec;
    }

    public void setIdRec(String idRec) {
        this.idRec = idRec;
    }

    
}
