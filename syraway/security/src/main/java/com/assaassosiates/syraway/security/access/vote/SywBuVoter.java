/**
 * 
 */
package com.assaassosiates.syraway.security.access.vote;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

/**
 * @author waheb
 *
 */
public class SywBuVoter implements AccessDecisionVoter {

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionVoter#supports(org.springframework.security.access.ConfigAttribute)
	 */
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		// TODO the voter is invoked only if this function return true. We can check some BU parameters...
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionVoter#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionVoter#vote(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
	 */
	public int vote(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes) {
		return ACCESS_ABSTAIN;
	}

}
