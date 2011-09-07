package eclipsecon2011.osgieehol.simple_client.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Sanjeeb.Sahoo@Sun.COM
 */
public class SimpleClientActivator implements BundleActivator {
    private BundleContext context;

    public void start(final BundleContext context) throws Exception {
        this.context = context;
        System.out.println("SimpleClientActivator started");

        // It is a bad idea to wait indefinitely in an activator, so we shall spawn a thread
        // to do the needful.
        new Thread(){
            @Override
            public void run() {
                ServiceLocator sl = new ServiceLocator(context);
                try {
                    sl.getUserAuthService(0).register("sun", "java");
                    sl.getUserAuthService(0).register("oracle", "fusion");
                    sl.getUserAuthService(0).register("ibm", "websphere");
                    System.out.println("Registered sun, oracle, ibm");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sl.close();
            }
        }.start();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("SimpleClientActivator stopped");
    }
}
