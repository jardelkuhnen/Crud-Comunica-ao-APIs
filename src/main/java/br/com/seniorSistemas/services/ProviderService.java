package br.com.seniorSistemas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seniorSistemas.dto.ProviderDTO;
import br.com.seniorSistemas.entities.Provider;
import br.com.seniorSistemas.repositories.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepository providerRepository;
	
	public List<Provider> listAll() {
		return providerRepository.findAll();
	}

	public Provider loadById(Long id) {
		return providerRepository.findById(id).get();
	}

	public void save(@Valid ProviderDTO providerDTO) {
		Provider provider = new Provider();
		
		provider.setName(providerDTO.getName());
		provider.setCnpj(providerDTO.getCnpj());
		
		providerRepository.save(provider);
	}

	public void update(@Valid ProviderDTO providerDTO) {
		Provider provider = providerRepository.findById(providerDTO.getId()).get();
		
		provider.setName(providerDTO.getName());
		provider.setCnpj(providerDTO.getCnpj());
		
		providerRepository.save(provider);
	}

	public void delete(Long id) {
		Provider provider = providerRepository.findById(id).get();
		providerRepository.delete(provider);
		
	}

}
