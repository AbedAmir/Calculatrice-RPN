package exception;

public class ExceptionIntervalInferieur extends Exception {
	public ExceptionIntervalInferieur(int min, int max)
	{
		super("Le nombre est plus petit que l'interval : ["+min+","+max+"]");
	}
}
