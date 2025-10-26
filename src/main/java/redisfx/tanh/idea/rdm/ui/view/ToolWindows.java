package redisfx.tanh.idea.rdm.ui.view;

import com.intellij.ide.CommonActionsManager;
import com.intellij.ide.TreeExpander;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.toolbarLayout.ToolbarLayoutStrategy;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import redisfx.tanh.idea.rdm.ui.action.*;
import redisfx.tanh.idea.rdm.ui.action.AbstractAction;
import redisfx.tanh.idea.rdm.ui.util.GuiUtil;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;

public class ToolWindows implements Disposable {

    /**
     * 连接管理面板
     */
    private JPanel connectionPanel;
    private Tree connectionTree;


    public ToolWindows() {
        this.connectionPanel = new JBPanel<>(new BorderLayout());;
        this.connectionTree = new Tree();
        // 创建工具栏并添加到面板顶部，传入 content ，便于改 displayName
        ActionToolbar actionToolbar = createConnectionActionToolbar(connectionTree);
        // 将工具栏关联到面板
        actionToolbar.setTargetComponent(connectionPanel);
        connectionPanel.add(actionToolbar.getComponent(), BorderLayout.NORTH);
    }

    /**
     * 创建连接管理工具栏
     */
    private static ActionToolbar createConnectionActionToolbar(Tree connectionTree) {
        // 工具栏
        CommonActionsManager actionManager = CommonActionsManager.getInstance();
        DefaultActionGroup actions = new DefaultActionGroup();
        // 增加key
        actions.add(createAddAction(connectionTree));
        actions.add(createAddFolderAction(connectionTree));
        actions.add(createEditAction(connectionTree));
//        // 删除key
        actions.add(createDeleteAction(connectionTree));
        actions.addSeparator();
        // 展开所有
        actions.add(actionManager.createExpandAllAction(GuiUtil.getTreeExpander(connectionTree), connectionTree));
        // 折叠所有
        actions.add(actionManager.createCollapseAllAction(GuiUtil.getTreeExpander(connectionTree), connectionTree));
        ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar("ToolwindowToolbar", actions, true);
        actionToolbar.setLayoutStrategy(ToolbarLayoutStrategy.AUTOLAYOUT_STRATEGY);
        return actionToolbar;
    }

    private static @NotNull AnAction createEditAction(Tree connectionTree) {
        AbstractAction action = new EditAction();
        action.setAction(e -> {
            // 弹出连接配置窗口
            System.out.println("edit");
        });
        return action;
    }

    private static @NotNull AnAction createAddFolderAction(Tree connectionTree) {
        AddFolderAction addAction = new AddFolderAction();
        addAction.setAction(e -> {
            // 弹出连接配置窗口
            System.out.println("add");
        });
        return addAction;
    }


    /**
     * 创建添加按钮
     *
     * @return
     */
    private static AddAction createAddAction(Tree connectionTree) {
        AddAction addAction = new AddAction();
        addAction.setAction(e -> {
            // 弹出连接配置窗口
            System.out.println("add");
        });
        return addAction;
    }

    /**
     * 创建移除按钮
     *
     * @return
     */
    private static DeleteAction createDeleteAction(Tree connectionTree) {
        DeleteAction deleteAction = new DeleteAction();
        deleteAction.setAction(e -> {
            // 弹出删除确认对话框
            System.out.println("delete");
        });
        return deleteAction;
    }

    @Override
    public void dispose() {

    }

    public @Nullable JComponent content() {
        return connectionPanel;
    }
}
