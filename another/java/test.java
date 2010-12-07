import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.CollaboratorBean;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-another.xml");
        CollaboratorBean bean = appContext.getBean("CollaboratorBean", CollaboratorBean.class);
 
        System.out.println("before");
        bean.getSomthing();
        System.out.println("after");
    }

}
