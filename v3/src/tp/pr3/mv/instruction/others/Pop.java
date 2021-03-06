package tp.pr3.mv.instruction.others;


import tp.pr3.mv.CPU;
import tp.pr3.mv.instruction.Instruction;
import tp.pr3.mv.instruction.exceptionIns.InstructionExecutionException;
import tp.pr3.mv.instruction.exceptionIns.WrongInstructionFormatException;

/**
 * Clase que crea una instruccion de tipo Pop, y sirve para extraer un elemento en la
 * pila.
 * @author Lidia Flores, David Bolanios
 */
public class Pop extends RestSeq {

	/**
	 * Constructora por defecto.
	 */
	public Pop() {
		super();
	}

	/**
	 * Extrae un elemento de la pila.
	 * @param cpu la cual se modifica.
	 * @throws InstructionExecutionException si no hay suficientes elementos en la pila.
	 */
	@Override
	protected void executeAux(CPU cpu) throws InstructionExecutionException {
		if(cpu.getNumElem() > 0)
			cpu.pop();
		else 	
			throw new InstructionExecutionException
				("Error ejecutando " + this.toString() + ": faltan operandos en la pila (hay " + cpu.getNumElem() + ")");
		
	}

	/**
	 * Parsea la instruccion segun el String pasado por parametro.
	 * @throws WrongInstructionFormatException si hahy error en el parseo.
	 */
	@Override
	public Instruction parse(String[] s) throws WrongInstructionFormatException {
		if (s.length==1 && s[0].equalsIgnoreCase("pop")) 
			return new Pop();
		else throw new WrongInstructionFormatException();
	}

	/**
	 * Devuelve la instruccion Pop en forma de cadena.
	 */
	@Override
	public String toString() {
		return "POP";
	}

}
