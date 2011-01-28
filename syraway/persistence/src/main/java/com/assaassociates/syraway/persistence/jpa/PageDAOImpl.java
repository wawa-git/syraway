/**
 * 
 */
package com.assaassociates.syraway.persistence.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.assaassociates.syraway.dao.IPageDAO;
import com.assaassociates.syraway.model.Page;

/**
 * @author waheb
 *
 */

@Repository(value="PageDAO")
public class PageDAOImpl implements IPageDAO {

	@PersistenceContext
	EntityManager oEntityManager;
	
	static Logger logger = LoggerFactory.getLogger(PageDAOImpl.class);

	@PostConstruct
	void initLogging(){
		logger.info("PageDAOImpl Instanciated ...");
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public Page getPageById(Integer pPageId) {
		if(oEntityManager != null){
			return oEntityManager.find(Page.class, pPageId);
		}
		logger.info("EntityManager is null ... Cant't get Page by Id");
		return null;
	}

	@Transactional(isolation=Isolation.DEFAULT)
	public void addPage(Page pPage) {
		if(oEntityManager != null){
			oEntityManager.persist(pPage);
		}else
			logger.info("EntityManager is null ... Cant't add Page.");
	}
	
	@Transactional(isolation=Isolation.DEFAULT)
	public void updatePage(Page pPage) {
		if(oEntityManager != null){
			oEntityManager.merge(pPage);
		}else
			logger.info("EntityManager is null ... Cant't add Page.");
	}

	@Transactional(isolation=Isolation.DEFAULT)
	public void removePage(Page pPage) {
		if(oEntityManager != null){
			oEntityManager.remove(pPage);
		}else
			logger.info("EntityManager is null ... Cant't remove Page.");
	}

	@Transactional(isolation=Isolation.DEFAULT)
	public void removePage(Integer pPageId) {
		if(oEntityManager != null){
			Page oPage = getPageById(pPageId);
			if(oPage != null){
				oEntityManager.remove(oPage);
			}
		}else
			logger.info("EntityManager is null ... Cant't remove Page.");
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public List<Page> getAllPages() {
		if(oEntityManager != null){
			TypedQuery<Page> oQuery = oEntityManager.createQuery("SELECT r FROM Page As r",Page.class);
//			oQuery.setParameter("pEmployeeId", pEmployeeId);
			return oQuery.getResultList();
		}
		logger.info("EntityManager is null ... Can't get all Page");
		return new ArrayList<Page>();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	public Page getPageByUri(String pPageUri) {
		if(oEntityManager != null){
			TypedQuery<Page> oQuery = oEntityManager.createQuery("SELECT p FROM Page As p WHERE p.uri = :pageUri",Page.class);
			oQuery.setParameter("pageUri", pPageUri);
			try{
				return oQuery.getSingleResult();
			}catch(NoResultException e){
				//TODO:SOME LOGERROR
				return null;
			}
		}
		logger.info("EntityManager is null ... Can't get all Page");
		return null;
	}
}