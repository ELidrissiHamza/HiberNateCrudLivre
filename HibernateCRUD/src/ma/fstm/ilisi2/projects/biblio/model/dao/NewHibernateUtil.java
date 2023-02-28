/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.fstm.ilisi2.projects.biblio.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author DELL
 */
public class NewHibernateUtil {

    	public static SessionFactory sessionFactory;

	public static SessionFactory getsessionFactory()
	{
		if(sessionFactory==null)
		{
			try { 
				 Configuration config = new Configuration();	
					config.configure(); 
					sessionFactory = config.buildSessionFactory(); 
				System.out.println("good");
			}
			catch(HibernateException e){System.out.println(e.getMessage());sessionFactory=null;}
		}
		
		return sessionFactory;
	}
}
