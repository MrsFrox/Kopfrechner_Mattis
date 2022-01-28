import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Controller {
	public static final String ADDIEREN = "Addieren";
	public static final String SUBTRAHIEREN = "Subtrahieren";
	public static final String MULTIPLIZIEREN = "Multiplizieren";
	public static final String DIVIDIEREN = "Dividieren";
	
	
	String[] HEADERS = { "Fragen", "Fehler","Name","Operator"};
	
	private static Controller instance;
	
	public static final String PATH = "C:\\Users\\User\\git\\repository\\Kopfrechner\\resource\\Wertungen.json";
	
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
	
	
	public void saveWertung(Wertung wertung) {
	
		
	}
	
	
	
	public List<CSVRecord> getRecords() {
		List<CSVRecord> list = new ArrayList<>();
		try {
		 Reader in = new FileReader("book_new.csv");
		    Iterable<CSVRecord> records = CSVFormat.DEFAULT
		      .withHeader(HEADERS)
		      .withFirstRecordAsHeader()
		      .parse(in);
		  records.forEach(e -> {
			  list.add(e);
		  });
		}catch(Exception ioex) {
			
		}
		return list;
	}
	
	public void createCSVFile(List<List<String>> data)  {
	    FileWriter out = null;
		try {
			out = new FileWriter("book_new.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
	      .withHeader(HEADERS))) {
	      data.forEach(l -> {
	            try {
					printer.printRecord(l.get(0), l.get(1), l.get(2), l.get(3));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        });
	    }catch(Exception e) {
	    	
	    }
	}
	
	}
	
	
	
	
	
	


