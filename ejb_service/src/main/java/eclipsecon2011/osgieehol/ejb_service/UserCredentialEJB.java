package eclipsecon2011.osgieehol.ejb_service;

import eclipsecon2011.osgieehol.common.UserAuthService;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserCredentialEJB
 */
@Stateless
@Local( { UserAuthService.class })
public class UserCredentialEJB implements UserAuthService {

	@PersistenceContext 
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserCredentialEJB() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see UserAuthService#register(String, String)
     */
    public boolean register(String name, String password) {
    	
        return true;
    }

	/**
     * @see UserAuthService#login(String, String)
     */
    public boolean login(String name, String password) {
    	UserCredential uc = em.find(UserCredential.class, name); 
        return uc != null && uc.getPassword().equals(password);
    }

}
