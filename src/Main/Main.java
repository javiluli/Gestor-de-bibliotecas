/**
 *
 * @author Javier Delgado Rodriguez
 */
package Main;

import MetLibro.RAFLibros;
import MetUsuario.RAFUsuarios;
import PrestamoLibro.LibroAsignadoA;
import PrestamoLibro.Prestamo;
import Recursos.Archivos;
import Recursos.Teclado;

/**
 * The Class Main.
 */
public class Main {
	/**
	 * NOTA: Hay una exceso de metodos estaticos, quise probar para ver que podia
	 * hacer y que cosas me permitia y, de mismo modo que me ha sucedido con la
	 * herencia y polimorfismo, entiendo que cosas deberia cambiar.
	 * 
	 * Despues de hacer el mismo ejercicio 2 veces de diferente forma si tubiera que
	 * hacerlo otra vez cambiaria muchas cosas, aplicando el ultimo tema de
	 * Herencia, polimorfismo, interfaces, etc...
	 * 
	 * Hay cosas un poco raras que, de nuevo, haria ahora diferente y mejor
	 * estructurado, por ejemplo del fichero de libros y usuarios se crea un backup
	 * pero de los libros asignados a usuarios no, ahora gracais a polimorfismo
	 * iguaal si podria hacer algo mas compacto apra todo.
	 * 
	 * He dejado algunos ejemplos ya implementados, usuarios y libros agregados y
	 * muchas anotaciones.
	 * 
	 * ENUNCIADO DEL EJERCICIO
	 * #######################################################
	 * 
	 * Realizar una aplicaci�n para gestionar una biblioteca. En la biblioteca se
	 * dispone de libros (no m�s de 2000), de los que se tiene almacenado el c�digo
	 * (int entre 0 y 1999) y el t�tulo. La biblioteca tiene usuarios. Cada usuario
	 * est� identificado por un identificador (int) y puede tener prestados un
	 * m�ximo de 5 libros, tambi�n se almacena el nombre del usuario. Se supondr�
	 * que no hay m�s de 100 usuarios. La aplicaci�n debe mostrar un men� que
	 * permita realizar las siguientes operaciones:
	 * 
	 * 1.- Alta de libros. Se pedir� el c�digo y el t�tulo y se guardar� como
	 * almacenado
	 * 
	 * 2.- Alta de usuarios. Se pedir� el nombre del mismo y se le asignar� un
	 * identificador (entre 0 y 99 ) de entre los disponibles (no asignado a otro
	 * usuario)
	 * 
	 * 3.- Baja de usuarios. Se pedir� el identificador y, si no tiene libros en
	 * pr�stamo, se le dar� de baja. Si tiene libros en pr�stamo no se le podr� dar
	 * de baja y se mostrar� un mensaje indic�ndolo.
	 * 
	 * 4.- Pr�stamo de libros. Se pedir� por teclado el identificador del usuario y
	 * el c�digo del libro y si el libro est� disponible (se supone que s�lo hay un
	 * ejemplar de cada libro) se le prestar� al usuario.
	 * 
	 * 5.- Devoluci�n de libro. Se pedir� por teclado el identificador del usuario y
	 * el c�digo del libro que devuelve y, si lo ten�a en pr�stamo, se considerar�
	 * devuelto.
	 * 
	 * 6.- Consulta de libro. Se pedir� por teclado el c�digo de un libro y se
	 * indicar� si est� o no en pr�stamo y en caso de estar prestado el c�digo y
	 * nombre del usuario que lo tiene.
	 * 
	 * 7.- Listado de usuarios. Se mostrar�n en pantalla los identificadores y
	 * nombres de usuarios y los t�tulos de los libros que posee cada usuario.
	 * 
	 * 8.- Listado de libros no prestados: Se mostrar� en pantalla los c�digos y
	 * t�tulos de todos los libros no prestados.
	 * 
	 * 0.- Fin de la aplicaci�n.
	 * 
	 * A�ADIDOS EXTRA EN LA APLICACION Y NOTAS
	 * #######################################
	 * 
	 * 9.- Muestra en pantalla un listado de todos los libros almacenados, esten o
	 * no esten prestados.
	 * 
	 * 10.- Muestra en pantalla a cada usuario con sus libros prestados, si no tiene
	 * libros prestados no sera mostrado.
	 * 
	 * 11.- Muestra en pantalla un listado, ordenado por el codigo de libro, os
	 * libros y el usuario al que se ha asignado como prestado
	 * 
	 * Se deber� realizar cada opci�n en un m�todo diferente.
	 */
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		Teclado t = new Teclado();
		int n;
		Archivos.crearFichero();
		System.out.println();

		// =============================================
		do {
			Menu.opcionesMenu();
			n = t.leerInt();
			switch (n) {
			case 1:
				Menu.guardarLibro();
				break;

			case 2:
				Menu.guardarUsuario();
				break;

			case 3:
				Menu.borrarUsuario();
				break;

			case 4:
				Menu.prestarLibroAUsuario();
				break;

			case 5:
				Menu.devoluciones();
				break;

			case 6:
				Menu.consultaLibro();
				break;

			case 7:
				RAFUsuarios.mostrarFicheroUsuarios();
				break;

			case 8:
				RAFLibros.verLibrosNoPrestados();
				break;

			case 9:
				RAFLibros.mostrarFicheroLibros();
				break;

			case 10:
				Prestamo.mostrarPrestamos();
				break;

			case 11:
				LibroAsignadoA.mostrarAsignaciones();
				break;

			case 12:
				System.out.println("Seleccione un usuario para su consulta");
				Prestamo.leerRegistro(t.leerInt());

			}
		} while (n != 0);
	}
}
