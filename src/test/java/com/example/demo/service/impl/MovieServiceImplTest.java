package com.example.demo.service.impl;

import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.dto.request.MovieRequestDto;
import com.example.demo.model.dto.response.MovieResponseDto;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
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
    private ArgumentCaptor<List<MovieEntity>> listCaptor;

    @Captor
    private ArgumentCaptor<List<Integer>> integerListCaptor;

    @InjectMocks
    private MovieServiceImpl target;

    /**
     * Test case for insertMovie method
     */
    @Test
    public void insertMovieTest_Success() {
        doNothing()
                .when(movieRepository)
                .insertMovie(anyList());

        target.insertMovie(List.of(new MovieRequestDto(movieName, genre, length, language, releaseDate)));

        verify(movieRepository).insertMovie(listCaptor.capture());

        MovieEntity capturedEntity = listCaptor
                .getValue()
                .get(0);

        assertTrue(capturedEntity.isStatus());
        assertNotNull(capturedEntity.getCreatedOn());
        assertNotNull(capturedEntity.getUpdatedOn());
    }

    /**
     * Test case for getMovie method
     */
    @Test
    public void getMovieTest_Success() {
        when(movieRepository.getMovie()).thenReturn(
                List.of(new MovieResponseDto(1, movieName, genre, length, language, releaseDate)));

        List<MovieResponseDto> responseDtoList = target.getMovie();

        assertEquals(1, responseDtoList
                .get(0)
                .movieId());
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
