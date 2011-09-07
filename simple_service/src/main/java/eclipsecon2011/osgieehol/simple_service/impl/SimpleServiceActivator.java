package eclipsecon2011.osgieehol.simple_service.impl;

import java.util.ArrayList;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

import eclipsecon2011.osgieehol.common.UserAuthService;

/**
 * @author Sanjeeb.Sahoo@Sun.COM
 */
public class SimpleServiceActivator implements BundleActivator, SynchronousBundleListener {

	private static Bundle[] bundles;

	public static synchronized Bundle[] getBundles() {
		return bundles;
	}

	public void start(BundleContext context) throws Exception {
		context.registerService(UserAuthService.class.getName(),
				new UserAuthServiceImpl(), null);
		System.out.println("SimpleServiceActivator started");
		Bundle[] allBundles = context.getBundles();
		ArrayList<Bundle> bundleList = new ArrayList<Bundle>();

		// Hack for adding only our relevant bundles to the list
		for (Bundle bundle : allBundles) {
			
				bundleList.add(bundle);
			
			
		}
		bundles = bundleList.toArray(new Bundle[] {});
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("SimpleServiceActivator stopped");
	}

	@Override
	public void bundleChanged(BundleEvent event) {
		// TODO Auto-generated method stub
		
		System.out.println("change");
		
	}
}
