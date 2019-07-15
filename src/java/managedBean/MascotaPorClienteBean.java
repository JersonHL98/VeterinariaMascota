/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import dao.MascotaporclienteDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
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
public class MascotaPorClienteBean {
    
    private ArrayList listaClientes;
     private ClienteDao objClientesDao;
     private MascotaDao mascotadao;
     private MascotaporclienteDao mascotaPorClienteDao;
     private Mascotaporcliente mascotaPorCliente;
     MascotaporclienteId mascotaporclienteId;
     private int idCliente1;
     private int idMascota;
     private ArrayList listaMascotas;
     boolean respuesta;

    public MascotaPorClienteBean() {
        
        listaClientes = new ArrayList();
        mascotaPorCliente = new Mascotaporcliente();
        mascotaporclienteId = new MascotaporclienteId();
        listarCombos();
        
    }
    
    public void listarCombos(){
        
        objClientesDao = new ClienteDao();
        mascotadao = new MascotaDao();
        listaClientes = objClientesDao.listarClientes();
        listaMascotas = mascotadao.listarMascotas();
        
    }
    
     public String insertMascotaPorCliente(){
        
        mascotaPorClienteDao = new MascotaporclienteDao();
        mascotaporclienteId.setIdCliente(idCliente1);
        mascotaporclienteId.setIdMascota(idMascota);
        mascotaPorCliente.setId(mascotaporclienteId);
        respuesta = mascotaPorClienteDao.guardarMascotaporcliente(mascotaPorCliente);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/MascotaPorCliente";
        
    }
        

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    
    public int getIdCliente1() {
        return idCliente1;
    }

    public void setIdCliente1(int idCliente1) {
        this.idCliente1 = idCliente1;
    }
    

    public ArrayList getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public Mascotaporcliente getMascotaPorCliente() {
        return mascotaPorCliente;
    }

    public void setMascotaPorCliente(Mascotaporcliente mascotaPorCliente) {
        this.mascotaPorCliente = mascotaPorCliente;
    }

   
    
}
