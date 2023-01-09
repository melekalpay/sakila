package com.uniyaz.rental;

import com.uniyaz.language.domain.Language;
import com.uniyaz.language.service.LanguageService;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.service.RentalService;
import org.junit.Test;

import java.util.List;

public class RentalServiceTest {

    @Test
    public void findAllTest() {

        RentalService rentalService = new RentalService();
        List<Rental> rentals = rentalService.findAll();
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
}
