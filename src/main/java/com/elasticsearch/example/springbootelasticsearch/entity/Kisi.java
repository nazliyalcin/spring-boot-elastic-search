package com.elasticsearch.example.springbootelasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Document(indexName="kisiler")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kisi {
    
	@Id
	private String id;
	@Field(name="ad",type=FieldType.Text)
	private String ad;
	@Field(name="soyad",type=FieldType.Text)
	private String soyad;
	@Field(name="adres",type=FieldType.Text)
	private String adres;
	@Field(name="dogumTarihi",type=FieldType.Date)
	private Date dogumTarihi;

	
}
