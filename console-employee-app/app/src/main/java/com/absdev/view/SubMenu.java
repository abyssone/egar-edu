package com.absdev.view;

import com.absdev.storage.SessionState;

public abstract class SubMenu extends Menu {
    void back() {
        SessionState.getPrevMenu().print();
    }
}
