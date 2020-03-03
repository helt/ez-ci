package de.fhg.igd.iva.examples.ci.main;

import de.fhg.igd.iva.examples.ci.lib.MyNumber;

public class Application {

	public static void main(String[] args) {
		MyNumber one = new MyNumber(1);
		MyNumber two = new MyNumber(2);

		MyNumber sum = one.plus(two);

		System.out.println(String.format("%s + %s = %s", one, two, sum));

	}

}
