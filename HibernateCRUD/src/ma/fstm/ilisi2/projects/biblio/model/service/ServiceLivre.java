/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.service;

import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;

/**
 *
 * @author ilisi
 */
public class ServiceLivre {
    public static boolean validate(Livre L){
        return L.getIsbn().length() >= 5;
    }
}
