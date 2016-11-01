package aufgabenblatt2.a2_2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;



public class TestStreams {
	@Test
	public void testReinigung(){
		String[] text = {"Eingabe ", "Äußeres ", null, "Strassen-Feger", " ein Haus" };
		Streams stream = new Streams(text);
		List<String> clean =stream.reinigung();
		
		String[] erwartet = {"EINGABE", "AEUSSERE", "STRASSEN", "EIN HAUS"};

		for(int  i = 0 ; i< clean.size(); i++){
		assertEquals(clean.get(i),erwartet[i]);
	}
	}

}
