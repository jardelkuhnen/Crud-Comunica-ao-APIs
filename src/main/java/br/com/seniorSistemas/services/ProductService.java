package br.com.seniorSistemas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seniorSistemas.dto.ProductDTO;
import br.com.seniorSistemas.entities.Product;
import br.com.seniorSistemas.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll() {
		return productRepository.findAll();
	}

	public Product loadById(Long id) {
		return productRepository.findById(id).get();
	}

	private void setInformation(ProductDTO productDTO, Product product) {
		product.setDescription(productDTO.getDescription());
		product.setPriceBuy(productDTO.getPriceBuy());
		product.setPriceSale(productDTO.getPriceSale());
	}

	public void save(@Valid ProductDTO productDTO) {
		
		Product product = new Product();
		setInformation(productDTO, product);
		
		productRepository.save(product);
	}

	public void update(@Valid ProductDTO productDTO) {
		
		Product product = productRepository.findById(productDTO.getId()).get();
		setInformation(productDTO, product);

		productRepository.save(product);
	}

	public void delete(Long id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		
	}

}
