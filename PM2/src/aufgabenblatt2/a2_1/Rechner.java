package aufgabenblatt2.a2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {
	
	private DoubleDoubleZuDouble multiplikation = (zahl_1, zahl_2)-> {return zahl_1 * zahl_2;};
	private DoubleDoubleZuDouble nullstelle = (zahl_1, zahl_2)-> {return (0-zahl_2)/zahl_1;};
	
	

	public enum  Operation { ADDITION, SUBTRAKTION, MULTIPLIKATION, DIVISION};
	
	private Map<Operation, BinaryOperator<Double>> menge;
	
	public Rechner(){
		Map<Operation, BinaryOperator<Double>> map = new HashMap<Operation, BinaryOperator<Double>>();
		map.put(Operation.ADDITION, 		(zahl_1, zahl_2) -> zahl_1+zahl_2);
		map.put(Operation.SUBTRAKTION, 		(zahl_1, zahl_2) -> zahl_1-zahl_2);
		map.put(Operation.MULTIPLIKATION,	(zahl_1, zahl_2) -> zahl_1*zahl_2);
		map.put(Operation.DIVISION, 		(zahl_1, zahl_2) -> zahl_1/zahl_2);
		menge = map;
	}
	
	public double berechne(Operation operation, double zahl_1, double zahl_2){
		return menge.get(operation).apply(zahl_1, zahl_2);
	}
	
	public static void main(String[] args) {
		Rechner rechner = new Rechner();
		System.out.println(rechner.berechne(Operation.ADDITION, 12, 11));
		
		System.out.println(rechner.multiplikation.werteAus(5, 3));
		System.out.println(rechner.nullstelle.werteAus(2, 5));
	}

}
