import java.util.*;

public class Sample_net{
  
  
  public static void main(String[] args) {
    Feed_Forward_Net sample_net = new Feed_Forward_Net();
    
    sample_net.nr_inputs = 2;
    
    sample_net.add_layer();
    sample_net.add_Neuron(0);
    
    ArrayList<Double> input = new ArrayList<Double>();
    input.add(1.0);
    input.add(1.0);
    
    ArrayList<Double> output = sample_net.evaluate_net(input);
    
    System.out.println("Ergebnis ist " + output.get(0));
    //Ergebnis sollte 1/(1+e^-2) sein ungefähr 0,88079 Ergebnis stimmmt
    
  }
  
  
  
}
