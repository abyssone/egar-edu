package com.absdev.view;

import com.absdev.storage.GlobalState;

public abstract class SubMenu extends Menu {
    void back() {
        GlobalState.getPrevMenu().print();
    }
}
