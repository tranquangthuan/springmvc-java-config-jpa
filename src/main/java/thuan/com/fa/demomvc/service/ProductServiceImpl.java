package thuan.com.fa.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thuan.com.fa.demomvc.entity.Product;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.repository.ProductRepositoryImpl;

@Service
@Transactional
public class ProductServiceImpl {

	@Autowired
	private ProductRepositoryImpl productRepository;

	public List<Product> findAll() {
		long total = productRepository.count();
		if (total == 0) {
			total = 1;
		}
		PageRequest pageRequest = PageRequest.of(0, (int) total);
		List<Product> content = productRepository.findAll(pageRequest).getContent();
		return content;
	}

	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}

	public void delete(long id) {
		Product product = findById(id);
		if (product != null) {
			productRepository.delete(product);
		}
	}

	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Page<Product> findWithPageAble(PageAble pageAble) {
		Sort sort = Sort.by("id").descending();
		Pageable page = PageRequest.of(pageAble.getPage(), pageAble.getSize(), sort);
		Page<Product> products = productRepository.findAll(page);
		return products;
	}

	public List<Product> search(String searchKey) {
		return productRepository.search(searchKey);
	}

	public boolean existSerial(String serial) {
		List<Product> findBySerial = productRepository.findBySerial(serial);
		return (findBySerial != null && findBySerial.size() > 0);
	}
}
