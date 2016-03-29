package domain;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Domain {

	private DoubleProperty peso;
	private DoubleProperty altura;
	
	public Domain() {
		peso = new SimpleDoubleProperty();
		altura = new SimpleDoubleProperty();
	}
	
	public void setPeso(double peso) {
		this.peso.set(peso);
	}
	
	public double getPeso() {
		return this.peso.get();
	}
	
	public DoubleProperty pesoProperty() {
		return this.peso;
	}
	
	public void setAltura(double altura) {
		this.altura.set(altura);
	}
	
	public double getAltura() {
		return this.altura.get();
	}
	
	public DoubleProperty alturaProperty() {
		return this.altura;
	}
}
