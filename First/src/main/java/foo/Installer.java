package foo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
/**
 *
 * @author nb
 */
public class Installer implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        String userName = context.getProperty("user.name");
        System.out.println("Maven Hello Service: Started OSGi bundle");
        System.out.println("User Name: " + userName);
    }

  

	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}