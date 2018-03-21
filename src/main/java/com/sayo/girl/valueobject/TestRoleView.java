package com.sayo.girl.valueobject;

/**
 * Created by Shuangyao
 * 20:37 2018/3/21
 */
public class TestRoleView {
    private String label;
    private String code;
    private String description;
    private String function;
    private TestRoleView children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public TestRoleView getChildren() {
        return children;
    }

    public void setChildren(TestRoleView children) {
        this.children = children;
    }
}
