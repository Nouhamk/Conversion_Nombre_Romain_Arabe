package com.uca;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

	@Test
	public void testConverter(){
		// Tests de reussite
	    	assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        	assertThat(RomanConverter.getNumberFromRoman("X"),equalTo(10));
	    	// Tests D'echec
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)),instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)),instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")),instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")),instanceOf(IllegalArgumentException.class));


		// Test de validite
		for (int i=1;i<=3999;i++){
		    int it = i;
		    String str_roman = RomanConverter.getRomanFromNumber(it);
		    char[] arr_roman = str_roman.toCharArray();

		    boolean is_Upper_Case ;
		    // first check
		    for(int j=0;j< arr_roman.length;j++){
		        // Par defaut , on considere le string en majuscule
		        is_Upper_Case = true ;
		        // Test du retour ToRoman
		        if(!Character.isUpperCase(arr_roman[j])){
		            System.out.println(it+"ToRoman doesnt return all UPPERCASE");
		            is_Upper_Case = false ;
		            break;
		        }
		    }
		    if(is_Upper_Case = true){
		        int ToNumber = RomanConverter.getNumberFromRoman(str_roman);
		        assertThat(ToNumber , equalTo(it));
		    }
		    else {
		        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman(str_roman)),instanceOf(IllegalArgumentException.class));
		    }
		}
	}

	public void Test_compare(){

    }


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
