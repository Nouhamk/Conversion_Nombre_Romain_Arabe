//	*****************************************************************************************************

//								GENIE LOGICIEL
//					TRAVAIL FAIT PAR : MOUKADDIME NOUHAILA

//	*****************************************************************************************************

package com.uca;
import java.text.BreakIterator;
import java.util.*;
public class Start{


	//Start class
	public static void main(String[] args){

		System.out.println("----------------------- Convertisseur Nombre / Roman -----------------------");
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("");
		System.out.println("--------------------------------* Menu *-------------------------------- ");
		System.out.println(" choix 1 : Afficher la table de conversion de tout les nombre romain");
		System.out.println(" choix 2 : Afficher la Liste des methodes des valeurs de nombre");
		System.out.println(" choix 3 : Afficher la liste des methodes des valeurs de nombre Romain");
		System.out.println(" choix 4 : Comparaison de chiffres romains et nombres arabes");
		System.out.println("--------------------------------* Menu *-------------------------------- ");
		System.out.println("");
		System.out.print(" choix : ");
		// Input de l'utilisateur
		Scanner sc= new Scanner(System.in);
		System.out.print("Entrez un nombre ");
		int choice= sc.nextInt();

		switch (choice){
			// Affichage de tout les nombres romains
			case 1 :
				System.out.println("");
				System.out.println("******** Liste des conversions Number-Roman ********");
				System.out.println("----------------------------------------------------");
				System.out.println("interateur	|	ToRoman		|	ToNumber(ToRoman)	");
				System.out.println("----------------------------------------------------");
				for(int i=1;i<4000;i++){
					String str_roman = RomanConverter.getRomanFromNumber(i);
					int int_num = RomanConverter.getNumberFromRoman(str_roman);
					System.out.println("	"+i+"		|		"+str_roman+"		|		"+int_num);
				}
				break ;
			// Presentation des different methode pour un nombre de la class RomanNumber
			case 2 :
				System.out.println("");
				System.out.println("******** Liste des methodes des valeurs de nombre ********");

				System.out.print("Entrez un nombre : ");
				int nombre= sc.nextInt();

				System.out.println(" Les nomrbe saisie est : "+nombre);
				// Creation d'un instant pour notre nombre
				RomanNumber roman1 = new RomanNumber(nombre);
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("getValue()    :	"+roman1.getValue());
				System.out.println("getRoman()    :	"+roman1.getRoman());
				System.out.println("doubleValue() :	"+roman1.doubleValue());
				System.out.println("floatValue()  : "+roman1.floatValue());
				System.out.println("intValue()    :	"+roman1.intValue());
				System.out.println("longValue()   :	"+roman1.longValue());
				System.out.println("toString()    :	"+roman1.toString());
				System.out.println("--------------------------------------------------------------------------");
				break ;
			// Presentation des different methodes pour un nombre romain de la class RomanNumber
			case 3 :
				System.out.println("");
				System.out.println("******** Liste des methodes des valeurs de nombreRomain ********");

				System.out.println("Entrez un nombre romain : ");
				String str1= sc.nextLine();
				str1=sc.nextLine();

				System.out.println(" Le nombre Romain saisie est : "+str1);
				// Creation d'un instant pour notre nombre
				RomanNumber roman2 = new RomanNumber(str1);
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("getValue()    :	"+roman2.getValue());
				System.out.println("getRoman()    :	"+roman2.getRoman());
				System.out.println("doubleValue() :	"+roman2.doubleValue());
				System.out.println("floatValue()  : "+roman2.floatValue());
				System.out.println("intValue()    :	"+roman2.intValue());
				System.out.println("longValue()   :	"+roman2.longValue());
				System.out.println("toString()    :	"+roman2.toString());
				System.out.println("--------------------------------------------------------------------------");
				break;

			case 4:
				System.out.println("");
				System.out.println("******** Comparateur de chiffres romains et nombres ********");
				System.out.println("Entrez un nombre : ");
				int val= sc.nextInt();
				System.out.println("Entrez un chiffre romain : ");
				String str= sc.nextLine();
				str=sc.nextLine();
				RomanNumber romain2 = new RomanNumber();
				System.out.println("resutlas de comparaison : "+romain2.comparateur_chiffre(str,val));
				break;

			default:
				System.out.println("Choix Invalide");
				break;
		}

	}
	
}
