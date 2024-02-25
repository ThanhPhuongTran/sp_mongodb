package com.example.sp_mongodb.Model;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SanPham {
	@JsonProperty("id")
    private Long id;
	@JsonProperty("TenSanPham")
	private String TenSanPham;
	@JsonProperty("NgayTao")
	private Date NgayTao;
	@JsonProperty("SoLuong")
	private int SoLuong;
	@JsonProperty("MoTa")
	private String MoTa;
	@JsonProperty("Gia")
	private Long Gia;
	@JsonProperty("SanPhamTot")
	private int SanPhamTot;
	@JsonProperty("MaDanhMuc")
	private String MaDanhMuc;
}
