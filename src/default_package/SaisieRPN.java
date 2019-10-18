package default_package;

import java.util.Scanner;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;

import exception.ExceptionEntreeIncorrect;
import exception.ExceptionIntervalInferieur;
import exception.ExceptionIntervalSuperieur;
import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

/**
 * @author Amir
 *
 */
public class SaisieRPN {
	int MAX_VALUE=Integer.MAX_VALUE;
	int MIN_VALUE=Integer.MIN_VALUE;
	public boolean continu;
	Scanner sc = new Scanner(System.in);
	int monNombre;
	String monOperateur,monInsert;

	/** Ce constructeur va nous servir uniquement a tester les methodes de la classe
	 * @param a
	 */
	public SaisieRPN(int a)
	{

	}
	/** Interaction avec le user
	 * @throws ExceptionEntreeIncorrect
	 * @throws ExceptionNombreOperandesEgaleUn 
	 * @throws ExceptionNombreOperandesEgaleZero 
	 * @throws Exception
	 */
	public SaisieRPN() throws ExceptionEntreeIncorrect,ExceptionIntervalInferieur, ExceptionIntervalSuperieur, ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn
	{
		MoteurRPN moteurRPN= new MoteurRPN();
		Operation monOperation=null;
		continu=true;
		do {
			System.out.println("Veuillez saisir : un nombre || une operation || 'exit' ");
			monInsert=sc.nextLine();
			if(monInsert.equals("exit"))// Cas ou il tape exit
			{
				continu=false;
				System.exit(0);
			}
			if(insertIsNomber(monInsert)==true) // Cas nombre
			{
				if(verifIntervalValeur(monInsert)==true)
				{
					moteurRPN.addOperande(Float.parseFloat(monInsert));
					moteurRPN.getListeOperande();
				}
			}
			else // cas operation
			{
				monOperation=operationExist(monInsert);
				if(monOperation==null)// insert n'est pas un nombre ni une opération
				{
					throw new ExceptionEntreeIncorrect();
				}
				else // l'entrée est une operation correcte
				{
					System.out.println(moteurRPN.resultatOperation(monOperation));
					moteurRPN.getListeOperande();
				}
			}
		} while (0==0);
	}

	/** Check si l'insert du user est bien un nombre
	 * @param insert
	 * @return boolean
	 */
	public boolean insertIsNomber(String insert)
	{
		try {
			Float a = Float.parseFloat(insert);
			return true;

		} catch (Exception e) {
			//System.out.println("Entrée incorrect");
			return false;
		}
	}

	/** Check si le nombre inserer par le user appartient a notre plage de valeur
	 * @param insert du user
	 * @return boolean
	 * @throws ExceptionIntervalSuperieur 
	 */
	public boolean verifIntervalValeur(String insert) throws ExceptionIntervalInferieur, ExceptionIntervalSuperieur
	{
		if((Float.parseFloat(monInsert)<=MAX_VALUE)&&(Float.parseFloat(monInsert)>=MIN_VALUE))
		{
			return true;
		}
		else 
		{
			if((Float.parseFloat(monInsert)>MAX_VALUE))
			{
				throw new ExceptionIntervalSuperieur(MIN_VALUE, MAX_VALUE);
			}
			else 
			{
				throw new ExceptionIntervalInferieur(MIN_VALUE, MAX_VALUE);
			}
			
		}
	}

	/** Verifie si la methode que veux inserer le user appartient a enumeration
	 * @param l'insert de l'utilisateur
	 * @return l'operation
	 */
	public Operation operationExist(String t)
	{
		Operation operation=null;
		for(Operation op : Operation.values()) //Pour verification operateur appartient
		{
			if(op.getSymbole().equals(monInsert))
			{
				operation=op;
			}
		}
		return operation;
	}
}

