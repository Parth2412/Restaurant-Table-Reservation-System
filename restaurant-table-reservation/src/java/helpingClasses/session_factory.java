/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpingClasses;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author PARTH
 */
public class session_factory {
    static SessionFactory sfact;
    private static ServiceRegistry serviceRegistry;
    public static SessionFactory getSessionFact()
    {
        Configuration cfg=new Configuration();
        cfg.configure("/resources/hibernate.cfg.xml");
        serviceRegistry=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        sfact=cfg.buildSessionFactory(serviceRegistry);
        System.out.println("Build Session Factory----------");
        return sfact;    
    }
    
}
