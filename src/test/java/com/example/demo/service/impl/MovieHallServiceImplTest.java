package com.example.demo.service.impl;

import com.example.demo.mapper.MovieHallMapper;
import com.example.demo.model.dto.request.MovieHallRequestDto;
import com.example.demo.model.entity.MovieHallEntity;
import com.example.demo.repository.MovieHallRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

/**
 * Test class for MovieHallServiceImpl
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieHallServiceImplTest {

    private static final String HALL_NAME = "mock";
    private static final Integer TOWN_ID = 123;

    @MockBean
    private MovieHallRepository repository;

    @SpyBean
    private MovieHallMapper movieHallMapper;

    @Captor
    private ArgumentCaptor<List<MovieHallEntity>> listCaptor;

    @Captor
    private ArgumentCaptor<Integer> integerCaptor;

    @InjectMocks
    private MovieHallServiceImpl target;

    /**
     * Test case for createMovieHall method
     */
    @Test
    public void createMovieHallTest_Success() {

        Mockito
                .doNothing()
                .when(repository)
                .createMovieHall(anyList());

        target.createMovieHall(List.of(new MovieHallRequestDto(HALL_NAME, TOWN_ID)));

        verify(repository).createMovieHall(listCaptor.capture());

        MovieHallEntity capturedEntity = listCaptor
                .getValue()
                .get(0);

        assertEquals(HALL_NAME, capturedEntity.getHallName());
        assertEquals(TOWN_ID, capturedEntity.getTownId());
        assertNotNull(capturedEntity.getCreatedOn());
        assertNotNull(capturedEntity.getUpdatedOn());
        assertTrue(capturedEntity.isStatus());
    }

    /**
     * Test case for getMovieHall method
     */
    @Test
    public void getMovieHallTest() {
        target.getMovieHall(TOWN_ID);

        verify(repository).getMovieHall(integerCaptor.capture());

        assertEquals(TOWN_ID, integerCaptor.getValue());
    }
}
