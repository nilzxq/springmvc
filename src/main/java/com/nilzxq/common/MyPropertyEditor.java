package com.nilzxq.common;

import com.nilzxq.object.User;

import java.beans.PropertyEditorSupport;

/**
 * @author zxq @date 2017年1月3日
 *
 */
public class MyPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User u = new User();
        String[] textArray = text.split(",");
        u.setName(textArray[0]);
        u.setAge(Integer.parseInt(textArray[1]));
        this.setValue(u);
    }

    public static void main(String[] args) {
        MyPropertyEditor editor = new MyPropertyEditor();
        editor.setAsText("tom,22");
        System.out.println(editor.getValue());
    }
}
