/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thrift;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author cris_
 */
public class Conexiones {
    TSocket  transport = new TSocket("192.168.43.17", 9090);
    TProtocol  protocol = new TBinaryProtocol(transport);
 
    ApiFuncionario.Client cliente = new ApiFuncionario.Client(protocol);
    
    public Conexiones() {
  
            
    }
    
    
    /*FUNCIONARIOS*/
    
    /*Verifica el usuario y contraseña del Funcionario*/
    public boolean verificarFuncionario(String usuario, String contrasena) throws ErrorBD, TException {
        this.abrirConexion();
        boolean respuesta = cliente.verificarFuncionario(usuario, contrasena);
        this.cerrarConexion();
        return respuesta;
    }
    
    public Funcionario getFuncionario(String usuario) throws ErrorBD, TException{
        this.abrirConexion();
        Funcionario funcionario = cliente.getFuncionario(usuario);
        this.cerrarConexion();
        return funcionario;
    }
    
    
    /*PERITOS*/
    
    public boolean registrarPerito(Funcionario perito) throws ErrorBD, TException{
        this.abrirConexion();
        boolean respuesta = cliente.registrarPerito(perito);
        this.cerrarConexion();
        return respuesta;
    }
    
    public List<Funcionario> getPeritos() throws ErrorBD, TException{
        this.abrirConexion();
        List<Funcionario> listaPeritos = cliente.getPeritos();
        this.cerrarConexion();
        return listaPeritos;
    }
    
    public boolean cambiarEstatusFuncionario(String usuario) throws ErrorBD, TException{
        this.abrirConexion();
        boolean respuesta = cliente.cambiarEstatusFuncionario(usuario);
        this.cerrarConexion();
        return respuesta;
    }
    
    public boolean modificarPerito(Funcionario peritoAnterior, Funcionario peritoNuevo) throws ErrorBD, TException{
        this.abrirConexion();
        boolean respuesta = cliente.modificarPerito(peritoAnterior, peritoNuevo);
        this.cerrarConexion();
        return respuesta;
    }
    
    public boolean cambiarContrasenaFuncionario(String usuario, String contrasena) throws ErrorBD, TException{
        this.abrirConexion();
        boolean respuesta = cliente.cambiarContrasenaPerito(usuario, contrasena);
        this.cerrarConexion();
        return respuesta;
    }
    
    public int getIdPerito(String usuarioPerito) throws ErrorBD, TException{
        this.abrirConexion();
        int respuesta = cliente.getIdPerito(usuarioPerito);
        this.cerrarConexion();
        return respuesta;
    }
    
    
    //REPORTES
    
    public List<Reporte> getReportesPendientes() throws ErrorBD, TException{
        this.abrirConexion();
        List<Reporte> respuesta = cliente.getReportesPendientes();
        this.cerrarConexion();
        return respuesta;
    }
    
    public List<Reporte> getReportesAsignados(String usuarioPerito) throws ErrorBD, TException{
        this.abrirConexion();
        int idPerito = getIdPerito(usuarioPerito);
        this.cerrarConexion();
        this.abrirConexion();
        List<Reporte> respuesta = cliente.getReportesAsignados(idPerito);
        this.cerrarConexion();
        return respuesta;
    }
    
    
    public Reporte getReporte(int idReporte) throws ErrorBD, TException{
        this.abrirConexion();
        Reporte respuesta = cliente.getReporte(idReporte);
        this.cerrarConexion();
        return respuesta;
    }
    
    
    
    public boolean asignarReportePerito(String usuarioPerito,  int idReporte) throws ErrorBD, TException{
        this.abrirConexion();
        int idPerito = getIdPerito(usuarioPerito);
        this.cerrarConexion();
       
        this.abrirConexion();
        boolean respuesta = cliente.asignarReportePerito(idPerito, idReporte);
        this.cerrarConexion();
        
        return respuesta;
    }
    
    
    //DICTAMEN
    
    public Dictamen getDictamen(int idReporte) throws ErrorBD, TException{
        this.abrirConexion();
        Dictamen dictamen = cliente.getDictamen(idReporte);
        this.cerrarConexion();
        return dictamen;
    } 
    
    public boolean levantarDictamen(Dictamen dictamen) throws ErrorBD, TException{
        this.abrirConexion();
        boolean respuesta = cliente.levantarDictamen(dictamen);
        this.cerrarConexion();
        return respuesta;
    }
    
    
    public List<VehiculosReporte> getPlacasVehiculosReporte() throws ErrorBD, TException{
        this.abrirConexion();
        List<VehiculosReporte> respuesta = cliente.getPlacasVehiculosReporte();
        this.cerrarConexion();
        return respuesta;
    }
    
    
    /*IMAGENES*/
    
    public boolean cargarImagenes(List<ByteBuffer> listaImagenes, int idReporte) throws ErrorBD, TException{
        this.abrirConexion();
        boolean respuesta = cliente.cargarImagenes(listaImagenes, idReporte);
        this.cerrarConexion();
        return respuesta;
    }
    
    
    public void abrirConexion(){
        try {
            this.transport.open();
        } catch (TTransportException ex) {
           System.out.println("No se puede conectar con servidor");
        }
    }
    
     public void cerrarConexion(){
         this.transport.close();
    }
     
     
      public String getSHA256(String entrada){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(entrada.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
	           System.out.println("No se generearon las llaves");
	}
	
	return toReturn;
    }

}
