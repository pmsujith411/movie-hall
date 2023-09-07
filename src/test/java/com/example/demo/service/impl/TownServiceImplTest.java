package com.example.demo.service.impl;

import com.example.demo.model.dto.response.TownResponseDto;
import com.example.demo.model.entity.TownEntity;
import com.example.demo.repository.TownRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for TownServiceImpl
 */
@ExtendWith(MockitoExtension.class)
public class TownServiceImplTest {

    @Mock
    private TownRepository repository;

    @Captor
    private ArgumentCaptor<List<TownEntity>> listArgumentCaptor;

    @InjectMocks
    private TownServiceImpl target;

    /**
     * Test case for createTown method
     */
    @Test
    public void createTownTest_Success() {

        List<String> townList = List.of("mock1", "mock2");

        target.createTown(townList);

        verify(repository).createTown(listArgumentCaptor.capture());

        List<TownEntity> capturedList = listArgumentCaptor.getValue();

        assertEquals(2, capturedList.size());
        assertEquals("mock1", capturedList
                .get(0)
                .getTownName());
        assertEquals("mock2", capturedList
                .get(1)
                .getTownName());
        assertNotNull(capturedList
                .get(0)
                .getCreatedOn());
        assertNotNull(capturedList
                .get(0)
                .getUpdatedOn());
        assertNotNull(capturedList
                .get(1)
                .getCreatedOn());
        assertNotNull(capturedList
                .get(1)
                .getUpdatedOn());
    }

    /**
     * Test case for getTown method
     */
    @Test
    public void getTownTest_Success() {

        List<TownResponseDto> townResponseDtoList = List.of(new TownResponseDto(1, "mock1"));

        when(repository.getTown()).thenReturn(townResponseDtoList);

        assertEquals(townResponseDtoList, target.getTown());
    }
}
