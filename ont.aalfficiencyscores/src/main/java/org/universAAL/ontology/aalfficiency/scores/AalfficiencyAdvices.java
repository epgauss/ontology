package org.universAAL.ontology.aalfficiency.scores;

import java.util.ArrayList;
import java.util.List;
import org.universAAL.middleware.owl.ManagedIndividual;


public class AalfficiencyAdvices extends ManagedIndividual {
  public static final String MY_URI = AalfficiencyScoresOntology.NAMESPACE
    + "AalfficiencyAdvices";
  public static final String PROP_ADVICE = AalfficiencyScoresOntology.NAMESPACE
    + "advice";


  public AalfficiencyAdvices () {
    super();
  }
  
  public AalfficiencyAdvices (String uri) {
    super(uri);
  }

  public String getClassURI() {
    return MY_URI;
  }
  public int getPropSerializationType(String arg0) {
	// TODO Implement or if for Device subclasses: remove 
	return 0;
  }

  public boolean isWellFormed() {
	return true 
      && hasProperty(PROP_ADVICE);
  }

  public Advice[] getAdvice() {
    Object propList = getProperty(PROP_ADVICE);
    if (propList instanceof List)
      return (Advice[]) ((List) propList).toArray(new Advice[0]);
    else if (propList != null)
      return new Advice[] {(Advice)propList}; // Handle special case of a single item not contained in a list
    return new Advice[0];
  }

  public void addAdvice(Advice newValue) {
    Object propList = getProperty(PROP_ADVICE);
    List newList;
    if (propList instanceof List)
      newList = (List)propList;
    else {
      newList = new ArrayList();
      if (propList != null)
        newList.add(propList); // Handle special case of a single previous item not contained in a list
    }
    newList.add(newValue);
    changeProperty(PROP_ADVICE, newList);
  }
  

  public void setAdvice(Advice[] propertyValue) {
    List propList = new ArrayList(propertyValue.length);
    for (int i = 0; i < propertyValue.length; i++) {
      propList.add(propertyValue[i]);
    }
    changeProperty(PROP_ADVICE, propList);
  }
}
