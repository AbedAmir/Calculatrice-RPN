package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import default_package.Operation;
import default_package.SaisieRPN;
import exception.ExceptionEntreeIncorrect;
import exception.ExceptionIntervalInferieur;
import exception.ExceptionIntervalSuperieur;
import exception.ExceptionNombreOperandesEgaleUn;
import exception.ExceptionNombreOperandesEgaleZero;

public class SaisieRPNTest {

	@Test (expected=ExceptionEntreeIncorrect.class)
	public void entréeIncorrecte() throws ExceptionEntreeIncorrect, ExceptionIntervalInferieur, ExceptionIntervalSuperieur, ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn {
		SaisieRPN saisieRPN = new SaisieRPN();
	}
	
	@Test
	public void entreeIsNumber()
	{
		SaisieRPN saisieRPN = new SaisieRPN(6);
		assertTrue(saisieRPN.insertIsNomber("5"));
	}
	
	@Test
	public void entreeIsNotNumber()
	{
		SaisieRPN saisieRPN = new SaisieRPN(6);
		assertFalse(saisieRPN.insertIsNomber("5b"));
	}
	
	@Test(expected=ExceptionIntervalInferieur.class)
	public void insertValInferieurMinVal() throws ExceptionIntervalInferieur, ExceptionEntreeIncorrect, ExceptionIntervalSuperieur, ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn {
		SaisieRPN saisieRPN = new SaisieRPN();
	}
	
	@Test(expected=ExceptionIntervalSuperieur.class)
	public void insertValSuperieurMaxVal() throws ExceptionIntervalInferieur, ExceptionEntreeIncorrect, ExceptionIntervalSuperieur, ExceptionNombreOperandesEgaleZero, ExceptionNombreOperandesEgaleUn{
		SaisieRPN saisieRPN = new SaisieRPN();
	}
	
}
