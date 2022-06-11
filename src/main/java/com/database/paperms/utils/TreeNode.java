package com.database.paperms.utils;

import java.util.List;

public class TreeNode<T> {
    T data;
    List<TreeNode<T>> children;

    public TreeNode(T data, List<TreeNode<T>> children) {
        this.data = data;
        this.children = children;
    }

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode() {
    }

    public void insert(TreeNode<T> node) throws NullPointerException {
        children.add(node);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
}