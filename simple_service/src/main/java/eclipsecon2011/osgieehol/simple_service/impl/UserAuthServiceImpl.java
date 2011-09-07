package eclipsecon2011.osgieehol.simple_service.impl;

import eclipsecon2011.osgieehol.common.UserAuthService;

import java.rmi.activation.Activator;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author Sanjeeb.Sahoo@Sun.COM
 */
public class UserAuthServiceImpl implements UserAuthService {
    private Map<String, String> credentials = new HashMap<String, String>();

    public synchronized boolean login(String name, String password) {
    	
    	
        return credentials.containsKey(name) && credentials.get(name).equals(password);
        
        
        
    }

    public synchronized boolean register(String name, String password) {
        return !credentials.containsKey(name) && credentials.put(name, password) == null;
    }
}
