package com.michael;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args ){
    	StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory= meta.getSessionFactoryBuilder().build();
    	Session session=factory.openSession();
    	Transaction t1= session.beginTransaction(); 
    	Department d =new Department("Mechanical");
    	session.save(d);
    	t1.commit();

    	//fetch the department from db first time 
    	Department d1= session.load(Department.class, new Integer(1));
    	System.out.println(d1.getDeptName());
    	
    	//fetch the department again with a new session 2
    	Session session2= factory.openSession();
    	Department d2= session2.load(Department.class, new Integer(1));
    	System.out.println(d2.getDeptName());
   
    	//fetch the department again with a new session 3
     	Session session3= factory.openSession();
    	Department d3= session3.load(Department.class, new Integer(1));
    	System.out.println(d3.getDeptName());
    	
    	session.close();session2.close();session3.close();
    }
}
