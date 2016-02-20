/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.validation;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import cz.vsmie.example.hibernate.command.KategorieCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author Grant
 */
@Component("albumValidator")
public class AlbumValidator implements BaseValidator<AlbumCommand>{

    @Override
    public void validate(AlbumCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "album.title.required", "Doplňte název");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "artist", "album.artist.required", "Doplňte umělce");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "album.genre.required", "Doplňte žánr");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "album.price.required", "Doplňte cenu");
    }
    
}
