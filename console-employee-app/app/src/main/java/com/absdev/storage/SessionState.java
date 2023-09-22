package com.absdev.storage;

import com.absdev.model.Company;
import com.absdev.model.Employee;
import com.absdev.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class SessionState {     //State manager
    private static Company currentCompany = null;
    private static Employee currentEmployee = null;
    private static List<Menu> menuStack = new ArrayList<>();    //LIFO Stack последовательного вызова меню

    public static Company getCurrentCompany() {
        return currentCompany;
    }
    public static Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public static void setCurrentCompany(Company currentCompany) {
        SessionState.currentCompany = currentCompany;
    }
    public static void setCurrentEmployee(Employee employee) {
        SessionState.currentEmployee = employee;
    }

    public static Menu getPrevMenu() {
        if (!menuStack.isEmpty()) {
            Menu last = menuStack.get(menuStack.size() - 1);
            menuStack.remove(menuStack.size() - 1);
            return last;
        } else {
            throw new NullPointerException("Стек вызовов меню пуст");
        }
    }

    public static void setPrevMenu(Menu menu) {
        menuStack.add(menu);
    }
}
