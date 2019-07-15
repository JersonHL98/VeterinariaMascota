/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import interfaces.IUsuario;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 
 */
public class UsuarioDao implements IUsuario {

    @Override
      public boolean guardarUsuario(Usuario usuario) {
//Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la usuario
        try {
            sesion.save(usuario);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARDAR::" + e);
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Usuario> milista = new ArrayList<>();
        //Crear la consulta hacia la base de datos
        Query query = session.createQuery("FROM Usuario");

        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Usuario>) query.list();
        System.out.println("tam"+milista.size());
        session.close();
        return milista;

    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(usuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {

        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.delete(usuario);
            transaccion.commit();
            respuesta = true;
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

}