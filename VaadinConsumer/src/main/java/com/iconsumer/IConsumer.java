package com.iconsumer;

import java.util.List;

import com.interfaces.InExample;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public interface IConsumer {
	public abstract com.vaadin.ui.Component getComp();

	public abstract void setComp(com.vaadin.ui.Component comp);

	public abstract Window getMainWindow();

	public abstract void setMainWindow(Window mainWindow);
	
List<InExample>	getList(); 


Component getMe();
}
