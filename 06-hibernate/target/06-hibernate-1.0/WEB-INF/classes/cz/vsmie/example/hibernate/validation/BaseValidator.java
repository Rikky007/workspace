package cz.vsmie.example.hibernate.validation;

import org.springframework.validation.Errors;

/**
 *
 * @author Ing. Jiří Franc
 * @param <T> Typ commandu, ktery bude trida implementujici interface zpracovavat
 */
public interface BaseValidator<T> {
    public void validate(T command, Errors errors);
}
