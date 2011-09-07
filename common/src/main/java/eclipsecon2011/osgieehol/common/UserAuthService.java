package eclipsecon2011.osgieehol.common;

/**
 * @author Sanjeeb.Sahoo@Sun.COM
 */
public interface UserAuthService
{
    boolean login(String name, String password);
    boolean register(String name, String password);
}
