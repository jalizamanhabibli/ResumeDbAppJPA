package com.company.inter;

import com.company.entity.Skill;
import java.util.List;

public interface SkillInter {

    List<Skill> getAllSkills();

    boolean insertSkill(Skill skill);

    boolean deleteSkill(int id);
}
