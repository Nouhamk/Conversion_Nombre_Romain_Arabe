package com.uca;


import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		String res1 = ""; // Pour stocker les resutlas de la premiere operation
		String resultas = ""; // pour le resutlas envoyer a la fin
		if(a<1 || a>3999){
			throw new IllegalArgumentException("le nombre doit etre compris entre [1,3999] !!") ;
		}
		//Premiere transformation
		for (RomanNumber x:SYMBOLS){
			while (a >= x.getValue()){
				res1 += x.getRoman() ;
				a -= x.getValue() ;
			}
		}
		//Deuxieme transformation
		resultas=res1.replace("VV","X");
		resultas=res1.replace("IIII","IV");
		resultas=res1.replace("XXXX","XL");
		resultas=res1.replace("CCCC","CD");
		resultas=res1.replace("LL","C");
		resultas=res1.replace("DD","M");


		return resultas;
	}

	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		//tester les nombres romain non accepter
		int i , repeat_count = 0;
//		String multip = "IXCM";

		if (a.contains("IIII") ||a.contains("XXXX") ||a.contains("CCCC") ||a.contains("MMMM") ||
			a.contains("VV")   ||a.contains("LL")   ||a.contains("DD") ){
			throw new IllegalArgumentException("erreur");
		}
		// Methode plus longue est inneffectif pour faire les testes precedents
//		for(i=1;i<a.length();i++) {
//			char cur_char = a.charAt(i)  ;
//			char prev_char= a.charAt(i-1);
//			//comparer chaque caractere avec celui qui le precede
//			if(cur_char == prev_char) {
//				repeat_count ++;
//				// tester s'il y a une succession de "V"
//				if(cur_char == 'V'){
//					throw new IllegalArgumentException(cur_char +" est repeter 2 fois");
//				}
//				// tester si les caractere des multiple ne se repetent pas plus que 3 fois
//				if(multip.contains(Character.toString(cur_char))){
//					if(repeat_count > 3 ){
//						throw new IllegalArgumentException(cur_char +" est repeter plus que 3 fois !!");
//					}
//				}
//			}
//		}

		//------ FIN DES TESTS -------

		int result =0;
		int index = 0;

		for (RomanNumber x:SYMBOLS){
			while (index + x.getRoman().length() <= a.length() && a.substring(index,index+x.getRoman().length()).equals(x.getRoman()) ){
				result += x.getValue();
				index  += x.getRoman().length();
			}
		}
		return result;
	}
}







