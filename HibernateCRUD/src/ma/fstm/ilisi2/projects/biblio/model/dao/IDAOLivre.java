/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.dao;

import java.util.Collection;
import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;

/**
 *
 * @author Dell
 */
public interface IDAOLivre {
    boolean create(Livre L);
    Collection<Livre> retrieve();
    boolean update(Livre L);
    boolean delete(Livre L);
}
