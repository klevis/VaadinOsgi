package eclipsecon2011.osgieehol.simple_client.impl;

import eclipsecon2011.osgieehol.common.UserAuthService;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Sanjeeb.Sahoo@Sun.COM
 */
public class ServiceLocator {
    private ServiceTracker st;

    public ServiceLocator(BundleContext context) {
        st = new ServiceTracker(context, UserAuthService.class.getName(), null);
        st.open();
    }

    /**
     * Looks up a service and returns
     * @param timeout
     * @return
     */
    public UserAuthService getUserAuthService(long timeout) throws ServiceUnavailableException {
        UserAuthService service = null;
        try {
            service = UserAuthService.class.cast(timeout == -1 ? st.getService() : st.waitForService(timeout));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (service == null) throw new ServiceUnavailableException();
        return service;
    }

    public void close() {
        st.close();
    }

    public static class ServiceUnavailableException extends Exception {
    }
}
