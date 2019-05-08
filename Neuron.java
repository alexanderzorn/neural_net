import java.util.*;

public class Neuron{
  
  public double compute(ArrayList<Double> input_wheigts, ArrayList<Double> inputs){
    //hier wird logistische Funktion und Summe als Transfer bzw Aktivierungsfunktion genutzt. TODO durch bel. Funktionen ersetzen
	/*double sum = 0;
    for(int i = 0; i <inputs.size(); ++i){
      sum += (double) inputs.get(i)* (double) input_wheigts.get(i);
    }*/
    
    
    //Berechnung der Aktivierungsfunktion RBF
    double distance = 0; //rh
    for(int i = 0; i <inputs.size(); ++i){
        distance += Math.sqrt( Math.pow( (double) inputs.get(i) - (double) input_wheigts.get(i),2) ); //abstandsberechnung
     }
    
    double varianz=2; //bel. aber fest
    
    double returnValue = Math.exp(-Math.pow(distance,2)/2*varianz); //f(rh)
    
    return returnValue;
  }
  
}
