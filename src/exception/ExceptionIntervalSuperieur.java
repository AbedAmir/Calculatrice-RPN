package exception;

public class ExceptionIntervalSuperieur extends Exception{
	public ExceptionIntervalSuperieur(int min, int max)
	{
		super("Le nombre est plus grand que l'interval : ["+min+","+max+"]");
	}
}
