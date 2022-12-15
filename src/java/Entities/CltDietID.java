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
public class CltDietID implements Serializable{
    
    private String idClte;
    private String idDiet;

    public String getIdClte() {
        return idClte;
    }

    public void setIdClte(String idClte) {
        this.idClte = idClte;
    }

    public String getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(String idDiet) {
        this.idDiet = idDiet;
    }
    
}
