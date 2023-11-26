package thuan.com.fa.demomvc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import thuan.com.fa.demomvc.entity.AppUser;

public interface AppUserRepositoryImpl extends PagingAndSortingRepository<AppUser, String> {

}
