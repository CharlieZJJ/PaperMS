package com.database.paperms.service;

import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.utils.TreeNode;

import java.util.List;

public interface ResearchDirectionService {

    int saveResearchDirection(ResearchDirection researchDirection);

    int deleteResearchDirection(Integer rdId);

    int updateResearchDirection(ResearchDirection researchDirection);

    List<TreeNode> list();

}
