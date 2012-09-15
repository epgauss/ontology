package org.universAAL.ontology;

import org.universAAL.middleware.container.ModuleContext;
import org.universAAL.middleware.container.uAALModuleActivator;
import org.universAAL.middleware.owl.OntologyManagement;
import org.universAAL.ontology.aalfficiency.scores.AalfficiencyScoresOntology;

public class AalfficiencyScoresActivator implements uAALModuleActivator{
	
    private AalfficiencyScoresOntology aalfficiency = new AalfficiencyScoresOntology();
	
	public void start(ModuleContext arg0) throws Exception {
		OntologyManagement.getInstance().register(aalfficiency);
	}

	public void stop(ModuleContext arg0) throws Exception {
		OntologyManagement.getInstance().unregister(aalfficiency);
	}
}
