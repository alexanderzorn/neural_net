import java.util.*;
public class Lin_Neuron extends Neuron{
  public double compute(ArrayList<Double> input_wheigts, ArrayList<Double> inputs){
    //hier wird logistische Funktion und Summe als Transfer bzw Aktivierungsfunktion genutzt. TODO durch bel. Funktionen ersetzen
    double sum = 0;
    for(int i = 0; i <inputs.size(); ++i){
      sum += (double) inputs.get(i)* (double) input_wheigts.get(i);
    }
    return sum;
  }
}
