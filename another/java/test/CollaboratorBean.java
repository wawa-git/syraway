package test;

public class CollaboratorBean {
	
	private ICollaboratorDAO dao = new CollaboratorDAOImp(); 
	
	
	public void getSomthing(){
		dao.getCollaboratorById("toto");
	}

}
