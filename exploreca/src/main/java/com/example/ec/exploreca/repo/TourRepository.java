package com.example.ec.exploreca.repo;

import com.example.ec.exploreca.domain.Tour;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
//	List<Tour> findByTourPackageCode(String code);
	
	/**
	 * 
	 * @param code
	 * @param pageable
	 * @return
	 * URL example: http://localhost:8080/tours/search/findByTourPackageCode?code=CC&size=2&page=0&sort=title,asc
	 */
	Page<Tour> findByTourPackageCode(String code, Pageable pageable);

	@Override
	@RestResource(exported = false)
	<S extends Tour> S save(S entity);

	@Override
	@RestResource(exported = false)
	<S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

	@Override
	@RestResource(exported = true)
	void deleteById(Integer id);

	@Override
	@RestResource(exported = false)
	void delete(Tour entity);

	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends Tour> entities);

	@Override
	@RestResource(exported = false)
	void deleteAll();
	
	
}
