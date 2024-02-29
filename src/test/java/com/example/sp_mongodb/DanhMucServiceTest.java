package com.example.sp_mongodb;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.sp_mongodb.Model.DanhMuc;
import com.example.sp_mongodb.Repository.DanhMucRepository;
import com.example.sp_mongodb.dto.DanhMucTO;
import com.example.sp_mongodb.Service.*;;
@ExtendWith(MockitoExtension.class)

public class DanhMucServiceTest {
    @Mock
    private DanhMucRepository danhMucRepository;

    @InjectMocks
    private DanhMucService danhMucService;

    @Test
    public void testCreateDanhMuc() {
        // Arrange
        DanhMucTO danhMucTO = DanhMucTO.builder()
                .TenDanhMuc("Test Ten Danh Muc")
                .MoTa("Test Mo Ta")
                .build();
        DanhMuc danhMuc = new DanhMuc();

        // Act
        when(danhMucRepository.save(any(DanhMuc.class))).thenReturn(danhMuc);
        String result = danhMucService.createDanhMuc(danhMucTO);

        // Assert
        assertEquals("Danh muc them thanh cong", result);
        verify(danhMucRepository, times(1)).save(any(DanhMuc.class));
    }

    @Test
    public void testGetDanhMuc() {
        // Arrange
        List<DanhMuc> danhMucList = new ArrayList<>();
        danhMucList.add(new DanhMuc());
        danhMucList.add(new DanhMuc());
        when(danhMucRepository.findAll()).thenReturn(danhMucList);

        // Act
        List<DanhMuc> result = danhMucService.getDanhMuc();

        // Assert
        assertEquals(2, result.size());
        verify(danhMucRepository, times(1)).findAll();
    }

    @Test
    public void testGetDanhMucId() {
        // Arrange
        String id = "1";
        DanhMuc danhMuc = new DanhMuc();
        when(danhMucRepository.findById(id)).thenReturn(Optional.of(danhMuc));

        // Act
        DanhMuc result = danhMucService.getDanhMucId(id);

        // Assert
        assertEquals(danhMuc, result);
        verify(danhMucRepository, times(1)).findById(id);
    }

    @Test
    public void testDeleteDanhMuc() {
        // Arrange
        String id = "1";

        // Act
        String result = danhMucService.deleteDanhMuc(id);

        // Assert
        assertEquals("Da Xoa Danh Muc Thanh Cong", result);
        verify(danhMucRepository, times(1)).deleteById(id);
    }
    @Test
    public void testUpdateDanhMuc() {
        // Arrange
        DanhMucTO danhMucTO = DanhMucTO.builder()
                .TenDanhMuc("Test Ten Danh Muc")
                .MoTa("Test Mo Ta")
                .build();

        // Act
        String result = danhMucService.updateDanhMuc(danhMucTO);

        // Assert
        assertEquals("Da Update Danh Muc Thanh Cong", result);
        verify(danhMucRepository, times(1)).save(any(DanhMuc.class));
    }
}
