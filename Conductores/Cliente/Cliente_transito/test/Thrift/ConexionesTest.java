/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thrift;

import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import java.util.List;/*
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;*/
import org.junit.runners.MethodSorters;

/**
 *
 * @author pxk
 */

public class ConexionesTest {
    
    //@FixMethodOrder((MethodSorters.NAME_ASCENDING));
    public ConexionesTest() {
        
    }

    /**
     * Test of confirmarUsuario method, of class Conexiones.
     */
    @Test
    public void testConfirmarUsuario() throws Exception {
        System.out.println("confirmarUsuario");
        long telefono = 2282113546L;
        String contrasena = "c0ec54caaf63ec95f8d12ac6095e183aaf697494a5f7bfc8856de059bb1bfd7a146f56a82a8ade4fc328fbe1f60cd017ae6e01c3b53975641b9dc9c040755442";
        Conexiones instance = new Conexiones();
        int expResult = 1;
        int result = instance.confirmarUsuario(telefono, contrasena);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of registrarConductor method, of class Conexiones.
     */
    /*@Test
    public void testRegistrarConductor() throws Exception {
        System.out.println("registrarConductor");
        Conductor conductor = new Conductor();
        conductor.setContrasena("c0ec59caaf63ec95f8d13ac6095e183aaf697494a5f6bfc8856de059bb1bfd7a146f56a82a8ade4fc328fbe1f60cd017ae6e01c3b53975641b9dc9c040755442");
        conductor.setCurp("ADMIYG289312HVMX00");
        conductor.setFechaNac("1997-04-03");
        conductor.setNombreComp("Juanito Perez M");
        conductor.setNumLicencia(1234);
        conductor.setTelefono(1122334455L);
        Conexiones instance = new Conexiones();
        boolean expResult = true;
        boolean result = instance.registrarConductor(conductor);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarVehiculo method, of class Conexiones.
     */
    /*@Test
    public void testRegistrarVehiculo() throws Exception {
        System.out.println("registrarVehiculo");
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAno(2014);
        vehiculo.setColor("Amarillo");
        vehiculo.setMarca("Mitsubishi");
        vehiculo.setEstatus(0);
        vehiculo.setModelo("Honda");
        vehiculo.setNumPlaca("MKO 9118");
        long telefono = 1122334455L;
        Conexiones instance = new Conexiones();
        int expResult = 1;
        int result = instance.registrarVehiculo(vehiculo, telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarVehiculoPropio method, of class Conexiones.
     */
    @Test
    public void testConsultarVehiculoPropio() throws Exception {
        System.out.println("consultarVehiculoPropio");
        long telefono = 2282113546L;
        Conexiones instance = new Conexiones();
        List<Vehiculo> expResult = new ArrayList();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAno(1999);
        vehiculo.setModelo("MOdelo");
        vehiculo.setNumPlaca("MIO1229");
        vehiculo.setColor("");
        vehiculo.setMarca("");
        vehiculo.setEstatus(0);
        vehiculo.setNomAseguradora("");
        vehiculo.setNumPoliza("");
        expResult.add(vehiculo);
        List<Vehiculo> result = instance.consultarVehiculoPropio(telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarVehiculoInfo method, of class Conexiones.
     */
    @Test
    public void testConsultarVehiculoInfo() throws Exception {
        System.out.println("consultarVehiculoInfo");
        String numPlaca = "MIO1229";
        Conexiones instance = new Conexiones();
        Vehiculo expResult = new Vehiculo();
        expResult.setAno(1999);
        expResult.setColor("COlor");
        expResult.setMarca("Marca");
        expResult.setEstatus(0);
        expResult.setModelo("MOdelo");
        expResult.setNumPlaca("MIO1229");
        expResult.setNomAseguradora("");
        expResult.setNumPoliza("");
        Vehiculo result = instance.consultarVehiculoInfo(numPlaca);
        assertEquals(expResult, result);
    }

    /**
     * Test of modificarVehiculo method, of class Conexiones.
     */
    @Test
    public void testModificarVehiculo() throws Exception {
        System.out.println("modificarVehiculo");
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAno(2014);
        vehiculo.setColor("Morado");
        vehiculo.setMarca("Mitsubishi");
        vehiculo.setEstatus(0);
        vehiculo.setModelo("Honda");
        vehiculo.setNumPlaca("GNO 9111");
        vehiculo.setNomAseguradora("");
        vehiculo.setNumPoliza("");
        String numPlacaAnt = "GNO 9111";
        Conexiones instance = new Conexiones();
        boolean expResult = true;
        boolean result = instance.modificarVehiculo(vehiculo, numPlacaAnt);
        assertEquals(expResult, result);
    }

    /**
     * Test of deshabilitarVehiculo method, of class Conexiones.
     */
    @Test
    public void testDeshabilitarVehiculo() throws Exception {
        System.out.println("deshabilitarVehiculo");
        String numPlaca = "GNO 9123";
        Conexiones instance = new Conexiones();
        boolean expResult = true;
        boolean result = instance.deshabilitarVehiculo(numPlaca);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarConductorPropio method, of class Conexiones.
     */
    @Test
    public void testConsultarConductorPropio() throws Exception {
        System.out.println("consultarConductorPropio");
        long telefono = 2282113546L;
        Conexiones instance = new Conexiones();
        Conductor expResult = new Conductor();
        expResult.setContrasena("");
        expResult.setCurp("AODOCE098712CVMX00");
        expResult.setEstatus(0);
        expResult.setFechaNac("26 jun 2019");
        expResult.setNombreComp("Pedro Pedro");
        expResult.setNumLicencia(12092398);
        expResult.setTelefono(telefono);
        Conductor result = instance.consultarConductorPropio(telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarReporte method, of class Conexiones.
     */
    @Test
    /*public void testRegistrarReporte() throws Exception {
        System.out.println("registrarReporte");
        Reporte reporte = new Reporte();
        reporte.setIdconductor1(1);
        reporte.setLatitud("91.18034");
        reporte.setLongitud("89.09876");
        reporte.setNombreOtroConduc("Juanito Perez M");
        long telefono = 2282113546L;
        Conexiones instance = new Conexiones();
        boolean expResult = true;
        boolean result = instance.registrarReporte(reporte, telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarVehiculoReporte method, of class Conexiones.
     */
    /*@Test
    public void testRegistrarVehiculoReporte() throws Exception {
        System.out.println("registrarVehiculoReporte");
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAno(2004);
        vehiculo.setColor("Rosado");
        vehiculo.setMarca("GMC");
        vehiculo.setEstatus(0);
        vehiculo.setModelo("Sonic");
        vehiculo.setNumPlaca("RTV 9118");
        vehiculo.setNumPoliza("");
        vehiculo.setNomAseguradora("");
        Conexiones instance = new Conexiones();
        String expResult = "RTV 9118";
        String result = instance.registrarVehiculoReporte(vehiculo);
        assertEquals(expResult, result);
    }

    /**
     * Test of registrarFotografia method, of class Conexiones.
     */
    /*@Test
    public void testRegistrarFotografia() throws Exception {
        System.out.println("registrarFotografia");
        List<String> fotografias = null;
        long telefono = 0L;
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.registrarFotografia(fotografias, telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarReporte method, of class Conexiones.
     */
    @Test
    public void testConsultarReporte() throws Exception {
        System.out.println("consultarReporte");
        long telefono = 2282113546L;
        Conexiones instance = new Conexiones();
        List<Reporte> expResult = new ArrayList();
        Reporte reporte = new Reporte();
        reporte.setIdconductor1(1);
        reporte.setLatitud("91.18034");
        reporte.setLongitud("89.09876");
        reporte.setNombreOtroConduc("Juanito Perez M");
        expResult.add(reporte);
        List<Reporte> result = instance.consultarReporte(telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarDictamen method, of class Conexiones.
     */
    @Test
    public void testConsultarDictamen() throws Exception {
        System.out.println("consultarDictamen");
        List<Integer> folioUnico = new ArrayList();
        folioUnico.add(0);
        Conexiones instance = new Conexiones();
        List<Dictamen> expResult = new ArrayList();
        List<Dictamen> result = instance.consultarDictamen(folioUnico);
        assertEquals(expResult, result);
    }

    /**
     * Test of recuperarVehiculoReporte method, of class Conexiones.
     */
    @Test
    public void testRecuperarVehiculoReporte() throws Exception {
        System.out.println("recuperarVehiculoReporte");
        int folioUnico_dictamen = 1;
        Conexiones instance = new Conexiones();
        List<Vehiculo> expResult = new ArrayList();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAno(1999);
        vehiculo.setColor("COlor");
        vehiculo.setMarca("Marca");
        vehiculo.setEstatus(0);
        vehiculo.setModelo("MOdelo");
        vehiculo.setNumPlaca("MIO1229");
        vehiculo.setNumPoliza("");
        vehiculo.setNomAseguradora("");
        Vehiculo vehiculo2 = new Vehiculo();
        vehiculo2.setAno(2006);
        vehiculo2.setColor("negro");
        vehiculo2.setMarca("Mericano");
        vehiculo2.setEstatus(0);
        vehiculo2.setModelo("Red Flag");
        vehiculo2.setNumPlaca("GNO 9123");
        vehiculo2.setNumPoliza("");
        vehiculo2.setNomAseguradora("");
        expResult.add(vehiculo);
        expResult.add(vehiculo2);
        List<Vehiculo> result = instance.recuperarVehiculoReporte(folioUnico_dictamen);
        assertEquals(expResult, result);
    }

    /**
     * Test of recuperarNFuncionario method, of class Conexiones.
     */
    @Test
    public void testRecuperarNFuncionario() throws Exception {
        System.out.println("recuperarNFuncionario");
        int folioUnico = 1;
        Conexiones instance = new Conexiones();
        String expResult = "Mario Morales";
        String result = instance.recuperarNFuncionario(folioUnico);
        assertEquals(expResult, result);
    }

    /**
     * Test of asociarVehiculoReporte method, of class Conexiones.
     */
    @Test
    public void testAsociarVehiculoReporte() throws Exception {
        System.out.println("asociarVehiculoReporte");
        List<String> numPLacas = new ArrayList();
        numPLacas.add("MIO1229");
        numPLacas.add("GNO 9123");
        long telefono = 2282113546L;
        Conexiones instance = new Conexiones();
        boolean expResult = true;
        boolean result = instance.asociarVehiculoReporte(numPLacas, telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarFotografia method, of class Conexiones.
     */
    /*@Test
    public void testConsultarFotografia() throws Exception {
        System.out.println("consultarFotografia");
        long telefono = 0L;
        Conexiones instance = new Conexiones();
        List<Vehiculo> expResult = null;
        List<Vehiculo> result = instance.consultarFotografia(telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of abrirConexion method, of class Conexiones.
     */
    @Test
    public void testAbrirConexion() {
        System.out.println("abrirConexion");
        Conexiones instance = new Conexiones();
        boolean expResult = true;
        boolean result = instance.abrirConexion();
        assertEquals(expResult, result);
    }
    
}
