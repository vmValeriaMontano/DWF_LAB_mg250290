package sv.edu.udb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sv.edu.udb.repository.domain.Movie;
import sv.edu.udb.service.implementation.MovieServiceImpl;

import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * @SpringBootTets para poder levantar un contexto de spring
 * y poder hacer pruebaas de integracion sobre inyeccion de
 * dependencias -TESTING POR CAPAS-
 * */
@SpringBootTest
class MovieServiceTest {
    @Autowired
    private MovieServiceImpl movieService;

    @Test
    void shoulMovieServicesNotNull_When_SpringContextsWorks(){
        assertNotNull(movieService);
    }

    @Test
    void shoulMovieRepositoryNotNull_When_DIWorks(){
        assertNotNull(movieService.getMovieRepository());
    }

    @Test
    void shouldGetAMovie_When_TheMovielsExist(){
        final Long expectedMovieId = 1L;
        final String expectedMovieName = "Inceptions";
        final Integer expectedReleaseYear = 2010;

        final Movie actualMovie = movieService.findMovieById(expectedMovieId);

        assertEquals(actualMovie.getId(), expectedMovieId);
        assertEquals(actualMovie.getName(), expectedMovieName);
        assertEquals(actualMovie.getReleaseYear(), expectedReleaseYear);
    }

    @Test
    void shouldThrowNoSuchElementException_When_MovieIDDoesNotExists(){
        final Long fakeId = 4L;
        final String expecteedErrorMessage = "Movie doesn't exists";
        final Exception exception = assertThrows(NoSuchElementException.class,
                ()-> movieService.findMovieById(fakeId));
        assertEquals(expecteedErrorMessage, exception.getMessage());
    }
}
