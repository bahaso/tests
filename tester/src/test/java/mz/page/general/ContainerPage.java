package mz.page.general;

import java.util.Map;

public abstract class ContainerPage{
	
	//The container of feature elements.
	protected Map<Class, Object> containers;
	
	//Get the container by Class
	protected Object getContainer(Class containerClass) {
		return this.containers.get(containerClass);
	}

	//Insert container to the list
	protected Object insertContainer(Object container) {
		return this.containers.put(container.getClass(), container);
	}

	//Remove the container from the list
	protected void removeContainer(Class containerClass) {
		this.containers.remove(containerClass);
	}
}
