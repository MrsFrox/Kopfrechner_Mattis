import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {
	public static final String ADDIEREN = "Addieren";
	public static final String SUBTRAHIEREN = "Subtrahieren";
	public static final String MULTIPLIZIEREN = "Multiplizieren";
	public static final String DIVIDIEREN = "Dividieren";
	
	private static Controller instance;
	
	private Controller() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		
		return instance;
	}
	
	
	public List<Aufgabe> start(int anzahl, List<String> operatoren) {
		List<Aufgabe> aufgaben = new ArrayList<>();
		int maxOp = operatoren.size();
		for(int i = 0; i< anzahl; i++) {
			int nextInt = ThreadLocalRandom.current().nextInt(0, maxOp);
			String op = operatoren.get(nextInt);
			int wert1 = ThreadLocalRandom.current().nextInt(0, 11);
			int wert2 = ThreadLocalRandom.current().nextInt(0, 11);
			Aufgabe a = new Aufgabe(wert1, wert2, op);
			aufgaben.add(a);
		}
		return aufgaben;
	}
	
	
	
	
	
	

}
