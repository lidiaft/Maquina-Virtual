package tp.pr2.mv.instruction.compare;


import tp.pr2.mv.instruction.Instruction;

/**
 * Clase que crea una instruccion de tipo Le, y sirve para apilar un 1
 * si la subcima es menor o igual que la cima.
 * @author Lidia Flores, David Bolanios
 */
public class Le extends NumericCond {

	/**
	 * Constructora por defecto.
	 */
	public Le() {
		super();
	}

	/**
	 * Metodo que comprueba si la subcima es menor o igual que la cima.
	 * return true si la subcima es menor o igual que la cima, false en caso contrario.
	 */
	@Override
	protected boolean compare(int cima, int subcima) {
		return (subcima <= cima);
	}

	/**
	 * Parsea la instruccion segun el String pasado por parametro.
	 */
	@Override
	public Instruction parse(String[] s) {
		if (s.length==1 && s[0].equalsIgnoreCase("le")) 
			return new Le();
		else return null;
	}

	/**
	 * Devuelve la instruccion Le en forma de cadena.
	 */
	@Override
	public String toString() {
		return "LESS-OR-EQUALS";
	}

	
}
