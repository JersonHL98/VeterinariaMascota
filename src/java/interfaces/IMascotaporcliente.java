/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Mascotaporcliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jerson
 */
public interface IMascotaporcliente {

    public abstract boolean guardarMascotaporcliente(Mascotaporcliente mascotaporcliente);

    public abstract ArrayList<Mascotaporcliente> listarMascotaporcliente();

    public abstract boolean actualizarMascotaporcliente(Mascotaporcliente mascotaporcliente);

    public abstract boolean eliminarMascotaporcliente(Mascotaporcliente mascotaporcliente);

}
