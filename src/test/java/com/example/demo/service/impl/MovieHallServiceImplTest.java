package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.MovieHallMapper;
import com.example.demo.model.MovieHallModel;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    private ArgumentCaptor<MovieHallEntity> objectCaptor;

    @InjectMocks
    private MovieHallServiceImpl target;

    /**
     * Test case for createMovieHall method
     */
    @Test
    public void createMovieHallTest_Success() {

        MovieHallModel movieHallModel = new MovieHallModel();
        movieHallModel.setHallName(HALL_NAME);
        movieHallModel.setTownId(TOWN_ID);

        Mockito
                .doNothing()
                .when(repository)
                .createMovieHall(any());

        target.createMovieHall(movieHallModel);

        verify(repository).createMovieHall(objectCaptor.capture());

        MovieHallEntity capturedEntity = objectCaptor.getValue();

        assertEquals(HALL_NAME, capturedEntity.getHallName());
        assertEquals(TOWN_ID, capturedEntity.getTownId());
        assertNotNull(capturedEntity.getCreatedOn());
        assertNotNull(capturedEntity.getUpdatedOn());
        assertTrue(capturedEntity.isStatus());
    }

    /**
     * Test case for getMovieHall method with success
     */
    @Test
    public void getMovieHallTest_Success() {

        MovieHallEntity movieHallEntity = new MovieHallEntity();
        movieHallEntity.setHallId(123);
        movieHallEntity.setHallName(HALL_NAME);
        movieHallEntity.setTownId(TOWN_ID);

        when(repository.getMovieHall(anyInt())).thenReturn(List.of(movieHallEntity));

        List<MovieHallModel> movieHallModelList = target.getMovieHall(TOWN_ID);

        assertEquals(movieHallModelList
                .get(0)
                .getTownId(), movieHallEntity.getTownId());
    }

    /**
     * Test case for getMovieHall method with exception
     */
    @Test
    public void getMovieHallTest_Exception() {

        Throwable throwable = assertThrows(ResourceNotFoundException.class, () -> target.getMovieHall(TOWN_ID));

        assertEquals("Unable to fetch the movie halls", throwable.getMessage());
    }
}
