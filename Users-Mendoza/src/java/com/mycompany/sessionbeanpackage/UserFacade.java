/*
 * Created by Osman Balci on 2016.02.14  * 
 * Copyright © 2016 Osman Balci. All rights reserved. * 
 */
package com.mycompany.sessionbeanpackage;

import com.mycompany.entitypackage.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balci
 */
// UserFacade is an EJB style POJO (Plain Old Java Object) session bean, 
// which is annotated to be @Stateless.
@Stateless

public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "Users-MendozaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    //-----------------------------------------------------
    //The following methods are added to the generated code
    //-----------------------------------------------------
    
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    public User findByUsername(String username) {
        if (em.createQuery("SELECT u FROM User u WHERE u.username = :uname")
                .setParameter("uname", username)
                .getResultList().isEmpty()) {
            return null;
        }
        else {
            return (User) (em.createQuery("SELECT u FROM User u WHERE u.username = :uname")
                .setParameter("uname", username)
                .getSingleResult());        
        }
    }
    
    public void deleteUser(int id){
        
        User user = em.find(User.class, id);
        em.remove(user);
    }

}