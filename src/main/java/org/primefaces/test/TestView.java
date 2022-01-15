package org.primefaces.test;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private TreeNode root;

    private TreeNode selectedNode;

    @PostConstruct  
    public void init() {
        root = new DefaultTreeNode(MyModel.random(), null);

        TreeNode node0 = new DefaultTreeNode(MyModel.random(), root);
        TreeNode node1 = new DefaultTreeNode(MyModel.random(), root);
        TreeNode node2 = new DefaultTreeNode(MyModel.random(), root);

        TreeNode node00 = new DefaultTreeNode(MyModel.random(), node0);
        TreeNode node01 = new DefaultTreeNode(MyModel.random(), node0);
    }

    public void onNodeExpand(NodeExpandEvent event) {
        event.getTreeNode().setExpanded(true);
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        event.getTreeNode().setExpanded(false);
    }

    public void delete() {
        if (selectedNode == null) {
            return;
        }
        selectedNode.getParent().getChildren().remove(selectedNode);
    }

    public void add() {
        new DefaultTreeNode(MyModel.random(), selectedNode == null ? root : selectedNode);
    }

}
