package redisfx.tanh.idea.rdm.ui.factory;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;
import redisfx.tanh.idea.rdm.ui.view.ToolWindows;

public class ConnectionManagerFactory implements ToolWindowFactory {

    /**
     * 创建窗口内容
     * 当用户点击工具窗口按钮时createToolWindowContent()工厂类的方法被调用并初始化工具窗口的用户界面。
     * 此操作可确保未使用的工具窗口在启动时间或内存使用时不产生任何开销:如果用户未与工具窗口交互,则不会加载或执行任何插件代码
     * @param project
     * @param toolWindow
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ToolWindows toolWindows = new ToolWindows();
        ContentManager contentManager = toolWindow.getContentManager();
//        contentManager.getFactory().createContent(toolWindows.content(),"", true); 使用下面这种老方式，兼容旧版本idea
        ContentFactory contentFactory = ApplicationManager.getApplication().getService(ContentFactory.class);
        Content content = contentFactory.createContent(toolWindows.content(), "", true);
        contentManager.addContent(content);
    }
}
