/**
 * Prof. Philipp Jenke
 * Hochschule fÃ¼r Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package braitenberg;

import javafx.application.Application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import braitenberg.braitenbergvehikel.BVBewegungAbstossung;
import braitenberg.braitenbergvehikel.BVBewegungAttraktion;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;
import braitenberg.view.BVCanvas;

/**
 * JavaFX Anwendung zur Darstellung und Interaktion mit einer
 * Braitenberg-Vehikel-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVAnwendung extends Application {
	BVCanvas canvas;
	BVSimulation sim;
	SimulationThread simThread;
	
	@Override
	public void start(Stage primaryStage) {
		// Simulation zusammenstellen
		sim = erzeugeSimulationsszene();

		// Canvas setzen
		canvas = new BVCanvas(600, 600, sim);

		canvas.zeichneSimulation();

		// VBox mit Button und CheckBox
		VBox vbox = new VBox();
		Button button = new Button("Simuliere!");
		CheckBox checkbox = new CheckBox("Simuliere");
		vbox.getChildren().add(button);
		vbox.getChildren().add(checkbox);

		//ComboBox für Susi
		ComboBox<String> combobox0= new ComboBox<String>();
		combobox0.getItems().addAll("ATTRAKTION","ABSTOSSUNG");
		combobox0.getSelectionModel().select(0);
		
		combobox0.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String comboText =combobox0.getSelectionModel().getSelectedItem().toString();
				if (comboText== "ATTRAKTION"){
					sim.getVehikel(0).setBewegung(new BVBewegungAttraktion());
				}else if(comboText == "ABSTOSSUNG"){
					sim.getVehikel(0).setBewegung(new BVBewegungAbstossung());
				}
			}
		});
		//ComboBox für Mike
		ComboBox<String> combobox1= new ComboBox<String>();
		combobox1.getItems().addAll("ATTRAKTION","ABSTOSSUNG");
		combobox1.getSelectionModel().select(1);
		combobox1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String comboText =combobox1.getSelectionModel().getSelectedItem().toString();
				if (comboText== "ATTRAKTION"){
					sim.getVehikel(1).setBewegung(new BVBewegungAttraktion());
				}else if(comboText == "ABSTOSSUNG"){
					sim.getVehikel(1).setBewegung(new BVBewegungAbstossung());
				}
			}
		});
		
		// Szenengraph aufbauen
		primaryStage.setTitle("Braitenberg-Vehikel!");
		BorderPane wurzel = new BorderPane();
		wurzel.setCenter(canvas);
		
		Label label0 = new Label("Susi");
		Label label1 = new Label("Mike");
		HBox hbox0 = new HBox(label0,combobox0);
		HBox hbox1 = new HBox(label1,combobox1);
		vbox.getChildren().add(hbox0);
		vbox.getChildren().add(hbox1);
		wurzel.setRight(vbox);
		
		primaryStage.setScene(new Scene(wurzel, 850, 600));
		primaryStage.show();

		
		
		// Reaktion auf Button
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				sim.simulationsSchritt();
				canvas.zeichneSimulation();
			}
		});

		// Reaktion auf CheckBox
		checkbox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				if (checkbox.isSelected()) {
					simThread = new SimulationThread(sim);
					((Thread)simThread).start();
				} else {
					simThread.setFlag();
				}
			}
		});

		//Maus Signal neuen Punkt setzten
		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				sim.setSignal(event.getX() - (canvas.getWidth() / 2), (canvas.getHeight() / 2) - event.getY());
				
			}
		});

		//Beenden des Threads beim schließen des Fensters
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				if(simThread != null){
					simThread.setFlag();
					simThread = null;
				}
			}
		});
	}

	/**
	 * Erzeugt eine Simulationsszene zum Testen.
	 */
	public BVSimulation erzeugeSimulationsszene() {
		BraitenbergVehikel vehikel1 = new BraitenbergVehikel("Susi", new BVBewegungAttraktion());
		BraitenbergVehikel vehikel2 = new BraitenbergVehikel("Mike", new BVBewegungAbstossung(), new Vektor2(-100, 100),
				new Vektor2(1, 0));
		BVSimulation sim = new BVSimulation();
		sim.vehikelHinzufuegen(vehikel1);
		sim.vehikelHinzufuegen(vehikel2);
		return sim;
	}

	public static void main(String[] args) {
		launch(args);
	}




}
