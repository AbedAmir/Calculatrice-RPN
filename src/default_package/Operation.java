package default_package;

public enum Operation {
	PLUS("+") {
		@Override
		public float eval(float a, float b) {
			return a+b;
		}
	},MOINS("-") {
		@Override
		public float eval(float a, float b) {
			return a-b;
		}
	},MULT("*") {
		@Override
		public float eval(float a, float b) {
			return a*b;
		}
	},DIV("/") {
		@Override
		public float eval(float a, float b) throws ArithmeticException {
			if(b==0)
			{
				throw new ArithmeticException("Division par 0 impossible");
			}
			return a/b;
		}
	};

	private String symbole="";

	private Operation(String symbole) {
		this.symbole=symbole;
	}
	
	private Operation(int a ) {
		
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public Operation getOperation(String symbole)
	{
		return valueOf(symbole);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(symbole);
	}
	public abstract float eval(float a , float b) throws ArithmeticException;

}
