package com.companyname.myshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank
	private String description;
	@Min(0)
	private Double price;
	private boolean important = false;
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] photo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    } 
    
	public String getDescription() {
	    return description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}
	
	public Double getPrice() {
	    return price;
	}
	
	public void setPrice(Double price) {
	    this.price = price;
	}
	
	public boolean isImportant() {
		return this.important;
	}
	
	public void setImportant(boolean value) {
		this.important = value;
	}
	
	public byte[] getPhoto() {
	    return photo;
	}
	
	public String getPhotoURL() {
		if (photo != null && photo.length > 0) {
			return "/myshop/image?id=" + id;
		} else {
			return "";
		}
	}
	
	public void setPhoto(byte[] srcData) {
		photo = srcData;
	}
}
