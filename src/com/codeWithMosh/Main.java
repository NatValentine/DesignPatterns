package com.codeWithMosh;

import com.codeWithMosh.designPatterns.iterator.BrowseHistory;
import com.codeWithMosh.designPatterns.iterator.Iterator;
import com.codeWithMosh.designPatterns.javaBasics.*;
import com.codeWithMosh.designPatterns.memento.Editor;
import com.codeWithMosh.designPatterns.memento.History;
import com.codeWithMosh.designPatterns.state.Canvas;
import com.codeWithMosh.designPatterns.state.SelectionTool;
import com.codeWithMosh.designPatterns.strategy.BWFilter;
import com.codeWithMosh.designPatterns.strategy.ImageStorage;
import com.codeWithMosh.designPatterns.strategy.JpegCompressor;
import com.codeWithMosh.designPatterns.templateMethod.TransferMoneyTask;

public class Main {
    public static void main(String[] args) {
        // BASICS: Coupling
        {
            User user = new User("Nat", 2); // highly coupled
            user.sayHello();

            TaxCalculator calculator = getCalculator(); // loosely coupled
            calculator.calculateTax();
        }

        // BASICS: Encapsulation: access modifiers, getters and setters
        {
            Account account = new Account();
            account.deposit(10);
            account.withdraw(2);
            System.out.println("Current balance: " + account.getBalance());
        }

        // BASICS: Abstraction: access modifiers again, main can only see what it can actually use
        {
            MailService mailService = new MailService();
            mailService.sendEmail(); // now only available method because all others are private
        }

        // BASICS: Inheritance
        {
            UIControl txtBox = new TextBox();
            txtBox.enable();
        }

        // BASICS: Polymorphism
        {
            UIControl textBox = new TextBox();
            UIControl checkBox = new CheckBox();
            drawUIControl(textBox);
            drawUIControl(checkBox);
        }

        // MEMENTO PATTERN
        {
            Editor editor = new Editor();
            History history = new History();

            editor.setContent("a");
            history.push(editor.createState());

            editor.setContent("b");
            history.push(editor.createState());

            editor.setContent("c");
            history.push(editor.createState());

            editor.restore(history.pop()); // undo "c"
            System.out.println(editor.getContent());
        }

        // STATE PATTERN: open (for extension) close (for modification) principle
        {
            Canvas canvas = new Canvas();
            canvas.setCurrentTool(new SelectionTool());
            canvas.mouseDown();
            canvas.mouseUp();
        }

        // ITERATOR PATTERN
        {
            BrowseHistory history = new BrowseHistory();
            history.push("url1");
            history.push("url2");
            history.push("url3");

            Iterator<String> iterator = history.createIterator();
            while (iterator.hasNext()) {
                var url = iterator.current();
                System.out.println(url);
                iterator.next();
            }
        }

        // STRATEGY PATTERN
        {
            ImageStorage imageStorage = new ImageStorage();
            imageStorage.store("cat_picture", new JpegCompressor(), new BWFilter());
        }

        // TEMPLATE METHOD PATTERN
        {
            var task = new TransferMoneyTask();
            task.execute();
        }

        // COMMAND PATTERN
        {
            
        }
    }

    public static TaxCalculator getCalculator() {
        // return new TaxCalculator2023();
        return new TaxCalculator2024();
    }

    public static void drawUIControl(UIControl control) {
        control.draw();
    }
}