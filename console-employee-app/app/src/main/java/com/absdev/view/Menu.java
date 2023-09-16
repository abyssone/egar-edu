package com.absdev.view;

import java.util.Scanner;

public abstract class Menu implements IConsoleViewable {
    protected final Scanner scanner = new Scanner(System.in);
}
