/**
 * 
 */
package com.assaassociates.syraway.core.repositories.interfaces;

import java.util.List;

import com.assaassociates.syraway.core.entities.Collaborator;

/**
 * @author waheb
 *
 */
public interface ICollaboratorDAO {

	
	static enum name {FIRST_NAME, LAST_NAME};
	
	public boolean addCollaborator(String pFirstName, String pLastName);
	
	public List<Collaborator> getCollaborator(String pFirstName, String pLastName );

}
