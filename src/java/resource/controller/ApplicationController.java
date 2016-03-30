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
		lblImc.setText(String.format("%.2f", calcImc()));
		status();
	}

	@FXML
	private void handleClear() {
		txtAltura.setText("0");
		txtPeso.setText("0");
		lblImc.setText("0");
	}

	@FXML
	private void handleClose() {
		Platform.exit();
	}

	private double calcImc() {
		return (domain.getAltura() == 0 || domain.getPeso() == 0) ? 0
				: domain.getPeso() / (domain.getAltura() * domain.getAltura());
	}

	private void status() {
		if (calcImc() < 20.7) {
			lblStatus.setText("ABAIXO DO PESO");
		} else {

			if (calcImc() < 26.5) {
				lblStatus.setText("PESO NORMAL");
			} else {

				if (calcImc() < 27.9) {
					lblStatus.setText("MARGINALMENTE ACIMA DO PESO");
				} else {

					if (calcImc() < 31.2) {
						lblStatus.setText("ACIMA DO PESO IDEAL");
					} else {
						lblStatus.setText("OBESO");
					}
				}
			}
		}
	}
}
