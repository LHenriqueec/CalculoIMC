package controller;


import domain.Domain;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class ApplicationController {
	
	private Domain domain;
	
	@FXML
	private TextField txtAltura;
	@FXML
	private TextField txtPeso;
	@FXML
	private Label lblImc;
	@FXML
	private Label lblStatus;
	
	@FXML
	private void initialize() {
		domain = new Domain();
		
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(txtAltura.textProperty(), domain.alturaProperty(), converter);
		Bindings.bindBidirectional(txtPeso.textProperty(), domain.pesoProperty(), converter);
	}
	
	@FXML
	private void handleCalc() {
		
	}
	
	@FXML
	private void handleClear() {
		domain.setAltura(0);
		domain.setPeso(0);
	}
	
	@FXML
	private void handleClose() {
		Platform.exit();
	}
	
	private double calcImc() {
		return 0;
	}
}
