package MetLibro;

/**
 *
 * @author Javier Delgado Rodriguez
 */
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

import Recursos.Const;

/**
 *
 * @author Javier Delgado Rodriguez
 */

/**
 * The Class Libro.
 */
public class Libro {

	/** The codigo. */
	public int codigo;

	/** The titulo. */
	public String titulo;

	/** The prestado. */
	public boolean prestado;

	/**
	 * Instantiates a new libro.
	 */
	public Libro() {
	}

	/**
	 * Instantiates a new libro.
	 *
	 * @param codigo   the codigo
	 * @param titulo   the titulo
	 * @param prestado the prestado
	 */
	public Libro(int codigo, String titulo, boolean prestado) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.prestado = prestado;
	}

	/**
	 * Obtener el tama�o o longitud de cada uno de los libros almacenados. Esta
	 * longitud es la suma del titulo (45 bytes), el codigo ID del libro (4 bytes) y
	 * un bollean que indica el estado del prestamo (1 byte).
	 * 
	 * TOTAL DE LA LONGITUD DEL REGISTRO = 50 bytes
	 *
	 * @return the tamano registro
	 */
	public static int getLongitudRegistroLibro() {
		return (Const.LONGITUDTITULO + 4 + 1);
	}

	/**
	 * Pasar stringa array bytes.
	 *
	 * @param s the nombre
	 * @return the byte[]
	 */
	byte[] pasarStringaArrayBytes(String s) {
		byte nombreB[] = new byte[Const.LONGITUDTITULO];
		for (int i = 0; i < s.length() && i < Const.LONGITUDTITULO; i++)
			nombreB[i] = (byte) s.charAt(i);
		for (int i = s.length(); i < Const.LONGITUDTITULO; i++)
			nombreB[i] = (byte) 0;
		return nombreB;
	}

	/**
	 * Elimina del string los caracteres vac�os (0)
	 * 
	 * @param s
	 * @return el string sin vac�os.
	 */
	String eliminarVacios(String s) {
		StringBuffer sb = new StringBuffer(s);
		int i = 0;
		while (sb.charAt(i) != (char) 0)
			i++;
		sb.setLength(i);
		return (sb.toString());
	}

	/**
	 * Escribir. Escribe un libro un archivo indicado
	 *
	 * @param f the f
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void escribir(RandomAccessFile f) throws IOException {
		f.writeInt(codigo);
		byte tituloAux[];
		tituloAux = pasarStringaArrayBytes(titulo);
		f.write(tituloAux);
		f.writeBoolean(prestado);
	}

	/**
	 * Leer. Lee los libros almacenados en el fichero, siempre que este fichero
	 * exista
	 *
	 * @param f the f
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public boolean leer(RandomAccessFile f) throws IOException {
		// devuelve true si lee algo y false si no devuelve nada
		try {
			codigo = f.readInt();

			byte tituloAux[] = new byte[Const.LONGITUDTITULO];
			f.read(tituloAux, 0, Const.LONGITUDTITULO);
			// titulo=new String(tituloAux, "UTF-8"); //convierte el array de bytes en un
			// string con la notaci�n UTF-8
			titulo = new String(tituloAux, "ISO-8859-1"); // Mejor 8859 para � y acentos.
			titulo = eliminarVacios(titulo);

			prestado = f.readBoolean();

			return true;
		} catch (EOFException e) {
			return false;
		}
	}

	/**
	 * Mostrar. Muestra los libros por consola
	 */
	public void mostrarLibro() {
		System.out.println("codigo: " + codigo + " | prestado: " + (prestado ? "SI" : "NO") + " | titulo: " + titulo);
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", prestado=" + prestado + "]";
	}

}
