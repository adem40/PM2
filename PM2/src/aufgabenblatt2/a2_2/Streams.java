package aufgabenblatt2.a2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Streams {

	private String[] text;

	public Streams(String[] text) {
		this.text = text;
	}
	
	public List<String> reinigung(){
		List<String> dirty = Arrays.asList(text);
		List<String> clean = new ArrayList<>();
		dirty.stream()
					.filter(Objects::nonNull)
					.map(String::trim)
					.map(String::toUpperCase)
					.map(AEchange->AEchange.replace("Ä", "AE"))
					.map(OEchange->OEchange.replace("Ö", "OE"))
					.map(UEchange->UEchange.replace("Ü", "UE"))
					.map(SSchange->SSchange.replace("ß", "SS"))
				// Auf 8 kürzen fehlt
					.forEach(clean::add);
		return clean;
		
	}



	public static void main(String[] args) {
		String[] text = {"Eingabe ", "Äußeres ", null, "Strassen-Feger", " ein Haus" };
		Streams stream = new Streams(text);
		System.out.println(stream.reinigung());
		
		
	}

}
