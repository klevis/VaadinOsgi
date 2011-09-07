package com.second;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;

import com.interfaces.InExample;

@Component(name = "hello-service2", immediate = true)
@Service
public class Second implements InExample {

	public String getName() {
		// TODO Auto-generated method stub
		return "Second is up baby";
	}

}
