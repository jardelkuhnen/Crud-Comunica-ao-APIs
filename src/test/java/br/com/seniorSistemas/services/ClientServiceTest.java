package br.com.seniorSistemas.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.repositories.ClientRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	@InjectMocks
	private ClientService clientService;
	
	@Mock
	private ClientRepository clientRepository;

	@Mock
	private ArrayList<Client> clients;	
	
	@Mock
	private Client client;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturListOfCLients() {
		List<Client> clients = new ArrayList<Client>();
		when(clientService.listAll()).thenReturn(clients);
		assertEquals(clients, clientService.listAll());
	}
	
	@Test
	public void shouldReturnClient() {
		Client c = getClient(1L);
		
		when(clientService.loadById(anyLong())).thenReturn(c);
		assertEquals(c, clientService.loadById(anyLong()));
	}

	@Test
	public void shouldSaveClients() {
		
		Client c1 = getClient(1L);
		Client c2 = getClient(2L);
		
		clientRepository.save(c1);
		clientRepository.save(c2);
		
		Mockito.verify(clientRepository, times(2)).save(any(Client.class));
		
	}
	
	
	@Test
	public void returnListOfClients() {
		
		clients.add(client);
		verify(clients).add(client);

		when(clients.get(0)).thenReturn(client);
		assertEquals(clients.get(0), client);
		
		
		List<Client> clients = new ArrayList<Client>();

		Client c = getClient(1L);
		clients.add(c);
		
		when(clientRepository.getOne(1L)).thenReturn(c);
		assertEquals(c, clientRepository.getOne(1L));
		
		when(clientRepository.findAll()).thenReturn(clients);
		assertEquals(clients, clientRepository.findAll());

	}
	
	@Test(expected = NullPointerException.class)
	public void shouldReturnNullPointerException() {
		
		when(clientRepository.save(null)).thenThrow(new NullPointerException());
		Mockito.verify(clientRepository.save(null));
		
	}
	
	@Test
	public void shouldVerifyIsExists() {
		
		Client c = getClient(1L);
		
		when(clientRepository.getOne(c.getId())).thenReturn(c);
		assertEquals(c, clientRepository.getOne(c.getId()));
	}

	private Client getClient(Long id) {
		Client c = new Client();
		c.setId(id);
		c.setName("jardel");
		return c;
	}
	
}
