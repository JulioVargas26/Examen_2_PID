/**
 * 
 */
package pe.edu.cibertec;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pe.edu.cibertec.CL1.controller.ClienteController;
import pe.edu.cibertec.CL1.model.Cliente;
import pe.edu.cibertec.CL1.model.TipoCliente;
import pe.edu.cibertec.CL1.service.impl.ClienteServiceImpl;


@WebMvcTest(ClienteControllerTestMockito.class)
class ClienteControllerTestMockito {

	@InjectMocks
    ClienteController clienteController;

    @Mock
    ClienteServiceImpl clienteServiceImpl;

    Cliente generarCliente(){
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

        return c;
    }
    
    List<Cliente> generarListaCliente(){
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
        
        Cliente c2 = new Cliente();
        c2.setId(2);
        c2.setNombre("jajja");
        c2.setApellidoPaterno("jaja");
        c2.setApellidoMaterno("njajaj");
        c2.setDireccion("mi direccion");
        c2.setTelefono("987654321");
        c2.setTipoCliente(tc);
        

        List<Cliente> cli = new ArrayList<>();
        cli.add(c);
        cli.add(c2);
        
        return cli;
    }

	@BeforeEach
    void setUp() {
		System.out.println("Ejecutando setUp");
		clienteController = new ClienteController(clienteServiceImpl);
    }

	@Test
    void registrarCliente() {
		System.out.println("Ejecutando registrarCliente");
        Cliente c = generarCliente();

        when(clienteServiceImpl.registrarCliente(any(Cliente.class))).thenReturn(c);

        ResponseEntity<?> responseEntity = clienteController.registrarCliente(c);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());
        
        System.out.println("registrarCliente: " + clienteResponse);
    }
	
	@Test
    void listarCliente() {
		System.out.println("Ejecutando listarCliente");
        List<Cliente> c = generarListaCliente();

        when(clienteServiceImpl.listarClientes()).thenReturn(c);
        List<Cliente> clienteResponse = clienteServiceImpl.listarClientes();
        assertEquals(2, clienteResponse.size());
        
        System.out.println("listarCliente: " + clienteResponse.size() );
    }

	@Test
    void modificarCliente() {
		System.out.println("Ejecutando modificarCliente");
		Cliente c = generarCliente();

        when(clienteServiceImpl.modificarCliente(any(Cliente.class))).thenReturn(c);
        ResponseEntity<?> responseEntity = clienteController.modificarCliente(c);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Cliente clienteResponse = (Cliente) responseEntity.getBody();
        assertEquals(1, clienteResponse.getId());

        System.out.println("listarCliente: " + clienteResponse );
    }

    @Test
    void eliminarCliente() {
		System.out.println("Ejecutando eliminarCliente");
        when(clienteServiceImpl.eliminarCliente(anyInt())).thenReturn("Cliente eliminado");
        clienteController.eliminarCliente(1);
        verify(clienteServiceImpl,times(1)).eliminarCliente(anyInt());     


        System.out.println("eliminarCliente " );
    }
	
	

}
