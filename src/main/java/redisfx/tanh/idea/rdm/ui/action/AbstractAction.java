package redisfx.tanh.idea.rdm.ui.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.function.Consumer;

/**
 * 抽象封装操作
 */
public abstract class AbstractAction extends AnAction {
    /**
     * 操作具体执行的逻辑
     */
    protected Consumer<AnActionEvent> action;

    public AbstractAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    /**
     * 抽象方法，具体操作逻辑 通过setAction传进来
     *actionPerformed()方法实现了当用户调用一个操作时执行的代码
     * @param anActionEvent
     */
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        if (this.action == null) {
            throw new RuntimeException("action not set");
        }
        action.accept(anActionEvent);
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }

    public void setAction(Consumer<AnActionEvent> action) {
        this.action = action;
    }
}
