package agenda.rest;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import agenda.api.Agenda;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager) throws Exception {

		manager.add(
			createComponent()
			.setInterface(Object.class.getName(), null)
			.setImplementation(AgendaRest.class)
			.add(
				createServiceDependency()
				.setService(Agenda.class)
				.setRequired(true)
			)
		);
	}

}
