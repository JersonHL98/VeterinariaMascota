/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Cliente;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author LeguiA
 */
public interface ICliente {

    public abstract boolean guardarCliente(Cliente cliente);

    public abstract ArrayList<Cliente> listarClientes();

    public abstract boolean actualizarCliente(Cliente cliente);

    public abstract boolean eliminarCliente(Cliente cliente);

    public abstract ArrayList<Cliente> listPastor(Session session);

    public abstract ArrayList<Cliente> listSANDOR(Session session);

    public abstract Integer listCount(Session sesion);
}
