package com.database.paperms.utils;

import java.util.List;

public class TreeNode {
    String label;
    String value;
    List<TreeNode> children;

    public TreeNode(String label, String value, List<TreeNode> children) {
        this.label = label;
        this.value = value;
        this.children = children;
    }

    public TreeNode() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public void insert(TreeNode treeNode) {
        this.children.add(treeNode);
    }
}