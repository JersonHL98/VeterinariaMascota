/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import interfaces.ICliente;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author Jerson
 */
public class ClienteDao implements ICliente {

    @Override
      public boolean guardarCliente(Cliente cliente) {
//Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la cliente
        try {
            sesion.save(cliente);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARDAR::" + e);
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Cliente> milista = new ArrayList<>();
        //Crear la consulta hacia la base de datos
        Query query = session.createQuery("FROM Cliente");

        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Cliente>) query.list();
        System.out.println("tam"+milista.size());
        session.close();
        return milista;

    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(cliente);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {

        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.delete(cliente);
            transaccion.commit();
            respuesta = true;
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

}
