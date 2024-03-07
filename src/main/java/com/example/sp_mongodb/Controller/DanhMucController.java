package com.example.sp_mongodb.Controller;

import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.sp_mongodb.Model.DanhMuc;
import com.example.sp_mongodb.Model.SanPham;
import com.example.sp_mongodb.Service.DanhMucService;
import com.example.sp_mongodb.dto.DanhMucTO;


@RestController
@RequestMapping("/api/dm")
public class DanhMucController {
	@Autowired
	DanhMucService danhmucService;
	@Autowired
	private RestTemplate restTemplate;
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
	@GetMapping("/get/checkiddanhmuc")
	@ResponseStatus(HttpStatus.OK)
	public int checkIdDanhMuc(@RequestParam String id){
		List<DanhMuc> danhMucList = danhmucService.getDanhMuc();
		int i=0;
		for (DanhMuc danhMuc : danhMucList) {
            if (danhMuc.getId().equals(id)) {
                i=i+1;
            }
        }
		if (i>0) 
		{
			return 1;
		}
		else{
			return 0;
		}
	}
	@GetMapping("/get/danhmucid")
	@ResponseStatus(HttpStatus.OK)
	public List<SanPham> getDanhMucId(@RequestParam String id){	
		String url = "http://sanpham/sanpham/theodm";
        
        // Xây dựng URL với tham số từ @RequestParam
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("id", id);
        // Gọi REST API với URL đã xây dựng và trả về danh sách SanPham
		System.err.println(builder.toUriString());
        List<SanPham> sanPhamList = restTemplate.getForObject(builder.toUriString(), List.class);
        return sanPhamList;
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
