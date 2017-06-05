package com.dickanirwansyah.main.CrudJavaWithEclipse.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nasabah",catalog="crud_banking")
public class Nasabah implements Serializable{
	
	private Integer idnasabah;
	private String nama;
	private String notelp;
	private String alamat;
	
	public Nasabah() {
		
	}
	
	public Nasabah(String nama, String alamat, String notelp){
		this.nama=nama;
		this.alamat=alamat;
		this.notelp=notelp;
	}
	
	@Id @GeneratedValue(strategy=IDENTITY)
	
	@Column(name="idnasabah", unique=true, nullable=false)
	public Integer getIdnasabah(){
		return this.idnasabah;
	}
	
	public void setIdnasabah(Integer idnasabah){
		this.idnasabah=idnasabah;
	}
	
	 
	@Column(name="nama", nullable=false)
	public String getNama(){
		return this.nama;
	}
	
	
	public void setNama(String nama){
		this.nama=nama;
	}
	
	@Column(name="notelp", nullable=false)
	public String getNotelp(){
		return this.notelp;
	}
	
	public void setNotelp(String notelp){
		this.notelp=notelp;
	}
	
	@Column(name="alamat", nullable=false)
	public String getAlamat(){
		return this.alamat;
	}
	
	public void setAlamat(String alamat){
		this.alamat=alamat;
	}
}