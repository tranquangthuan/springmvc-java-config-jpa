package thuan.com.fa.demomvc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import thuan.com.fa.demomvc.entity.Category;

public interface CategoryRepositoryImpl extends PagingAndSortingRepository<Category, Long> {

}
