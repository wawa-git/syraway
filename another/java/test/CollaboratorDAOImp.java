/**
 * 
 */
package test;

import java.util.Set;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import test.ICollaboratorDAO;
import test.Collaborator;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author waheb
 *
 */

public class CollaboratorDAOImp extends JpaDaoSupport implements ICollaboratorDAO {


	/* (non-Javadoc)
	 * @see com.assaassociates.syraway.dao.ICollaborator#getCollaboratorNameById(java.lang.String)
	 */
	public String getCollaboratorNameById(String pId) {
		// TODO Auto-generated method stub
		Collaborator oCollaborator = new Collaborator();
		oCollaborator.setId("toto");
		oCollaborator.setFirstName("test");
		oCollaborator.setLastName("test");
		
		Collaborator oColl = getJpaTemplate().find(Collaborator.class,oCollaborator);
		if(oColl == null){
			System.out.println("doesn't exist");
			persist(oCollaborator);
		}
		else System.out.println("existe");
		return null;
	}
	
	@Transactional
	private void persist(Collaborator oParam){
		getJpaTemplate().persist(oParam);
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
