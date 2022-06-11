package com.database.paperms.service;

import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.utils.TreeNode;

import java.util.List;

public interface ResearchDirectionService {

    List<TreeNode<ResearchDirection>> list();

}
