package com.consumer;

import java.util.ArrayList;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Service;

import com.iconsumer.IConsumer;
import com.interfaces.InExample;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;


@Component(name="consumer",immediate=true,label="klevis")
@Reference(bind="bind",unbind="unbind",name="consumer",referenceInterface=InExample.class,cardinality=ReferenceCardinality.OPTIONAL_MULTIPLE)
@Service
public class Consumer extends Panel implements IConsumer{

private Window mainWindow;
private com.vaadin.ui.Component comp;
	
	private List< InExample> list=new ArrayList<InExample>();
	private Button buton1=new Button("1");
	private Button button = new Button("2"); 

protected void bind(InExample inExample){
	
	
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<---Start bundle "+ inExample.getName() +"::: "+mainWindow+"........."+getComp());
	getList().add(inExample);



this.addComponent(buton1);
	this.addComponent(button);
}

protected void unbind (InExample inExample){
	if(getComp()!=null)
getMainWindow().removeComponent(getComp());
	
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<---Stop bundle ______------"+inExample.getName());

	if(getMainWindow()!=null)
getMainWindow().showNotification("ok un bind");
this.removeComponent(buton1);
this.removeComponent(button);
}

public List< InExample> getList() { 
	return list;
}

public void setList(ArrayList< InExample> list) {
	this.list = list;
}

/* (non-Javadoc)
 * @see com.consumer.IConsumer#getComp()
 */
public com.vaadin.ui.Component getComp() {
	return comp;
}

/* (non-Javadoc)
 * @see com.consumer.IConsumer#setComp(com.vaadin.ui.Component)
 */
public void setComp(com.vaadin.ui.Component comp) {
	this.comp = comp;
}

/* (non-Javadoc)
 * @see com.consumer.IConsumer#getMainWindow()
 */
public Window getMainWindow() {
	return mainWindow;
}

/* (non-Javadoc)
 * @see com.consumer.IConsumer#setMainWindow(com.vaadin.ui.Window)
 */
public void setMainWindow(Window mainWindow) {
	this.mainWindow = mainWindow;
}

public com.vaadin.ui.Component getMe() {
	// TODO Auto-generated method stub
	return this;
}



}
