/**
 * 
 */
package com.assaassociates.syraway.dao.jpa;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.assaassociates.syraway.dao.ICollaboratorDAO;
import com.assaassociates.syraway.model.Collaborator;

/**
 * @author waheb
 *
 */


@Repository(value="CollaboratorDAO")
public class CollaboratorDAOImpl implements ICollaboratorDAO {

	@PersistenceContext
	EntityManager oEntityManager;
	
	private EntityManagerFactory emf;
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/* (non-Javadoc)
	 * @see com.assaassociates.syraway.dao.ICollaborator#getCollaboratorNameById(java.lang.String)
	 */
	public String getCollaboratorNameById(String pId) {
		// TODO Auto-generated method stub
		Collaborator oCollaborator = new Collaborator();
		oCollaborator.setId("toto");
		oCollaborator.setFirstName("test");
		oCollaborator.setLastName("test");
		if(oEntityManager == null)
			System.out.println("oEntityManager ...");
		if(emf == null)
			System.out.println("oEntityManagerFactory ...");
		
//		EntityTransaction tx = oEntityManager.getTransaction();
//		tx.begin();
//		System.out.println("begin trans");
//		if(!oEntityManager.contains(oCollaborator))
//			oEntityManager.persist(oCollaborator);
//		tx.commit();
		System.out.println("trans commited");
		return null;
	}

	/* (non-Javadoc)
	 * @see com.assaassociates.syraway.dao.ICollaborator#getCollaboratorsByName(java.lang.String)
	 */
	public Set<Collaborator> getCollaboratorsByName(String pName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.assaassociates.syraway.dao.ICollaborator#getCollaboratorById(java.lang.String)
	 */
	public Collaborator getCollaboratorById(String pId) {
		// TODO Auto-generated method stub
		return null;
	}

}
