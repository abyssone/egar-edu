package com.absdev.storage;

import com.absdev.model.Company;
import com.absdev.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class GlobalState {
    private static Company currentCompany = null;
    private static List<Menu> prevMenu = new ArrayList<>();

    public static Company getCurrentCompany() {
        return currentCompany;
    }

    public static void setCurrentCompany(Company currentCompany) {
        GlobalState.currentCompany = currentCompany;
    }

    public static Menu getPrevMenu() {
        if (!prevMenu.isEmpty()) {
            Menu last = prevMenu.get(prevMenu.size() - 1);
            prevMenu.remove(prevMenu.size() - 1);
            return last;
        } else {
            throw new NullPointerException("Стек вызовов меню пуст");
        }
    }

    public static void setPrevMenu(Menu menu) {
        prevMenu.add(menu);
    }
}
