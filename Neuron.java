import java.util.*;

public class Neuron{
  
  public double compute(ArrayList input_wheigts, ArrayList inputs){
    //hier wird logistische Funktion und Summe als Transfer bzw Aktivierungsfunktion genutzt. TODO durch bel. Funktionen ersetzen
    double sum = 0;
    for(int i = 0; i <inputs.size(); ++i){
      sum += (double) inputs.get(i)* (double) input_wheigts.get(i);
    }
    return 1/(1+Math.exp(-sum));
  }
  
}
