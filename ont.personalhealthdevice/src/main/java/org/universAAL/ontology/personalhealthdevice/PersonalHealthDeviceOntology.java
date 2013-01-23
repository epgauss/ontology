package org.universAAL.ontology.personalhealthdevice;

import org.universAAL.middleware.owl.MergedRestriction;
import org.universAAL.middleware.owl.OntClassInfoSetup;
import org.universAAL.middleware.owl.Ontology;
import org.universAAL.middleware.rdf.Resource;
import org.universAAL.ontology.PersonalHealthDeviceFactory;
import org.universAAL.ontology.measurement.Measurement;
import org.universAAL.ontology.measurement.MeasurementOntology;
import org.universAAL.ontology.phThing.Device;

/**
 * The ontology represents the person-related health devices (Continua certified devices)
 * e.g. blood pressure monitor, weighing scale,...
 * 
 * @author Thomas Fuxreiter (foex@gmx.at)
 */
public class PersonalHealthDeviceOntology extends Ontology{

    private static PersonalHealthDeviceFactory factory = new PersonalHealthDeviceFactory();

    public static final String NAMESPACE = Resource.uAAL_NAMESPACE_PREFIX
    + "PersonalHealthDevice.owl#";
    

    public PersonalHealthDeviceOntology() {
		super(NAMESPACE);
	}

	public void create() {
		Resource r = getInfo();
		r.setResourceComment("Ontology for person-related health devices (Continua certified devices) " +
			"e.g. blood pressure monitor, weighing scale,...");
		r.setResourceLabel("PersonalHealthDevice");
		addImport(MeasurementOntology.NAMESPACE);
		
		OntClassInfoSetup oci;

		// load BloodPressureMeasurement
		oci = createNewOntClassInfo(BloodPressureMeasurement.MY_URI, factory, 0);
		oci.setResourceComment("Measurement class for blood pressure monitors.");
		oci.setResourceLabel("BloodPressureMeasurement");
		oci.addSuperClass(Device.MY_URI);
		oci.addObjectProperty(BloodPressureMeasurement.PROP_HAS_MEASURED_BPSYS).setFunctional();
		oci.addObjectProperty(BloodPressureMeasurement.PROP_HAS_MEASURED_BPDIA).setFunctional();
		oci.addObjectProperty(BloodPressureMeasurement.PROP_HAS_MEASURED_HEARTRATE).setFunctional();
		oci.addRestriction(MergedRestriction
				.getAllValuesRestrictionWithCardinality(
						BloodPressureMeasurement.PROP_HAS_MEASURED_BPSYS, Measurement.MY_URI, 1, 1));
		oci.addRestriction(MergedRestriction
				.getAllValuesRestrictionWithCardinality(
						BloodPressureMeasurement.PROP_HAS_MEASURED_BPDIA, Measurement.MY_URI, 1, 1));
		oci.addRestriction(MergedRestriction
				.getAllValuesRestrictionWithCardinality(
						BloodPressureMeasurement.PROP_HAS_MEASURED_HEARTRATE, Measurement.MY_URI, 0, 1));

		// load BloodPressureMonitor
		oci = createNewOntClassInfo(BloodPressureMonitor.MY_URI, factory, 1);
		oci.setResourceComment("The class of all blood pressure monitors.");
		oci.setResourceLabel("BloodPressureMonitor");
		oci.addSuperClass(Device.MY_URI);
		oci.addObjectProperty(BloodPressureMonitor.PROP_HAS_MEASUREMENT).setFunctional();
		oci.addRestriction(MergedRestriction
				.getAllValuesRestrictionWithCardinality(
						BloodPressureMonitor.PROP_HAS_MEASUREMENT, BloodPressureMeasurement.MY_URI, 1, 1));

		
		// load WeighingScale
		oci = createNewOntClassInfo(WeighingScale.MY_URI, factory, 2);
		oci.setResourceComment("The class of all weighing scales.");
		oci.setResourceLabel("WeighingScale");
		oci.addSuperClass(Device.MY_URI);
		oci.addObjectProperty(WeighingScale.PROP_HAS_MEASURED_WEIGHT).setFunctional();
		oci.addRestriction(MergedRestriction
				.getAllValuesRestrictionWithCardinality(
						WeighingScale.PROP_HAS_MEASURED_WEIGHT, Measurement.MY_URI, 1, 1));
		
	}

}