package redisfx.tanh.idea.rdm.ui.view;

import com.intellij.ide.CommonActionsManager;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.toolbarLayout.ToolbarLayoutStrategy;
import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import redisfx.tanh.idea.rdm.ui.action.*;
import redisfx.tanh.idea.rdm.ui.action.AbstractAction;
import redisfx.tanh.idea.rdm.ui.util.GuiUtil;
import redisfx.tanh.idea.rdm.ui.view.dialog.ConnectionSettingsDialog;
import redisfx.tanh.rdm.redis.RedisConfig;
import redisfx.tanh.rdm.redis.client.RedisClient;
import redisfx.tanh.rdm.redis.imp.client.DefaultRedisClientCreator;

import javax.swing.*;
import java.awt.*;

public class ToolWindows implements Disposable {

    /**
     * 连接管理面板
     */
    private JPanel connectionPanel;
    private Tree connectionTree;
    private Project project;


    public ToolWindows(Project project) {
        this.project = project;
        this.connectionPanel = new JBPanel<>(new BorderLayout());;
        this.connectionTree = new Tree();
        // 创建工具栏并添加到面板顶部，传入 content ，便于改 displayName
        ActionToolbar actionToolbar = createConnectionActionToolbar();
        // 将工具栏关联到面板
        actionToolbar.setTargetComponent(connectionPanel);
        connectionPanel.add(actionToolbar.getComponent(), BorderLayout.NORTH);
    }

    /**
     * 创建连接管理工具栏
     */
    private  ActionToolbar createConnectionActionToolbar( ) {
        // 工具栏
        CommonActionsManager actionManager = CommonActionsManager.getInstance();
        DefaultActionGroup actions = new DefaultActionGroup();
        // 增加key
        actions.add(addAction());
        actions.add(addFolderAction());
        actions.add(editAction());
//        // 删除key
        actions.add(deleteAction());
        actions.addSeparator();
        // 展开所有
        actions.add(actionManager.createExpandAllAction(GuiUtil.getTreeExpander(connectionTree), connectionTree));
        // 折叠所有
        actions.add(actionManager.createCollapseAllAction(GuiUtil.getTreeExpander(connectionTree), connectionTree));
        ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar("ToolwindowToolbar", actions, true);
        actionToolbar.setLayoutStrategy(ToolbarLayoutStrategy.AUTOLAYOUT_STRATEGY);
        return actionToolbar;
    }

    private  @NotNull AnAction editAction() {
        AbstractAction action = new EditAction();
        action.setAction(e -> {
            RedisConfig config = new RedisConfig();
            config.setHost("127.0.0.1");
            config.setPort(6379);
            config.setSsl( false);
            config.setSsh(false);
            config.setCluster(false);
            config.setSentinel(false);
            config.setConnectionTimeout(6000);
            config.setSoTimeout(6000);
            DefaultRedisClientCreator creator = new DefaultRedisClientCreator(config);
            RedisClient redisClient = creator.create();
            String ping = redisClient.ping();
            // 弹出连接配置窗口
            System.out.println("edit"+ping);
        });
        return action;
    }

    private  @NotNull AnAction addFolderAction() {
        AddFolderAction addAction = new AddFolderAction();
        addAction.setAction(e -> {
            ConnectionSettingsDialog connectionSettingsDialog = new ConnectionSettingsDialog(project);
            connectionSettingsDialog.show();
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
    private  AddAction addAction() {
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
    private  DeleteAction deleteAction() {
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
