package com.example.ec.exploreca.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.exploreca.domain.TourRating;
import com.example.ec.exploreca.service.TourRatingService;

/**
 * Created by Manpreet
 */
@RestController
@RequestMapping(path = "/ratings")
public class RatingController {
    private TourRatingService tourRatingService;

    @Autowired
    public RatingController(TourRatingService tourRatingService) {
        this.tourRatingService = tourRatingService;
    }

    @GetMapping
    public List<TourRating> getAll() {
        return tourRatingService.lookupAll();
    }

    @GetMapping("/{id}")
    public TourRating getRating(@PathVariable("id") Integer id) {
        return tourRatingService.lookupRatingById(id)
                .orElseThrow(() -> new NoSuchElementException("Rating " + id + " not found")
                );
    }


    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex exception
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
