/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.controler;

import java.util.Collection;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;
import ma.fstm.ilisi2.projects.biblio.model.dao.DAOLivre;
import ma.fstm.ilisi2.projects.biblio.model.service.ServiceLivre;
import oracle.net.ano.Service;

/**
 *
 * @author Dell
 */
public class Bibliotheque {
    public static void ajouterLivre(String isbn,String titre){
        Livre L=new Livre(isbn,titre);
        if(ServiceLivre.validate(L))
        new DAOLivre().create(L);
    };
    
    public static void SupprimerLivre(String isbn,String titre){
        new DAOLivre().delete(new Livre(isbn,titre));
    };
    
    public static void  getAllLivres(JTable j){
        DAOLivre dao = new DAOLivre();
        Vector<Livre> listLivres=(Vector<Livre>) dao.retrieve();
        Vector<Vector<Livre>> matrice=new Vector<Vector<Livre>>();
        Vector<String> header=new Vector<String>();
        header.add("ISBN");
        header.add("Titre");
        for(Livre l:listLivres)
        {
            Vector v=new Vector();
            v.add(l.getIsbn());
            v.add(l.getTitre());
            matrice.add(v);
        }
        j.setModel(new javax.swing.table.DefaultTableModel(matrice,header));
    };
    
    public static void ModifierLivre(String isbn,String titre){
        new DAOLivre().update(new Livre(isbn,titre));
    };
    public static void setFormInputs(String isbn,JTextField field1,JTextField field2){
          DAOLivre dao = new DAOLivre();
         
    
           Livre   livre  =dao.findByIsbn(isbn);
           if(livre!=null){
               field1.setText(livre.getIsbn());
               field2.setText(livre.getTitre());
           }
    }
}
