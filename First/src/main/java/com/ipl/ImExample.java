package com.ipl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.ReferenceStrategy;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Reference;
import com.interfaces.InExample;

@Reference(name = "hello", bind = "bind", unbind = "unbind", cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, referenceInterface = InExample.class)
@Component(name = "hello-service", immediate = true)
@Service
public class ImExample implements InExample {

	public String getName() {
		// TODO Auto-generated method stub
		return "OSGI SERVICE UPPPPPPPP!!!!!!";
	}

	protected void bind(InExample in) {

	}

	protected void unbind(InExample in) {

	}
}
