package com.dx.algorithmpractise.stack;


/**
 * 模拟浏览器
 * <p>
 * Action:
 * 1.维护一个后退栈
 * 2.维护一个前进栈
 */
public class CustomBrowser {
    private String currentPage;
    //后退的栈
    private GenericStackBasedOnLinkedList<String> backStack;
    //前进的栈
    private GenericStackBasedOnLinkedList<String> forwardStack;

    public CustomBrowser() {
        this.backStack = new GenericStackBasedOnLinkedList();
        this.forwardStack = new GenericStackBasedOnLinkedList();
    }

    /**
     * 打开某个链接
     */
    public void open(String url) {
        if (this.currentPage != null) {
            //入栈
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    private void showUrl(String url, String prefix) {
        this.currentPage = url;
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    /**
     * 回退
     */
    public String goBack() {
        if (this.canGoBack()) {
            //前进栈   入栈
            this.forwardStack.push(this.currentPage);
            //后退栈   出栈
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "back");
            return backUrl;
        }

        return null;
    }

    /**
     * 前进
     */
    public String goForward() {
        if (this.canGoForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "forward");
            return forwardUrl;
        }
        return null;
    }
}
