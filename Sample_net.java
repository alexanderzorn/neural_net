import java.util.*;

public class Sample_net{
  
  
  //Klasse 1 mit y = 1
  public static ArrayList<Double> kl_1_funktion(double u){
    ArrayList<Double> output = new ArrayList<Double>();
    output.add(2+Math.sin(0.2*u+8)*Math.sqrt(u+10));
    output.add(-1+Math.cos(0.2*u+8)*Math.sqrt(u+10));
    
    return output;
  }
  //Klasse 2 mit y = -1
  public static ArrayList<Double> kl_2_funktion(double u){
    ArrayList<Double> output = new ArrayList<Double>();;
    output.add(2+Math.sin(0.2*u-8)*Math.sqrt(u+10));
    output.add(-1+Math.cos(0.2*u-8)*Math.sqrt(u+10));
    
    return output;
    
  }
  
  
  
  public static void main(String[] args) {
    Feed_Forward_Net sample_net = new Feed_Forward_Net();
    
    //Blatt 4 Aufgabe 2 baue RBF Netz
    sample_net.nr_inputs = 2;
    //eine verdeckte Schicht mit 25 Neuronen und gewichten zu den Inputs = 1
    sample_net.add_layer();
    for(int i = 0; i< 25; ++i){
      sample_net.add_Neuron(0, 0);
      //setze direkt das Zentrum
      ArrayList<ArrayList<Double>> neuron_train_data = new ArrayList<ArrayList<Double>>();
      for(int j = 1; j<= 16; ++j){
        if(i  < 12) neuron_train_data.add(kl_1_funktion((double) i*16 +j));
        else if (i > 12)neuron_train_data.add(kl_2_funktion((double) (i-12)*16 +j));
        else{
          if(j<=8)neuron_train_data.add(kl_1_funktion((double) i*16 +j));
          else neuron_train_data.add(kl_2_funktion((double) (i-12)*16 +j));
        }
      }
      
      sample_net.layers.get(0).get(sample_net.layers.get(0).size() -1).evaluate_center(neuron_train_data);
    }
    
    //Eine Ausgabe Schicht mit einem Neuron welche in -1 und 1 Klassifiziert
    sample_net.add_layer();
    sample_net.add_Neuron(1, 1);
    
  
    //Trainieren der Ausgangsgewichte fehlt noch!!
    //test immer abwechselnd beide klassen
    double lernrate = 0.1;
    for(int u = 1; u<200; ++u){
      for(int k= 0; k<2; ++k){
        double t;
        double o;
        if(k == 0) {
          o= sample_net.evaluate_net(kl_1_funktion(u)).get(0);
          t = 1;
        }
        else {
          o = sample_net.evaluate_net(kl_2_funktion(u)).get(0);
          t = -1;
          }
        if (o== t) continue;
        //wenn ein Fehler vorliegt dann trainiere jedes Gewicht
        for(int i = 0; i< sample_net.weights.get(1).size(); ++i){
          double delta = lernrate *sample_net.layers.get(0).get(i).compute(sample_net.weights.get(0).get(i) , kl_1_funktion(u));
          sample_net.weights.get(1).get(0).set(i, sample_net.weights.get(1).get(0).get(i)+(t-o)*delta);
        }
      }
      
    }
    
    
    //Hier sind die Zentren und die Gewichte trainiert kannst also hiernach beliebige Werte auslesen lassen. 
  
    
    
    
    //ArrayList<Double> output = sample_net.evaluate_net(input);
    
    //System.out.println("Ergebnis ist " + output.get(0));
    //Ergebnis sollte 1/(1+e^-2) sein ungefähr 0,88079 Ergebnis stimmmt
    
  }
  
}
