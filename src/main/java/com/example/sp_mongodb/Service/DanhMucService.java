package com.example.sp_mongodb.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sp_mongodb.Model.DanhMuc;
import com.example.sp_mongodb.Repository.DanhMucRepository;
import com.example.sp_mongodb.dto.DanhMucTO;
@Service
public class DanhMucService {
	@Autowired
	private DanhMucRepository danhmucRepository;
	public String createDanhMuc(DanhMucTO danhmucTo)
	{
		if (danhmucTo.getId() == null || danhmucTo.getId().isEmpty()) {
			return "Mã danh mục không được trống.";
		}
	
		// Kiểm tra tên danh mục không quá 10 ký tự
		if (danhmucTo.getTenDanhMuc().length() > 10) {
			return "Tên danh mục không được quá 10 ký tự.";
		}
			DanhMuc dm= DanhMuc.builder()
					.TenDanhMuc(danhmucTo.getTenDanhMuc())
					.MoTa(danhmucTo.getMoTa())
					.build();
			System.out.print(dm.getTenDanhMuc());
			System.out.print(dm.getMoTa());
			danhmucRepository.save(dm);
			return "Danh muc them thanh cong";

	}
	public List<DanhMuc> getDanhMuc()
	{
		List<DanhMuc> dmList = new ArrayList<>();
		try {
			dmList=danhmucRepository.findAll();
		}catch(Exception e) {}
		return dmList;
	}
	public DanhMuc getDanhMucId(String id)
	{
		return danhmucRepository.findById(id).get();
	}
	public String deleteDanhMuc(String id)
	{
		try {
			danhmucRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Da Xoa Danh Muc Thanh Cong";
	}
	public String updateDanhMuc(DanhMucTO dm)
	{
	
		DanhMuc dm_update =DanhMuc.builder()
					.id(dm.getId())
					.TenDanhMuc(dm.getTenDanhMuc())
					.MoTa(dm.getMoTa())
					.build();
		danhmucRepository.save(dm_update);
		return "Da Update Danh Muc Thanh Cong";
		
		
	}
}
