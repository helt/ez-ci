package de.fhg.igd.iva.examples.ci.lib;

public class MyNumber {

	private int value;

	public MyNumber(int i) {
		this.value=i;
	}

	public MyNumber plus(MyNumber two) {
		return new MyNumber(two.value + this.value);
	}

}
