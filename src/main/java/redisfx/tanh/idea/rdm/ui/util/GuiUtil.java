package redisfx.tanh.idea.rdm.ui.util;

import com.intellij.ide.TreeExpander;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;

public class GuiUtil {


    /**
     * 展开所有
     *
     * @param tree
     */
    public static void expandTree(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }


    /**
     * 展开指定路径
     *
     * @param tree
     * @param parent
     */
    public static void expandAll(JTree tree, TreePath parent, boolean expand) {
        // Traverse children
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration<? extends TreeNode> e = node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }

        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    /**
     * 获取树展开工具
     *
     * @param tree
     * @return
     */
    public static TreeExpander getTreeExpander(JTree tree) {
        return new TreeExpander() {
            @Override
            public void expandAll() {
                expandTree(tree, true);
            }

            @Override
            public boolean canExpand() {
                return true;
            }

            @Override
            public void collapseAll() {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
                for (int i = 0; i < root.getChildCount(); i++) {
                    DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
                    GuiUtil.expandAll(tree, new TreePath(child.getPath()), false);
                }
            }

            @Override
            public boolean canCollapse() {
                return true;
            }

        };
    }
}
