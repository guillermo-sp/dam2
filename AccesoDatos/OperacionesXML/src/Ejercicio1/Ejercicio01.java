package Ejercicio1;

import Herramientas.Herramientas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class Ejercicio01 {

    public static void main(String args[]) {

        // Leemos el XML y lo metemos en un document
        Document doc = null;
        try {
            doc = new SAXBuilder().build("C:\\petra\\tienda.xml");
        } catch (JDOMException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cogemos el element root
        Element root = doc.getRootElement();

        // Modificamos el atributo precio del hijo nivel
        root.getChild("nivel").setAttribute("precio", "2300");

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXML(doc);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Eliminamos el atributo precio del hijo historieta
        root.getChild("historieta").removeAttribute("precio");

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXML(doc);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Modificamos en root el atributo ubicacion por localidad
        root.getAttribute("ubicacion").setName("localidad");

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXML(doc);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Modificamos el precio de computadora a 2300
        root.getChild("computadora").setAttribute("precio","2300");

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXML(doc);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Anadir nueva etiqueta empleado con atributo cargo, con valor responsable
        root.addContent(new Element("empleado").setAttribute("cargo","empleado"));

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXML(doc);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Eliminar la etiqueta libro
        root.removeChild("libro");

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXML(doc);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
