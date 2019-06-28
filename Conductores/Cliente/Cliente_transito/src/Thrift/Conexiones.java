package Thrift;

import java.nio.ByteBuffer;
import java.util.List;
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
    TSocket  transport = new TSocket("localhost", 9090);
    TProtocol  protocol = new TBinaryProtocol(transport);
 
    ApiServidor.Client cliente = new ApiServidor.Client(protocol);
    
    public Conexiones() {
      
    }
    
    public int confirmarUsuario(long telefono, String contrasena) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean ingresoExitoso = cliente.confirmarConductor(telefono, contrasena);
            this.cerrarConexion();
            return ingresoExitoso ? 1 : 0;
        }
        return 2;
    }
    
    public boolean registrarConductor(Conductor conductor) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean registroExitoso = cliente.registrarConductor(conductor);
            this.cerrarConexion();
            return registroExitoso;
        }
        return false;
    }
    
    public int registrarVehiculo(Vehiculo vehiculo, long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean registroExitoso = cliente.registrarVehiculo(vehiculo, telefono);
            this.cerrarConexion();
            return registroExitoso ? 1 : 0;
        }
        return 2;
    }
    
    public List<Vehiculo> consultarVehiculoPropio(long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            List<Vehiculo> consultaExitosa = cliente.consultarVehiculoPropio(telefono);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public Vehiculo consultarVehiculoInfo(String numPlaca) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            Vehiculo consultaExitosa = cliente.consultarVehiculoInfo(numPlaca);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public boolean modificarVehiculo(Vehiculo vehiculo, String numPlacaAnt) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean modificacionExitosa = cliente.modificarVehiculo(vehiculo, numPlacaAnt);
            this.cerrarConexion();
            return modificacionExitosa;
        }
        return false;
    }
    
    public boolean deshabilitarVehiculo(String numPlaca) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean deshabilitacionExitosa = cliente.deshabilitarVehiculo(numPlaca);
            this.cerrarConexion();
            return deshabilitacionExitosa;
        }
        return false;
    }
    
    public Conductor consultarConductorPropio (long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            Conductor consultaExitosa = cliente.consultarConductorPropio(telefono);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public boolean registrarReporte(Reporte reporte, long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean registroExitoso = cliente.registrarReporte(reporte, telefono);
            this.cerrarConexion();
            System.out.println("registroExitoso " + registroExitoso);
            return registroExitoso;
            
        }
        return false;
    }
    
    public String registrarVehiculoReporte(Vehiculo vehiculo) throws ErrorBD, TException{
        
        String registroExitoso;
        if(this.abrirConexion()){
            
            registroExitoso = cliente.registrarVehiculoReporte(vehiculo);
            this.cerrarConexion();
            return registroExitoso;
        }
        return null;
    }
    
    public boolean registrarFotografia(List<String> fotografias, long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            /*boolean registroExitoso = cliente.registrarFotografia(fotografias, telefono);
            this.cerrarConexion();
            return registroExitoso;*/
        }
        return true;
    }
    
    public List<Reporte> consultarReporte(long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            List<Reporte> consultaExitosa = cliente.consultarReporte(telefono);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public List<Dictamen> consultarDictamen(List<Integer> folioUnico) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            List<Dictamen> consultaExitosa = cliente.consultarDictamen(folioUnico);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public List<Vehiculo> recuperarVehiculoReporte(int folioUnico_dictamen) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            List<Vehiculo> consultaExitosa = 
                    cliente.recuperarVehiculoReporte(folioUnico_dictamen);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public String recuperarNFuncionario(int folioUnico) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            String consultaExitosa = cliente.recuperarNFuncionario(folioUnico);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public boolean asociarVehiculoReporte(List<String> numPLacas, long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            boolean consultaExitosa = cliente.asociarVehiculoReporte(numPLacas, telefono);
            this.cerrarConexion();
            return consultaExitosa;
        }
        return false;
    }
    
    public List<Vehiculo> consultarFotografia(long telefono) throws ErrorBD, TException{
        
        if(this.abrirConexion()){
            
            List<Vehiculo> consultaExitosa = null; /*= cliente.consultarFotografia(0);*/
            this.cerrarConexion();
            return consultaExitosa;
        }
        return null;
    }
    
    public boolean abrirConexion(){
        
        boolean exitoConexion = true;
        try {
            
            this.transport.open();
        } catch (TTransportException ex) {
            
           System.out.println("<<No se puede conectar con servidor>>");
           exitoConexion = false;
        } finally {
            
            return exitoConexion;
        }
    }
    
     public void cerrarConexion(){
         this.transport.close();
    }

}
