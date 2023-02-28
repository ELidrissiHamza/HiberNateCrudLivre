/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class DAOLivre implements IDAOLivre {
    public DAOLivre() {
    }

    
    @Override
    public boolean create(Livre L) {
        Transaction tx = null;
			Session session=null ;
	        try {
	            session=NewHibernateUtil.getsessionFactory().getCurrentSession();
	            
	            	// System.out.println("yes");
	            	// session=Fabricsession.getsessionFactory().openSession();
  
	             tx = session.beginTransaction();
	             session.save(L);
	             tx.commit();
	             System.out.println("commited");
	            
	            return true;
	        } catch (HibernateException e) {
	            tx.rollback();  
	            System.out.println("c'esl la");
	        	            return false;

	        }
    }

    @Override
    public Collection<Livre> retrieve() {
        Vector<Livre> livres=null;
       Transaction tx = null;
			Session session=null ;
	        try {
	            session=NewHibernateUtil.getsessionFactory().getCurrentSession();
	            
	            	// System.out.println("yes");
	            	// session=Fabricsession.getsessionFactory().openSession();
  
	             tx = session.beginTransaction();
	             livres=new Vector<Livre>(session.createQuery("from Livre").list());
	             tx.commit();
	             System.out.println("commited");
	            
	            return livres;
	        } catch (HibernateException e) {
	            tx.rollback();  
	            System.out.println("c'esl la");
	        	            return livres;

	        }
        
    }

    @Override
    public boolean update(Livre L) {
       Transaction tx = null;
			Session session=null ;
	        try {
	            session=NewHibernateUtil.getsessionFactory().getCurrentSession();
	            
	            	// System.out.println("yes");
	            	// session=Fabricsession.getsessionFactory().openSession();
  
	             tx = session.beginTransaction();
	             session.update(L);
	             tx.commit();
	             System.out.println("commited");
	            
	            return true;
	        } catch (HibernateException e) {
	            tx.rollback();  
	            System.out.println("c'esl la");
	        	            return false;

	        }
    }

    @Override
    public boolean delete(Livre L) {
        Transaction tx = null;
			Session session=null ;
	        try {
	            session=NewHibernateUtil.getsessionFactory().getCurrentSession();
	            
	            	// System.out.println("yes");
	            	// session=Fabricsession.getsessionFactory().openSession();
  
	             tx = session.beginTransaction();
	             session.delete(L);
	             tx.commit();
	             System.out.println("commited");
	            
	            return true;
	        } catch (HibernateException e) {
	            tx.rollback();  
	            System.out.println("c'esl la");
	        	            return false;

	        }
    }
    public Livre findByIsbn(String isbn){
       
        Livre livre =null;
         try
         { 
             
              PreparedStatement st = Connexion.getConnexion().prepareStatement("select * from  LIVRE WHERE ISBN = ? ");
              st.setString(1,isbn);
              ResultSet rs = st.executeQuery();
              
                 

                rs.next();
                System.out.println(rs.getString("titre"));
                livre=new Livre(rs.getString("ISBN"),rs.getString("titre"));
                System.out.println(livre.getTitre());
                return livre;
              
         }
         catch(SQLException e)
         {
             return null;
         }
    }
}
