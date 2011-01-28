package com.assaassosiates.syraway.security.access.vote;

import java.util.Collection;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import com.assaassosiates.syraway.security.SywApplicationContext;
import com.assaassosiates.syraway.security.authentication.UserProfile;

public class SywRoleVoter implements AccessDecisionVoter {

	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	public int vote(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes) {
		int result = ACCESS_ABSTAIN;
		if(object instanceof FilterInvocation){
			ApplicationContext ctx = SywApplicationContext.getCtx();
			UserProfile profile = ctx.getBean("userProfile", UserProfile.class);
            if(ctx != null && profile!=null){
            	String pageUri = ((FilterInvocation) object).getRequestUrl();
            	if(profile.isAuthorizedUri(pageUri)){
            		result = ACCESS_GRANTED;
            	}
            }
		}
            
        return result;
    }
}
