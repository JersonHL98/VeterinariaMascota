/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.UsuarioDao;
import entidades.Usuario;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jerson
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private boolean banderaSelect;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean() {
        this.usuario = new Usuario();
    }

    public String guardarUsuario() {

        UsuarioDao dao = new UsuarioDao();
        boolean respuesta = dao.guardarUsuario(usuario);

        if (respuesta) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Se Registro Crrectamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/RegistroUsuario.xhtml";
    }

    public String actualizarUsuario() {
        UsuarioDao dao = new UsuarioDao();
        boolean respuesta = dao.actualizarUsuario(usuario);
        if (respuesta) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro actualizo con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo actualizar"));
        }
        return "/RegistroUsuario.xhtml";
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> milista = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        milista = dao.listarUsuarios();

        return milista;
    }

    public String limpiar() {
        return "/RegistroUsuario.xhtml";
    }

    public String eliminarUsuario() {
        UsuarioDao dao = new UsuarioDao();
        boolean respuesta = dao.eliminarUsuario(usuario);
        if (respuesta) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro Borrado con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo eliminar"));
        }
        return "/RegistroUsuario.xhtml";
    }
     public void selectBandera(){
        banderaSelect= true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
}
