package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.MovieModel;
import com.example.demo.model.entity.MovieEntity;
import com.example.demo.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for MovieServiceImpl
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieServiceImplTest {

    private final String movieName = "mockName";
    private final String genre = "mockGenre";
    private final String length = "100";
    private final String language = "mockLanguage";
    private final LocalDate releaseDate = LocalDate.EPOCH;

    @SpyBean
    private MovieMapper movieMapper;

    @MockBean
    private MovieRepository movieRepository;

    @Captor
    private ArgumentCaptor<MovieEntity> objectCaptor;

    @Captor
    private ArgumentCaptor<List<Integer>> integerListCaptor;

    @InjectMocks
    private MovieServiceImpl target;

    /**
     * Test case for insertMovie method
     */
    @Test
    public void insertMovieTest_Success() {

        MovieModel movieModel = new MovieModel();
        movieModel.setMovieName(movieName);
        movieModel.setGenre(genre);
        movieModel.setLength(length);
        movieModel.setLanguage(language);
        movieModel.setReleaseDate(releaseDate);

        doNothing()
                .when(movieRepository)
                .insertMovie(any());

        target.insertMovie(movieModel);

        verify(movieRepository).insertMovie(objectCaptor.capture());

        MovieEntity capturedEntity = objectCaptor.getValue();

        assertTrue(capturedEntity.isStatus());
        assertNotNull(capturedEntity.getCreatedOn());
        assertNotNull(capturedEntity.getUpdatedOn());
    }

    /**
     * Test case for getMovie method with success
     */
    @Test
    public void getMovieTest_Success() {

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieId(1);
        movieEntity.setMovieName(movieName);
        movieEntity.setGenre(genre);
        movieEntity.setLength(length);
        movieEntity.setLanguage(language);
        movieEntity.setReleaseDate(releaseDate);

        when(movieRepository.getMovie()).thenReturn(List.of(movieEntity));

        List<MovieModel> movieModelList = target.getMovie();

        assertEquals(1, movieModelList
                .get(0)
                .getMovieId());
    }

    /**
     * Test case for getMovie method with exception
     */
    @Test
    public void getMovieTest_Exception() {

        Throwable throwable = assertThrows(ResourceNotFoundException.class, () -> target.getMovie());

        assertEquals("Unable to fetch the movies", throwable.getMessage());
    }

    /**
     * Test case for deleteMovie method
     */
    @Test
    public void deleteMovieTest_Success() {
        List<Integer> integerList = List.of(1, 2);

        target.deleteMovie(integerList);

        verify(movieRepository).deleteMovie(integerListCaptor.capture());

        List<Integer> capturedIntegerList = integerListCaptor.getValue();

        assertEquals(integerList, capturedIntegerList);
    }
}
