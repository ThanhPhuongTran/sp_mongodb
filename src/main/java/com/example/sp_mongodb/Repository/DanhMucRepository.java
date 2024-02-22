package com.example.sp_mongodb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sp_mongodb.Model.DanhMuc;

@Repository
public interface DanhMucRepository extends MongoRepository<DanhMuc, String> {

}
