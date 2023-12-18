package thuan.com.fa.demomvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import thuan.com.fa.demomvc.entity.Product;

public interface ProductRepositoryImpl extends PagingAndSortingRepository<Product, Long> {

	public List<Product> findByName(String name);

	public List<Product> findBySerial(String serial);

	@Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:searchKey,'%') or p.serial LIKE CONCAT('%',:searchKey,'%')")
	public List<Product> search(@Param("searchKey") String searchKey);
}
