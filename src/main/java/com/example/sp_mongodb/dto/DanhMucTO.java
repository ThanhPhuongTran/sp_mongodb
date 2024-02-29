package com.example.sp_mongodb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DanhMucTO {
	private String id;
	private String TenDanhMuc;
	private String MoTa;
	// public DanhMucTO(){}
}
