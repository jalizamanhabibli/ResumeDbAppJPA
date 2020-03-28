package com.company.main;

import com.company.impl.CountryImpl;
import com.company.impl.EmploymentHistoryImpl;
import com.company.impl.SkillImpl;
import com.company.impl.UserImpl;
import com.company.inter.CountryInter;
import com.company.inter.EmploymentHistoryInter;
import com.company.inter.SkillInter;
import com.company.inter.UserInter;

public class Context {

    public static UserInter instanceUser() {
        return new UserImpl();
    }

    public static EmploymentHistoryInter instanceEmploymentHistory() {
        return new EmploymentHistoryImpl();
    }

    public static UserInter instanceUserSkill() {
        return new UserImpl();
    }

    public static CountryInter instanceCountry() {
        return new CountryImpl();
    }

    public static SkillInter instanceSkill() {
        return new SkillImpl();
    }
}
