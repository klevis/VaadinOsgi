package eclipsecon2011.osgieehol.ejb_service;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserCredential
 *
 */
@Entity

public class UserCredential implements Serializable {

	   
	@Id
	private String name;
	private String password;
	private static final long serialVersionUID = 1L;

	public UserCredential() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
