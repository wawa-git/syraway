/**
 * 
 */
package test;

import java.util.Set;

import test.Collaborator;

/**
 * @author waheb
 *
 */
public interface ICollaboratorDAO {
	
	public String getCollaboratorNameById(String pId);
	public Set<Collaborator> getCollaboratorsByName(String pName);
	public Collaborator getCollaboratorById(String pId);
	
}
