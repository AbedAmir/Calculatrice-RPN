package Test;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

import default_package.MoteurRPN;
import default_package.Operation;
import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

public class MoteurRPNTest {
	float a;
	
	@Test(expected=EmptyStackException.class)
	public void afficherUneListeOperandesVide() {
		MoteurRPN moteurRPN = new MoteurRPN();
		moteurRPN.getListeOperande();
	}

	@Test(expected=ExceptionNombreOperandesEgaleZero.class)
	public void resultatOperationAvecZeroOperande() throws ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn{
		MoteurRPN moteurRPN = new MoteurRPN();
		a=moteurRPN.resultatOperation(Operation.PLUS);
	}
	
	@Test(expected=ExceptionNombreOperandesEgaleUn.class)
	public void resultatOperationAvecUneOperande() throws ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn{
		MoteurRPN moteurRPN = new MoteurRPN();
		moteurRPN.addOperande(5);
		a=moteurRPN.resultatOperation(Operation.PLUS);
	}
	
	@Test()
	public void resultatOperationAvecCalcul() throws ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn{
		MoteurRPN moteurRPN = new MoteurRPN();
		moteurRPN.addOperande(2);
		moteurRPN.addOperande(3);
		moteurRPN.addOperande(4);
		moteurRPN.resultatOperation(Operation.PLUS);
		moteurRPN.resultatOperation(Operation.MULT);
		assertEquals(14, (float)moteurRPN.getE().get(moteurRPN.getE().size()-1),0);

	}

}
