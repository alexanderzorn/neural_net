import java.util.*;

public class Neuron{
  int nr_inputs;
  ArrayList<Double> zentrum = new ArrayList<Double>();
  
  public double center_distance(ArrayList<Double> inputs){
    double distance = 0; //rh
    for(int i = 0; i <inputs.size(); ++i){
      distance += Math.sqrt( Math.pow( (double) inputs.get(i) - (double) zentrum.get(i),2) ); //abstandsberechnung
    }
    return distance;
  }
  
  
  
  
  public double compute(ArrayList<Double> input_wheigts, ArrayList<Double> inputs){
    //hier wird logistische Funktion und Summe als Transfer bzw Aktivierungsfunktion genutzt. TODO durch bel. Funktionen ersetzen
	/*double sum = 0;
    for(int i = 0; i <inputs.size(); ++i){
      sum += (double) inputs.get(i)* (double) input_wheigts.get(i);
    }*/
    
    
    //Berechnung der Aktivierungsfunktion RBF
    double distance = center_distance(inputs);
    
    double varianz=2; //bel. aber fest
    
    double f_actValue = Math.exp(-Math.pow(distance,2)/2*varianz); //f(rh)
    
    double returnValue = 1;
    if(f_actValue < 0) returnValue = -1;
    
    
    return returnValue;
  }
  
  public void evaluate_center(ArrayList<ArrayList<Double>> examples){
    //Berechne den Mittelpunkt aus einer Menge gegebener Punkte
    //nehme an das zentrum ist leer!
    for(int i= 0; i < examples.get(0).size(); ++i){
      zentrum.add(0.0);
      for(int j = 0; j < examples.size(); ++j){
        zentrum.set(zentrum.size()-1, zentrum.get(zentrum.size()-1) +examples.get(j).get(i));
      }
      zentrum.set(zentrum.size()-1, zentrum.get(zentrum.size()-1) /examples.size());
    }
  }
  
}
