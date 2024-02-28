package com.example.sp_mongodb.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;
@Document(value="danhmuc")
@Data
@Builder
public class DanhMuc {
	
	@Id
	private String id;
	@Field(name="tendanhmuc")
	private String TenDanhMuc;
	public DanhMuc()
	{}
	public DanhMuc(String id, String tenDanhMuc, String moTa) {
		this.id = id;
		TenDanhMuc = tenDanhMuc;
		MoTa = moTa;
	}
	private String MoTa;
}
