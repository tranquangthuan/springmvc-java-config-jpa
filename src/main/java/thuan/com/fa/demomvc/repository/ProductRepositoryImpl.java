package thuan.com.fa.demomvc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import thuan.com.fa.demomvc.entity.Product;

public interface ProductRepositoryImpl extends PagingAndSortingRepository<Product, Long> {

}
