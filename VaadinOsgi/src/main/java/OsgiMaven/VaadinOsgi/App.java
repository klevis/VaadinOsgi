package OsgiMaven.VaadinOsgi;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.glassfish.osgicdi.OSGiService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import com.consumer.Consumer;
import com.iconsumer.IConsumer;
import com.interfaces.InExample;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

import eclipsecon2011.osgieehol.simple_service.impl.SimpleServiceActivator;

public class App extends Application {
	InExample inExample;
	private IConsumer consumer;
	private Window mainWindow;
	private Button start;
	private CheckBox checkbox;
	private CheckBox checkbox2;
	private Button button2;
	private Button button1;

	public App(InExample inExample) {
		// TODO Auto-generated constructor stub
		this.inExample = inExample;
	}

	@WebServlet(name = "WebSecond", urlPatterns = "/*")
	public static class Servlet extends AbstractApplicationServlet {
		// @Inject @OSGiService(dynamic=true)
		// private UserAuthService uas;

		@Inject
		@OSGiService(dynamic = true)
		IConsumer consumer1;

		@Override
		protected Class<? extends Application> getApplicationClass() {
			return App.class;
		}

		@Override
		protected Application getNewApplication(HttpServletRequest request)
				throws ServletException {
			// System.err.println(uas.login("klevis", "ramo"));
			App app = new App(null);
			app.setConsumer(consumer1);
			// app.setUasP(uas);
			return app;
		}
	}

	@Override
	public void init() {

		// consumer.setMainWindow(mainWindow);
		// Label label = new Label("Greetings, Vaadin user!!!!!!!!!>>>>>>>>>"
		// + inExample.getName());
		// mainWindow.addComponent(label);
		// IConsumer consumer2 = getConsumer();
		// List<InExample> list = consumer2.getList();
		// mainWindow.showNotification("size" + list.size());
		// for (InExample inExample : list) {
		// mainWindow.addComponent(new Button(inExample.getName()));
		// }
		mainWindow = new Window();

		start = new Button("Start bundles");
		checkbox = new CheckBox("Second");
		checkbox2 = new CheckBox("First");
		initComand();
		button1 = new Button("1");
		button2 = new Button("2");
		mainWindow.addComponent(button1);
		mainWindow.addComponent(button2);
		mainWindow.addComponent(consumer.getMe());
		checkbox.setImmediate(true);
		initConsumer();
		checkbox.addListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				Bundle[] bundles = SimpleServiceActivator.getBundles();
				for (int i = 0; i < bundles.length; i++) {

					if (bundles[i].getSymbolicName().equals("OsgiMaven.Second")) {
					
						try {
							bundles[i].stop();
						} catch (BundleException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}

			}
		});
		// checkbox2.addListener(listener);

		start.addListener(new Button.ClickListener() {

			private int starting;

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Bundle[] bundles = SimpleServiceActivator.getBundles();
				for (int i = 0; i < bundles.length; i++) {
					try {
						if (bundles[i].getSymbolicName().equals(
								"OsgiMaven.Second")) {

							bundles[i].start();
                             starting = Bundle.STARTING;
						}
						if (bundles[i].getSymbolicName().equals(
								"OsgiMaven.First")) {

							bundles[i].start();

						}
						
						

					}

					catch (BundleException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}

				}
				
				 update();

			}
		});

		setMainWindow(mainWindow);

	}

	private void initConsumer() {
		consumer.setMainWindow(mainWindow);
		consumer.setComp(button1);
	}

	private void initComand() {
		mainWindow.addComponent(start);
		mainWindow.addComponent(checkbox2);
		mainWindow.addComponent(checkbox);

	}

	public IConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(IConsumer consumer) {
		this.consumer = consumer;
	}

	public void update() {
		// mainWindow.removeAllComponents();


		Bundle[] bundles = SimpleServiceActivator.getBundles();
		for (int i = 0; i < bundles.length; i++) {
			if (bundles[i].getSymbolicName().equals("OsgiMaven.Second")) {

			}
			if (bundles[i].getSymbolicName().equals("VaadinOsgi.VaadinConsumer")) {

             mainWindow.showNotification("Update OK");
			 	try {
				bundles[i].update();	
			 	} catch (BundleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}