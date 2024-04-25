package pe.edu.cibertec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pe.edu.cibertec.CL1.model.Cliente;
import pe.edu.cibertec.CL1.model.TipoCliente;

class ClienteTestJunit {

	private Cliente cli;
	
	@BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Ejecutando setUpBeforeClass");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Ejecutando tearDownAfterClass");
    }

	 //antes de cada items
    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Ejecutando setUp");
        
        TipoCliente tc = new TipoCliente();
        tc.setId(1);
        tc.setNombre("Tiempo Completo");

        Cliente c = new Cliente();
        c.setId(1);
        c.setNombre("julio");
        c.setApellidoPaterno("casas");
        c.setApellidoMaterno("salas");
        c.setDireccion("mi direccion");
        c.setTelefono("987654321");
        c.setTipoCliente(tc);
        
        cli = c;
    }

    //despues de cada item
    @AfterEach
    void tearDown() throws Exception {
        System.out.println("Ejecutando tearDown");
        cli = null;
    }

    @Test
    void testGetId() {
        System.out.println("Ejecutando getId");
        int expResult = 1;
        int result = cli.getId();
        assertEquals(expResult, result);
        System.out.println("getId: " + result);
    }

    @Test
    public void testGetnombre() {
        System.out.println("Ejecutando getNombre");
        String expResult = "julio";
        String result = cli.getNombre();
        assertEquals(expResult, result);
        System.out.println("getNombre: " + result);
    }

    @Test
    public void testGetApellidoPaterno() {
        System.out.println("Ejecutando getApellidoPaterno");
        String expResult = "casas";
        String result = cli.getApellidoPaterno();
        assertEquals(expResult, result);
        System.out.println("getApellidoPaterno: " + result);
    }

    @Test
    public void testGetApellidoMaterno() {
        System.out.println("Ejecutando getApellidoMaterno");
        String expResult = "salas";
        String result = cli.getApellidoMaterno();
        assertEquals(expResult, result);
        System.out.println("getApellidoMaterno: " + result);
    }
    
    @Test
    public void testGetDireccion() {
        System.out.println("Ejecutando getDireccion");
        String expResult = "mi direccion";
        String result = cli.getDireccion();
        assertEquals(expResult, result);
        System.out.println("getDireccion: " + result);
    }
    
    @Test
    public void testGetTelefono() {
        System.out.println("Ejecutando getTelefono");
        String expResult = "987654321";
        String result = cli.getTelefono();
        assertEquals(expResult, result);
        System.out.println("getTelefono: " + result);
    }
    
    @Test
    public void testGetTipoCliente() {
        System.out.println("Ejecutando getTipoCliente");
        int expResult = 1;
        int result = cli.getTipoCliente().getId();
        assertEquals(expResult, result);
        System.out.println("getTipoCliente.Id: " + result);
    }
    
    @Test
    public void testGetTipoClienteNombre() {
        System.out.println("Ejecutando getTipoCliente.nombre");
        String expResult = "Tiempo Completo";
        String result = cli.getTipoCliente().getNombre();
        assertEquals(expResult, result);
        System.out.println("getTipoCliente.Nombre: " + result);
    }

}
