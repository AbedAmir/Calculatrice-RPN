package default_package;

import java.util.ArrayList;
import java.util.EmptyStackException;

import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

public class MoteurRPN {

	ArrayList<Float> e;

	public MoteurRPN()
	{
		e= new ArrayList<>();
	}

	public ArrayList<Float> getE() {
		return e;
	}

	/** Empile la valeur entr�e par le user
	 * @param x : la valeur entr�e par le user 
	 */
	public void addOperande(float x)
	{
		e.add(x);
	}

	/** Retourne toutes les operandes de ma pile
	 * 
	 */
	public void getListeOperande() {
		if(e.isEmpty())
		{
			throw new EmptyStackException();
		}
		System.out.println();
		System.out.println("Votre pile contient : ");
		System.out.print("{");
		for(int i=0;i<this.e.size();i++)
		{
			System.out.print(e.get(i)+" , ");
		}
		System.out.print("}");
		System.out.println();
	}

	/** Calcul le resultat de l'operation avec les 2 operandes de la pile
	 * @param op Operation
	 * @return resultat de l'operation sur les 2 premiers operandes de la pile
	 * @throws Exception
	 */
	public float resultatOperation(Operation op) throws ExceptionNombreOperandesEgaleZero,ExceptionNombreOperandesEgaleUn
	{
		int size;
		if(e.size()>=2)
		{
			size=e.size();
			float a = e.remove(size-1);
			float b = e.remove(size-2);
			this.addOperande(op.eval(a, b));
			System.out.print(a+" "+op+" "+b+" = ");
			return op.eval(a, b);
		}
		else if(e.size()==1)
		{
			throw new ExceptionNombreOperandesEgaleUn();
			//throw new Exception("Vous devez entrez au moins 1 operande supp --> La pile contient une seule operande");
		}
		else 
		{
			throw new ExceptionNombreOperandesEgaleZero();
			//throw new Exception("Vous devez entrez au moins 2 operandes sup --> La pile contient ne contient pas d'operande");
		}
	}
}
