package com.company.inter;

import com.company.entity.Country;
import com.company.entity.User;
import java.util.List;

public interface CountryInter {

    List<Country> getAllCountries();

    Country getCountryByUser(User user);

    boolean insertCountry(Country counrty);
}
