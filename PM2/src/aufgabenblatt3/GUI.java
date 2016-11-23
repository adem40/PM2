package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application implements Observer {
	/**
	 * Anzahl von Gleisen des Bahnhofs.
	 */
	private int anzahlGleise = 10;
	/**
	 * Pane der Benutzeroberflaeche.
	 */
	private Pane root;

	/**
	 * Hauptmethode der Benutzeroberflaeche. Erzeugt ein Fenster mit Rechtecken,
	 * die Rot sind falls ein Gleis belegt, und Gruen wenn eins frei ist.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		int rectangleHeight = 480 / anzahlGleise;
		Rectangle rectangle;
		root = new HBox();
		for (int i = 0; i < anzahlGleise; i++) {
			rectangle = new Rectangle(rectangleHeight,120);
			rectangle.setFill(Color.GREEN);
			rectangle.setStroke(Color.BLACK);
			root.getChildren().add(rectangle);
		}
		primaryStage.setTitle("Simulation");
		primaryStage.setScene(new Scene(root, 480, 120));
		primaryStage.show();
		Thread simulation = new Thread(new Simulation(this,anzahlGleise));
		simulation.start();
	}

	/**
	 * Aktualisiert anhand der Variablen der Refresh Klasse, welches Gleis
	 *  umgefaerbt  werden muss.
	 * 
	 */
	@Override
	public void update(Observable obs, Object obj) {
		Refresh change = (Refresh) obj;
		Rectangle rect;
		if (change.getAufgabe() == Lokfuehrer.Aufgabe.EINFAHREN) {
			rect = (Rectangle) (root.getChildren().get(change.getGleis()));
			if (rect != null) {
				Platform.runLater(() -> {
					rect.setFill(Color.RED);
				});
			}
		} else {
			rect = (Rectangle) (root.getChildren().get(change.getGleis()));
			if (rect != null) {
				Platform.runLater(() -> {
					rect.setFill(Color.GREEN);
				});
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}