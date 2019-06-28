/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thrift;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cris_
 */
public class ConexionesTest {
    
    public ConexionesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verificarFuncionario method, of class Conexiones.
     */
    @Test
    public void testVerificarFuncionario() throws Exception {
        System.out.println("verificarFuncionario");
        String usuario = "CRISTIAN";
        String contrasena = "1234656789";
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.verificarFuncionario(usuario, contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuncionario method, of class Conexiones.
     */
    @Test
    public void testGetFuncionario() throws Exception {
        System.out.println("getFuncionario");
        String usuario = "CRISTIAN";
        Conexiones instance = new Conexiones();
        Funcionario expResult = null;
        Funcionario result = instance.getFuncionario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarPerito method, of class Conexiones.
     */
    @Test
    public void testRegistrarPerito() throws Exception {
        System.out.println("registrarPerito");
        Funcionario perito = null;
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.registrarPerito(perito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeritos method, of class Conexiones.
     */
    @Test
    public void testGetPeritos() throws Exception {
        System.out.println("getPeritos");
        Conexiones instance = new Conexiones();
        List<Funcionario> expResult = null;
        List<Funcionario> result = instance.getPeritos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstatusFuncionario method, of class Conexiones.
     */
    @Test
    public void testCambiarEstatusFuncionario() throws Exception {
        System.out.println("cambiarEstatusFuncionario");
        String usuario = "";
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.cambiarEstatusFuncionario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarPerito method, of class Conexiones.
     */
    @Test
    public void testModificarPerito() throws Exception {
        System.out.println("modificarPerito");
        Funcionario peritoAnterior = null;
        Funcionario peritoNuevo = null;
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.modificarPerito(peritoAnterior, peritoNuevo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarContrasenaFuncionario method, of class Conexiones.
     */
    @Test
    public void testCambiarContrasenaFuncionario() throws Exception {
        System.out.println("cambiarContrasenaFuncionario");
        String usuario = "";
        String contrasena = "";
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.cambiarContrasenaFuncionario(usuario, contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPerito method, of class Conexiones.
     */
    @Test
    public void testGetIdPerito() throws Exception {
        System.out.println("getIdPerito");
        String usuarioPerito = "";
        Conexiones instance = new Conexiones();
        int expResult = 0;
        int result = instance.getIdPerito(usuarioPerito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReportesPendientes method, of class Conexiones.
     */
    @Test
    public void testGetReportesPendientes() throws Exception {
        System.out.println("getReportesPendientes");
        Conexiones instance = new Conexiones();
        List<Reporte> expResult = null;
        List<Reporte> result = instance.getReportesPendientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReportesAsignados method, of class Conexiones.
     */
    @Test
    public void testGetReportesAsignados() throws Exception {
        System.out.println("getReportesAsignados");
        String usuarioPerito = "";
        Conexiones instance = new Conexiones();
        List<Reporte> expResult = null;
        List<Reporte> result = instance.getReportesAsignados(usuarioPerito);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReporte method, of class Conexiones.
     */
    @Test
    public void testGetReporte() throws Exception {
        System.out.println("getReporte");
        int idReporte = 0;
        Conexiones instance = new Conexiones();
        Reporte expResult = null;
        Reporte result = instance.getReporte(idReporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of asignarReportePerito method, of class Conexiones.
     */
    @Test
    public void testAsignarReportePerito() throws Exception {
        System.out.println("asignarReportePerito");
        String usuarioPerito = "";
        int idReporte = 0;
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.asignarReportePerito(usuarioPerito, idReporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDictamen method, of class Conexiones.
     */
    @Test
    public void testGetDictamen() throws Exception {
        System.out.println("getDictamen");
        int idReporte = 0;
        Conexiones instance = new Conexiones();
        Dictamen expResult = null;
        Dictamen result = instance.getDictamen(idReporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of levantarDictamen method, of class Conexiones.
     */
    @Test
    public void testLevantarDictamen() throws Exception {
        System.out.println("levantarDictamen");
        Dictamen dictamen = null;
        Conexiones instance = new Conexiones();
        boolean expResult = false;
        boolean result = instance.levantarDictamen(dictamen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlacasVehiculosReporte method, of class Conexiones.
     */
    @Test
    public void testGetPlacasVehiculosReporte() throws Exception {
        System.out.println("getPlacasVehiculosReporte");
        Conexiones instance = new Conexiones();
        List<VehiculosReporte> expResult = null;
        List<VehiculosReporte> result = instance.getPlacasVehiculosReporte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of abrirConexion method, of class Conexiones.
     */
    @Test
    public void testAbrirConexion() {
        System.out.println("abrirConexion");
        Conexiones instance = new Conexiones();
        instance.abrirConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarConexion method, of class Conexiones.
     */
    @Test
    public void testCerrarConexion() {
        System.out.println("cerrarConexion");
        Conexiones instance = new Conexiones();
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSHA256 method, of class Conexiones.
     */
    @Test
    public void testGetSHA256() {
        System.out.println("getSHA256");
        String entrada = "";
        Conexiones instance = new Conexiones();
        String expResult = "";
        String result = instance.getSHA256(entrada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
