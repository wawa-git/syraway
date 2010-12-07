/**
 * 
 */
package com.assaassociates.syraway.core.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.assaassociates.syraway.core.entities.Collaborator;
import com.assaassociates.syraway.core.repositories.interfaces.ICollaboratorDAO;

/**
 * @author waheb
 *
 */
@Repository("CollaboratorDAO")
public class CollaboratorDAOImpl implements ICollaboratorDAO {

	@PersistenceContext
	protected EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.assaassociates.syraway.core.repositories.interfaces.ICollaboratorDAO#addCollaborator(java.lang.String, java.lang.String)
	 */
	public boolean addCollaborator(String pFirstName, String pLastName) {
		// TODO Auto-generated method stub
		Collaborator obj = new Collaborator();
		obj.setId("00001");
		obj.setFirstName(pFirstName);
		obj.setLastName(pLastName);
		//EntityTransaction tx = entityManager.getTransaction();
		//tx.begin();
		entityManager.persist(obj);
		//tx.commit();
		System.out.println("Does it exists ? " + entityManager.contains(obj));
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.assaassociates.syraway.core.repositories.interfaces.ICollaboratorDAO#getCollaborator(java.lang.String, int)
	 */
	public List<Collaborator> getCollaborator(String pFirstName, String pLastName) {
		
		Collaborator obj = new Collaborator();
		obj.setId("0001");
		obj.setFirstName(pFirstName);
		obj.setLastName(pLastName);
		//EntityTransaction tx = entityManager.getTransaction();
		//tx.begin();
		entityManager.contains(obj);
		//tx.commit();
		System.out.println("Does it exists ? " + entityManager.contains(obj));
		return new ArrayList<Collaborator>();
	}

}
