package cz.vsmie.example.hibernate.validation;

import cz.vsmie.example.hibernate.command.KategorieCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Trida slouzi k validace formulare pro upravu/novou kategorii. Proto je parametricky typ nastaven na KategorieCommand
 *
 * @author Ing. Jiří Franc
 */
@Component("kategorieValidator")
public class KategorieValidator implements BaseValidator<KategorieCommand> {

    @Override
    public void validate(KategorieCommand command, Errors errors) {
        //provadime validaci text inputu se jmenem nazev, ma byt povinny, posledni parametr je parametrem do 
        //localizovane hlasky (spravne by se mel brat z properties filu)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazev", "required", new Object[] {"Název"});
    }
}
