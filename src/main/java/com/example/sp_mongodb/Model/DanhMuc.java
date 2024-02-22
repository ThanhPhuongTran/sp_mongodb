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
	private String MoTa;
}
