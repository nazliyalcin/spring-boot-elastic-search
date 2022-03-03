package com.elasticsearch.example.springbootelasticsearch.api;

import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.example.springbootelasticsearch.entity.Kisi;
import com.elasticsearch.example.springbootelasticsearch.repository.KisiRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiController {
    
	@Autowired
	private KisiRepository kisiRepository;
	
	
	/*@PostConstruct
	public void init() {
		Kisi kisi = new Kisi();
	    kisi.setAd("Nazli");
	    kisi.setSoyad("Yalcin");
	    kisi.setAdres("1763/1 sok.");
	    kisi.setId("ASDFGH234567");
	    kisi.setDogumTarihi(Date.valueOf("04.01.1993"));
	    kisiRepository.save(kisi);
	    
	}*/
	
	@GetMapping("/{search}")
	public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search)
	{
		List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
		return ResponseEntity.ok(kisiler);
	}
	
	@GetMapping("/or/{search}")
	public ResponseEntity<List<Kisi>> getKisiAdOrSoyad(@PathVariable String search)
	{
		List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search,search);
		return ResponseEntity.ok(kisiler);
	}
	
	@PostMapping
	public ResponseEntity<Kisi> saveKisi(@RequestBody Kisi kisi)
	{
		return ResponseEntity.ok(kisiRepository.save(kisi));
	}
	
}
