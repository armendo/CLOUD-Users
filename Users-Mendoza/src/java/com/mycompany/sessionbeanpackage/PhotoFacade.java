/*
 * Created by Osman Balci on 2016.02.14  * 
 * Copyright © 2016 Osman Balci. All rights reserved. * 
 */
package com.mycompany.sessionbeanpackage;

import com.mycompany.entitypackage.Photo;
import java.util.List; // Added to the generated code
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Balci
 */
// PhotoFacade is an EJB style POJO (Plain Old Java Object) session bean, 
// which is annotated to be @Stateless.
@Stateless

public class PhotoFacade extends AbstractFacade<Photo> {

    @PersistenceContext(unitName = "Users-MendozaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhotoFacade() {
        super(Photo.class);
    }
    
    // The following findPhotosByUserID method is added to the generated code.
    
    public List<Photo> findPhotosByUserID(Integer userID) {
        return (List<Photo>) em.createNamedQuery("Photo.findPhotosByUserId")
                .setParameter("userId", userID)
                .getResultList();
    }

}