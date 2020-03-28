package com.company.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillInter {

    List<UserSkill> getAllUserSkills(User user);

    boolean insertUserSkill(UserSkill userSkill);

    boolean updateUserSkill(UserSkill userSkill);

    boolean deleteUserSkill(int userSkillId);
}
