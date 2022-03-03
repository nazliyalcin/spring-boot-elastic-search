package com.elasticsearch.example.springbootelasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.example.springbootelasticsearch.entity.Kisi;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi,String> {
    
	

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    public List<Kisi> getByCustomQuery(String search);    	
    
    public List<Kisi> findByAdLikeOrSoyadLike(String ad,String soyad);
    	
    
}
