package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.TownMapper;
import com.example.demo.model.TownModel;
import com.example.demo.model.entity.TownEntity;
import com.example.demo.repository.TownRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for TownServiceImpl
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TownServiceImplTest {

    private final String TOWN_NAME = "mockName";
    @MockBean
    private TownRepository repository;
    @SpyBean
    private TownMapper mapper;
    @Captor
    private ArgumentCaptor<TownEntity> objectCaptor;
    @InjectMocks
    private TownServiceImpl target;

    /**
     * Test case for createTown method
     */
    @Test
    public void createTownTest_Success() {

        TownModel townModel = new TownModel();
        townModel.setTownName(TOWN_NAME);

        target.createTown(townModel);

        verify(repository).createTown(objectCaptor.capture());

        TownEntity capturedEntity = objectCaptor.getValue();

        assertEquals(TOWN_NAME, capturedEntity.getTownName());

        assertNotNull(capturedEntity.getCreatedOn());

        assertNotNull(capturedEntity.getUpdatedOn());
    }

    /**
     * Test case for getTown method with success
     */
    @Test
    public void getTownTest_Success() {

        TownEntity townEntity = new TownEntity();
        Integer TOWN_ID = 1;
        townEntity.setTownId(TOWN_ID);
        townEntity.setTownName(TOWN_NAME);

        when(repository.getTown()).thenReturn(List.of(townEntity));

        List<TownModel> townModelList = target.getTown();

        assertEquals(TOWN_ID, townModelList
                .get(0)
                .getTownId());
        assertEquals(TOWN_NAME, townModelList
                .get(0)
                .getTownName());
    }

    /**
     * Test case for getTown method with exception
     */
    @Test
    public void getTownTest_Exception() {

        Throwable throwable = assertThrows(ResourceNotFoundException.class, () -> target.getTown());

        assertEquals("No records for towns", throwable.getMessage());
    }
}
