package com.example.sp_mongodb;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.example.sp_mongodb.Controller.DanhMucController;
import com.example.sp_mongodb.Model.DanhMuc;
import com.example.sp_mongodb.Model.SanPham;
import com.example.sp_mongodb.Service.DanhMucService;
import com.example.sp_mongodb.dto.DanhMucTO;

@WebMvcTest(DanhMucController.class)
@ExtendWith(MockitoExtension.class)
public class DanhMucControllerTest {
 @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DanhMucService danhMucService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testCreateDanhMuc() throws Exception {
        // Arrange
        when(danhMucService.createDanhMuc(any(DanhMucTO.class))).thenReturn("Success");

        // Act & Assert
        mockMvc.perform(post("/api/dm/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Test Danh Muc\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Success"));
    }

    @Test
    public void testGetDanhMuc() throws Exception {
        // Arrange
        List<DanhMuc> danhMucList = new ArrayList<>();
        danhMucList.add(new DanhMuc());
        danhMucList.add(new DanhMuc());
        when(danhMucService.getDanhMuc()).thenReturn(danhMucList);

        // Act & Assert
        mockMvc.perform(get("/api/dm/get/danhmuc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(danhMucList.size()));
    }

    @Test
    public void testCheckIdDanhMuc() throws Exception {
        // Arrange
        List<DanhMuc> danhMucList = new ArrayList<>();
        danhMucList.add(new DanhMuc("1","a","tot"));
        danhMucList.add(new DanhMuc("2","b","tot"));
when(danhMucService.getDanhMuc()).thenReturn(danhMucList);

        // Act & Assert
        mockMvc.perform(get("/api/dm/get/checkiddanhmuc?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

        mockMvc.perform(get("/api/dm/get/checkiddanhmuc?id=3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void testGetDanhMucId() throws Exception {
        // Arrange
        when(restTemplate.getForObject(anyString(), any())).thenReturn(Arrays.asList(new SanPham(), new SanPham()));

        // Act & Assert
        mockMvc.perform(get("/api/dm/get/danhmucid?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testDeleteDanhMuc() throws Exception {
        // Arrange
        when(danhMucService.deleteDanhMuc("1")).thenReturn("Deleted");

        // Act & Assert
        mockMvc.perform(get("/api/dm/delete/danhmuc?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted"));
    }

    @Test
    public void testUpdateDanhMuc() throws Exception {
        // Arrange
        when(danhMucService.updateDanhMuc(any(DanhMucTO.class))).thenReturn("Updated");

        // Act & Assert
        mockMvc.perform(put("/api/dm/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Updated Danh Muc\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Updated"));
    }
}
