package org.universAAL.ontology;

import org.universAAL.middleware.owl.Intersection;
import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.middleware.owl.MergedRestriction;
import org.universAAL.middleware.owl.OntClassInfoSetup;
import org.universAAL.middleware.owl.Ontology;
import org.universAAL.middleware.rdf.Resource;
import org.universAAL.middleware.service.owl.Service;
import org.universAAL.ontology.activityhub.*;
import org.universAAL.ontology.activityhub.ext.*;
import org.universAAL.ontology.phThing.Actuator;
import org.universAAL.ontology.phThing.Sensor;

/**
 * The ontology represents the sensors specified in ISO 11073 - Part 10471
 * (Indepentend living activity hub)
 * 
 * @author Thomas Fuxreiter
 */
public class ActivityHubOntology extends Ontology{

    public static final String NAMESPACE = Resource.uAAL_NAMESPACE_PREFIX
    + "ActivityHub.owl#";

	private static ActivityHubFactory factory = new ActivityHubFactory();
    
	public ActivityHubOntology() {
		super(NAMESPACE);
	}

	public void create() {
		Resource r = getInfo();
		r.setResourceComment("Ontology for sensors specified in " +
			"ISO 11073 - Part 10471 (Indepentend living activity hub)");
		r.setResourceLabel("ActivityHubSensor");
		r.serializesAsXMLLiteral();

		OntClassInfoSetup oci;


	/*** Sensors ***/

		/* FallSensor */
		/* create ontology resource for FallSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(FallSensorEvent.MY_URI);
		oci.setResourceLabel("FallSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 fall sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				FallSensorEvent.fall_detected, 
				FallSensorEvent.no_condition_detected } );

		/* create ontology resource for FallSensor */
		oci = createNewOntClassInfo(FallSensor.MY_URI,factory, 1);
		oci.setResourceLabel("FallSensor");
		oci.setResourceComment("ISO 11073-10471 fall sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type FallSensorEvent */
		oci.addObjectProperty(FallSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				Sensor.PROP_MEASURED_VALUE, FallSensorEvent.MY_URI));

		
		/* PersSensor */
		/* create ontology resource for PersSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(PersSensorEvent.MY_URI);
		oci.setResourceLabel("PersSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 PERS sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				PersSensorEvent.pers_activated, 
				PersSensorEvent.no_condition_detected } );
		
		/* create ontology resource for PersSensor */
		oci = createNewOntClassInfo(PersSensor.MY_URI,factory, 2);
		oci.setResourceLabel("PersSensor");
		oci.setResourceComment("ISO 11073-10471 PERS sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type PersSensorEvent */
		oci.addObjectProperty(PersSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				PersSensor.PROP_MEASURED_VALUE, PersSensorEvent.MY_URI));
		
		
		/* SmokeSensor */
		/* create ontology resource for SmokeSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(EnvironmentalSensorEvent.MY_URI);
		oci.setResourceLabel("SmokeSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 environmental sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				EnvironmentalSensorEvent.condition_detected, 
				EnvironmentalSensorEvent.no_condition_detected } );

		/* create ontology resource for SmokeSensor */
		oci = createNewOntClassInfo(SmokeSensor.MY_URI,factory, 3);
		oci.setResourceLabel("SmokeSensor");
		oci.setResourceComment("ISO 11073-10471 smoke sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type SmokeSensorEvent */
		oci.addObjectProperty(SmokeSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				SmokeSensor.PROP_MEASURED_VALUE, EnvironmentalSensorEvent.MY_URI));
		

		/* CoSensor */
		/* create ontology resource for CoSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(EnvironmentalSensorEvent.MY_URI);
		oci.setResourceLabel("CoSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 environmental sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				EnvironmentalSensorEvent.condition_detected, 
				EnvironmentalSensorEvent.no_condition_detected } );

		/* create ontology resource for CoSensor */
		oci = createNewOntClassInfo(CoSensor.MY_URI,factory, 4);
		oci.setResourceLabel("CoSensor");
		oci.setResourceComment("ISO 11073-10471 CO sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type CoSensorEvent */
		oci.addObjectProperty(CoSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				CoSensor.PROP_MEASURED_VALUE, EnvironmentalSensorEvent.MY_URI));
		
		
		/* WaterSensor */
		/* create ontology resource for WaterSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(EnvironmentalSensorEvent.MY_URI);
		oci.setResourceLabel("WaterSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 environmental sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				EnvironmentalSensorEvent.condition_detected, 
				EnvironmentalSensorEvent.no_condition_detected } );

		/* create ontology resource for WaterSensor */
		oci = createNewOntClassInfo(WaterSensor.MY_URI,factory, 5);
		oci.setResourceLabel("WaterSensor");
		oci.setResourceComment("ISO 11073-10471 smoke sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type WaterSensorEvent */
		oci.addObjectProperty(WaterSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				WaterSensor.PROP_MEASURED_VALUE, EnvironmentalSensorEvent.MY_URI));
		
		
		/* GasSensor */
		/* create ontology resource for GasSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(EnvironmentalSensorEvent.MY_URI);
		oci.setResourceLabel("GasSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 environmental sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				EnvironmentalSensorEvent.condition_detected, 
				EnvironmentalSensorEvent.no_condition_detected } );
		
		/* create ontology resource for GasSensor */
		oci = createNewOntClassInfo(GasSensor.MY_URI,factory, 6);
		oci.setResourceLabel("GasSensor");
		oci.setResourceComment("ISO 11073-10471 smoke sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type GasSensorEvent */
		oci.addObjectProperty(GasSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				GasSensor.PROP_MEASURED_VALUE, EnvironmentalSensorEvent.MY_URI));
		
		
		/* MotionSensor */
		/* create ontology resource for MotionSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(MotionSensorEvent.MY_URI);
		oci.setResourceLabel("MotionSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 motion sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				MotionSensorEvent.motion_detected, 
				MotionSensorEvent.motion_detected_delayed,
				MotionSensorEvent.tamper_detected,
				MotionSensorEvent.no_condition_detected } );

		/* create ontology resource for MotionSensor */
		oci = createNewOntClassInfo(MotionSensor.MY_URI,factory, 7);
		oci.setResourceLabel("MotionSensor");
		oci.setResourceComment("ISO 11073-10471 motion sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type MotionSensorEvent */
		oci.addObjectProperty(MotionSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				MotionSensor.PROP_MEASURED_VALUE, MotionSensorEvent.MY_URI));
		

		/* PropertyExitSensor */
		/* create ontology resource for PropertyExitSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(PropertyExitSensorEvent.MY_URI);
		oci.setResourceLabel("PropertyExitSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 property exit sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				PropertyExitSensorEvent.occupant_exit_property, 
				PropertyExitSensorEvent.exit_door_left_open,
				PropertyExitSensorEvent.no_condition_detected } );

		/* create ontology resource for PropertyExitSensor */
		oci = createNewOntClassInfo(PropertyExitSensor.MY_URI,factory, 8);
		oci.setResourceLabel("PropertyExitSensor");
		oci.setResourceComment("ISO 11073-10471 property exit sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type PropertyExitSensorEvent */
		oci.addObjectProperty(PropertyExitSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				PropertyExitSensor.PROP_MEASURED_VALUE, PropertyExitSensorEvent.MY_URI));
		
		
		/* EnuresisSensor */
		/* create ontology resource for EnuresisSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(EnuresisSensorEvent.MY_URI);
		oci.setResourceLabel("EnuresisSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 enuresis sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				EnuresisSensorEvent.enuresis_detected, 
				EnuresisSensorEvent.no_condition_detected } );

		/* create ontology resource for EnuresisSensor */
		oci = createNewOntClassInfo(EnuresisSensor.MY_URI,factory, 9);
		oci.setResourceLabel("EnuresisSensor");
		oci.setResourceComment("ISO 11073-10471 enuresis sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type EnuresisSensorEvent */
		oci.addObjectProperty(EnuresisSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				EnuresisSensor.PROP_MEASURED_VALUE, EnuresisSensorEvent.MY_URI));
		
		
		/* ContactClosureSensor */
		/* create ontology resource for ContactClosureSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(ContactClosureSensorEvent.MY_URI);
		oci.setResourceLabel("ContactClosureSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 contact closure sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				ContactClosureSensorEvent.contact_opened,
				ContactClosureSensorEvent.contact_closed,
				ContactClosureSensorEvent.no_condition_detected } );

		/* create ontology resource for ContactClosureSensor */
		oci = createNewOntClassInfo(ContactClosureSensor.MY_URI,factory, 10);
		oci.setResourceLabel("ContactClosureSensor");
		oci.setResourceComment("ISO 11073-10471 contact closure sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type ContactClosureSensorEvent */
		oci.addObjectProperty(ContactClosureSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				ContactClosureSensor.PROP_MEASURED_VALUE, ContactClosureSensorEvent.MY_URI));
		
		
		/* UsageSensor */
		/* create ontology resource for UsageSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(UsageSensorEvent.MY_URI);
		oci.setResourceLabel("UsageSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 usage sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				UsageSensorEvent.usage_started,
				UsageSensorEvent.usage_ended,
				UsageSensorEvent.expected_use_start_violation,
				UsageSensorEvent.expected_use_stop_violation,
				UsageSensorEvent.absence_violation,
				UsageSensorEvent.no_condition_detected } );

		/* create ontology resource for UsageSensor */
		oci = createNewOntClassInfo(UsageSensor.MY_URI,factory, 11);
		oci.setResourceLabel("UsageSensor");
		oci.setResourceComment("ISO 11073-10471 usage sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type UsageSensorEvent */
		oci.addObjectProperty(UsageSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				UsageSensor.PROP_MEASURED_VALUE, UsageSensorEvent.MY_URI));
		
		
		/* SwitchSensor */
		/* create ontology resource for SwitchSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(SwitchSensorEvent.MY_URI);
		oci.setResourceLabel("SwitchSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 switch sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				SwitchSensorEvent.switch_on,
				SwitchSensorEvent.switch_off,
				SwitchSensorEvent.no_condition_detected } );

		/* create ontology resource for SwitchSensor */
		oci = createNewOntClassInfo(SwitchSensor.MY_URI,factory, 12);
		oci.setResourceLabel("SwitchSensor");
		oci.setResourceComment("ISO 11073-10471 switch sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type SwitchSensorEvent */
		oci.addObjectProperty(SwitchSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				SwitchSensor.PROP_MEASURED_VALUE, SwitchSensorEvent.MY_URI));
		
		
		/* MedicationDosageSensor */
		/* create ontology resource for MedicationDosageSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(MedicationDosageSensorEvent.MY_URI);
		oci.setResourceLabel("MedicationDosageSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 medication dosage sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				MedicationDosageSensorEvent.dosage_taken,
				MedicationDosageSensorEvent.dosage_missed,
				MedicationDosageSensorEvent.no_condition_detected } );

		/* create ontology resource for MedicationDosageSensor */
		oci = createNewOntClassInfo(MedicationDosageSensor.MY_URI,factory, 13);
		oci.setResourceLabel("MedicationDosageSensor");
		oci.setResourceComment("ISO 11073-10471 medication dosage sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type MedicationDosageSensorEvent */
		oci.addObjectProperty(MedicationDosageSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				MedicationDosageSensor.PROP_MEASURED_VALUE, MedicationDosageSensorEvent.MY_URI));
		
		
		/* TemperatureSensor */
		/* create ontology resource for TemperatureSensorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(TemperatureSensorEvent.MY_URI);
		oci.setResourceLabel("TemperatureSensorEvent");
		oci.setResourceComment("Event for ISO 11073-10471 temperature sensor");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				TemperatureSensorEvent.high_temperature_detected,
				TemperatureSensorEvent.low_temperature_detected,
				TemperatureSensorEvent.rate_of_change_too_fast,
				TemperatureSensorEvent.no_condition_detected } );

		/* create ontology resource for TemperatureSensor */
		oci = createNewOntClassInfo(TemperatureSensor.MY_URI,factory, 14);
		oci.setResourceLabel("TemperatureSensor");
		oci.setResourceComment("ISO 11073-10471 temperature sensor");
		oci.addSuperClass(Sensor.MY_URI);

		/* measured value property from motion sensor must be of type TemperatureSensorEvent */
		oci.addObjectProperty(TemperatureSensor.PROP_MEASURED_VALUE);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				TemperatureSensor.PROP_MEASURED_VALUE, TemperatureSensorEvent.MY_URI));


	/*** Actuators ***/
		
		/* AdaptorPlugActuator */
		/* create ontology resource for AdaptorPlugActuatorEvent
		 * create abstract class because it is an enumeration */
		oci = createNewAbstractOntClassInfo(AdaptorPlugActuatorEvent.MY_URI);
		oci.setResourceLabel("AdaptorPlugActuatorEvent");
		oci.setResourceComment("Event for adaptor plug actuator; extension to ISO 11073-10471");
		oci.addSuperClass(ManagedIndividual.MY_URI);
		oci.toEnumeration(new ManagedIndividual[] {
				AdaptorPlugActuatorEvent.power_on,
				AdaptorPlugActuatorEvent.power_off} );

		/* create ontology resource for AdaptorPlugActuator */
		oci = createNewOntClassInfo(AdaptorPlugActuator.MY_URI,factory, 15);
		oci.setResourceLabel("AdaptorPlugActuator");
		oci.setResourceComment("Adaptor plug actuator; extension to ISO 11073-10471");
		oci.addSuperClass(Actuator.MY_URI);

		/* status property from adaptor plug actuator must be of type AdaptorPlugActuatorEvent */
		oci.addObjectProperty(AdaptorPlugActuator.PROP_STATUS);
		oci.addRestriction(MergedRestriction.getAllValuesRestriction(
				AdaptorPlugActuator.PROP_STATUS, AdaptorPlugActuatorEvent.MY_URI));


	/*** Services ***/

		/* create ontology resource for ActivityHub Service */
		oci = createNewOntClassInfo(ActivityHub.MY_URI, factory, 16);
		oci.setResourceLabel("ActivityHub");
		oci.setResourceComment("The class of services controling activity hub sensors and actuators");
		oci.addSuperClass(Service.MY_URI);

		oci.addObjectProperty(ActivityHub.PROP_CONTROLS);
//		oci.addRestriction( ActivityHub.PROP_CONTROLS -> [alle meine activity hub devices] );
//		wie mach ich das?

	}

}
