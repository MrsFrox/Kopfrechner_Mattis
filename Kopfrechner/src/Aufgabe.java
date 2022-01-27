import java.math.BigDecimal;
import java.math.BigInteger;

public class Aufgabe {

	private Integer wert1;

	private Integer wert2;

	private String operator;


	public Aufgabe(Integer wert1, Integer wert2, String operator) {
		this.wert1 = wert1;
		this.wert2 = wert2;
		this.operator = operator;
	}

	public Integer getWert1() {
		return wert1;
	}

	public Integer getWert2() {
		return wert2;
	}

	public String getOperator() {
		return operator;
	}

	public Double getErgebnis() {
		if (Controller.ADDIEREN.equals(operator)) {
			BigInteger result = BigInteger.valueOf(wert1).add(BigInteger.valueOf(wert2));
			return Double.valueOf(result.doubleValue());
		} else if (Controller.SUBTRAHIEREN.equals(operator)) {
			BigInteger result = BigInteger.valueOf(wert1).subtract(BigInteger.valueOf(wert2));
			return Double.valueOf(result.doubleValue());

		} else if (Controller.MULTIPLIZIEREN.equals(operator)) {
			BigInteger result = BigInteger.valueOf(wert1).multiply(BigInteger.valueOf(wert2));
			return Double.valueOf(result.doubleValue());
		} else if (Controller.DIVIDIEREN.equals(operator)) {
			BigDecimal result = BigDecimal.valueOf(wert1).divide(BigDecimal.valueOf(wert2));
			return Double.valueOf(result.doubleValue());
		}

		return null;
	}
	
	@Override
	public String toString() {
		return wert1+" " + operator + " "+ wert2  ;
	}

}