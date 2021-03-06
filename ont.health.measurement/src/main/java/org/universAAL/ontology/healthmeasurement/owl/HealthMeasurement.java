/*******************************************************************************
 * Copyright 2012 UPM, http://www.upm.es 
 Universidad PolitÃ©cnica de Madrid
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package org.universAAL.ontology.healthmeasurement.owl;

import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.ontology.phThing.Device;
import org.universAAL.ontology.profile.User;

public class HealthMeasurement extends ManagedIndividual {
	public static final String MY_URI = HealthMeasurementOntology.NAMESPACE + "HealthMeasurement";
	public static final String PROP_OBTAINED_BY = HealthMeasurementOntology.NAMESPACE + "obtainedFrom";
	public static final String PROP_MEASURED_FROM = HealthMeasurementOntology.NAMESPACE + "measuredBy";
	public static final String PROP_NAME = HealthMeasurementOntology.NAMESPACE + "name";
	public static final String PROP_DESCIPTION = HealthMeasurementOntology.NAMESPACE + "description";

	public HealthMeasurement() {
		super();
	}

	public HealthMeasurement(String uri) {
		super(uri);
	}

	public String getClassURI() {
		return MY_URI;
	}

	public int getPropSerializationType(String arg0) {
		return PROP_SERIALIZATION_FULL;
	}

	public boolean isWellFormed() {
		return true && hasProperty(PROP_OBTAINED_BY) && hasProperty(PROP_MEASURED_FROM);
	}

	public User getObtainedBy() {
		return (User) getProperty(PROP_OBTAINED_BY);
	}

	public void setObtainedBy(User newPropValue) {
		if (newPropValue != null)
			setProperty(PROP_OBTAINED_BY, newPropValue);
	}

	public String getName() {
		return (String) getProperty(PROP_NAME);
	}

	public void setName(String newPropValue) {
		if (newPropValue != null)
			setProperty(PROP_NAME, newPropValue);
	}

	public Device getMeasuredFrom() {
		return (Device) getProperty(PROP_MEASURED_FROM);
	}

	public void setMeasuredFrom(Device newPropValue) {
		if (newPropValue != null)
			setProperty(PROP_MEASURED_FROM, newPropValue);
	}

	public String getDescription() {
		return (String) getProperty(PROP_DESCIPTION);
	}

	public void setDescription(String newPropValue) {
		if (newPropValue != null)
			setProperty(PROP_DESCIPTION, newPropValue);
	}
}
