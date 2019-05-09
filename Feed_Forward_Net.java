import java.util.*;

public class Feed_Forward_Net{
  ArrayList<ArrayList<Neuron>> layers = new ArrayList<ArrayList<Neuron>>();
  ArrayList<ArrayList<ArrayList<Double>>> weights = new ArrayList<ArrayList<ArrayList<Double>>>();
  
  int nr_inputs;//muss gesetzt werden
  
  public void add_Neuron(int layer, int type){
    if(type == 0) layers.get(layer).add(new Neuron ());
    else layers.get(layer).add(new Lin_Neuron ());
    weights.get(layer).add(new ArrayList<Double>());
    
    int nr_precessor;
    if (layer == 0){
      nr_precessor = nr_inputs;
    }
    else{
      nr_precessor = layers.get(layer-1).size();
    }
    for(int i = 0; i < nr_precessor; ++i){
      weights.get(layer).get(weights.get(layer).size() -1).add(1.0);
    }
  }
  public void add_layer(){
    layers.add(new ArrayList<Neuron>());
    weights.add(new ArrayList<ArrayList<Double>>());
  }
  
  public ArrayList<Double> evaluate_net(ArrayList<Double> inputs){
    ArrayList<ArrayList<Double>> layer_evaluations = new ArrayList<ArrayList<Double>>();
    for(int layer = 0; layer <layers.size(); ++layer){
      layer_evaluations.add(new ArrayList<Double>());
      for(int neuron = 0; neuron < layers.get(layer).size(); ++neuron){
        if(layer != 0){
        layer_evaluations.get(layer).add(layers.get(layer).get(neuron).compute(layer_evaluations.get(layer-1), weights.get(layer).get(neuron)));
        }
        else {
          layer_evaluations.get(layer).add(layers.get(layer).get(neuron).compute(inputs, weights.get(layer).get(neuron)));
        }
      }
    }
    return layer_evaluations.get(layer_evaluations.size() -1 );
  }
  
}
