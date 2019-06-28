/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peritos;

import Thrift.Conexiones;
import Thrift.ErrorBD;
import Thrift.VehiculosReporte;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.thrift.TException;

/**
 *
 * @author cris_
 */
public class Pruebas {
    
    
    public static void main(String[] args) {
        Conexiones conexiones = new Conexiones();
        try {
            List<VehiculosReporte> listaVehiculos = conexiones.getPlacasVehiculosReporte();
            if(listaVehiculos.isEmpty()){
                System.out.println("No hay registros");
            }else{
                ordenarLista(listaVehiculos);
            }
            
            
        } catch (ErrorBD error) {
            System.out.println("ERROR: " + error.codigoError + " " + error.problema);
            JOptionPane.showConfirmDialog(null, "Datos no diponibles, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } catch (TException ex) {
            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            JOptionPane.showConfirmDialog(null, "No se descargo la lista de reportes, intente más tarde", "Datos no disponibles", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private static void ordenarLista(List<VehiculosReporte> listaVehiculos){
         
      
        List<List<VehiculosReporte>> lista = new ArrayList<>();
        
        //nueva.add(new ArrayList<String>());
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if(lista.isEmpty()){
                lista.add(new ArrayList<VehiculosReporte>());
                lista.get(0).add(listaVehiculos.get(0));
            }else{
                boolean valorInsertado = false;
                for (int j = 0; j < lista.size(); j++) {
                    for (int k = 0; k < lista.get(j).size(); k++) {
                        if(lista.get(j).get(k).placaVehiculo2.equals(listaVehiculos.get(i).placaVehiculo1)){
                            System.out.println("Entra");
                            valorInsertado = true;
                            lista.get(j).add(listaVehiculos.get(i));
                           
                        }
                    }
                    
                }   
                if(valorInsertado == false){
                    lista.add(new ArrayList<VehiculosReporte>());
                    lista.get(lista.size()-1).add(listaVehiculos.get(i));
                }               
            }
        }
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Imprimiendo Lista " + i);
            for (int j = 0; j < lista.get(i).size(); j++) {
                System.out.println("Elemento "+ j + ": " + lista.get(i).get(j).placaVehiculo1);
            }
        }
    }
}
