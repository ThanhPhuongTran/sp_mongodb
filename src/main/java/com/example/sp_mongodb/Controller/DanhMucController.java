package com.example.sp_mongodb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sp_mongodb.Model.DanhMuc;
import com.example.sp_mongodb.Service.DanhMucService;
import com.example.sp_mongodb.dto.DanhMucTO;


@RestController
@RequestMapping("/api/dm")
public class DanhMucController {
	@Autowired
	DanhMucService danhmucService;
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createDanhMuc(@RequestBody DanhMucTO emp) {
		return danhmucService.createDanhMuc(emp);
	}
	@GetMapping("/get/danhmuc")
	@ResponseStatus(HttpStatus.OK)
	public List<DanhMuc> getDanhMuc(){
		return danhmucService.getDanhMuc();
	}
	@GetMapping("/delete/danhmuc")
	@ResponseStatus(HttpStatus.OK)
	public String deleteDanhMuc(@RequestParam String id)
	{
		return danhmucService.deleteDanhMuc(id);
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public String updateDanhMuc(@RequestBody DanhMucTO dm)
	{
		return danhmucService.updateDanhMuc(dm);
	}

}
