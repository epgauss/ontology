/*******************************************************************************
 * Copyright 2012 UPM, http://www.upm.es - Universidad Politécnica de Madrid
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

package org.universAAL.ontology.health.owl;

public class SystolicBloodPressureRequirement extends BloodPressureRequirement {

    public static final String MY_URI = HealthProfileOntology.NAMESPACE
	    + "SystolicBloodPressureRequirement";
    public static final String PROP_SYSTOLIC_PRESSURE_MIN_VALUE_ALLOWED = HealthProfileOntology.NAMESPACE
	    + "systolicPressureMinValueAllowed";
    public static final String PROP_SYSTOLIC_PRESSURE_MAX_VALUE_ALLOWED = HealthProfileOntology.NAMESPACE
	    + "systolicPressureMaxValueAllowed";

    public SystolicBloodPressureRequirement() {
	super();
    }

    public SystolicBloodPressureRequirement(String uri) {
	super(uri);
    }

    public SystolicBloodPressureRequirement(int minPressureAllowed,
	    int maxPressureAllowed) {
    }

    public String getClassURI() {
	return MY_URI;
    }

    public int getPropSerializationType(String arg0) {
	return PROP_SERIALIZATION_FULL;
    }

    public boolean isWellFormed() {
	return true
		&& props.containsKey(PROP_SYSTOLIC_PRESSURE_MIN_VALUE_ALLOWED)
		&& props.containsKey(PROP_SYSTOLIC_PRESSURE_MAX_VALUE_ALLOWED);
    }

}