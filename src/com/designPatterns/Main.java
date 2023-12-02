package com.designPatterns;

import com.designPatterns.command.*;
import com.designPatterns.command.fx.Button;
import com.designPatterns.command.fx.Command;
import com.designPatterns.iterator.BrowseHistory;
import com.designPatterns.iterator.Iterator;
import com.designPatterns.javaBasics.*;
import com.designPatterns.mediator.ArticlesDialogBox;
import com.designPatterns.memento.Editor;
import com.designPatterns.memento.History;
import com.designPatterns.observer.Chart;
import com.designPatterns.observer.DataSource;
import com.designPatterns.observer.SpreadSheet;
import com.designPatterns.state.Canvas;
import com.designPatterns.state.SelectionTool;
import com.designPatterns.strategy.BWFilter;
import com.designPatterns.strategy.ImageStorage;
import com.designPatterns.strategy.JpegCompressor;
import com.designPatterns.templateMethod.Task;
import com.designPatterns.templateMethod.TransferMoneyTask;

import javax.xml.crypto.Data;

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
            Task task = new TransferMoneyTask();
            task.execute();
        }

        // COMMAND PATTERN
        {
            CustomerService service = new CustomerService();
            Command command = new AddCustomerCommand(service);
            Button button = new Button(command);
            button.click();

            CompositeCommand composite = new CompositeCommand();
            composite.add(new ResizeCommand());
            composite.add(new BlackAndWhiteCommand());
            composite.execute();
        }

        // OBSERVER PATTERN
        {
            DataSource dataSource = new DataSource();
            SpreadSheet sheet1 = new SpreadSheet();
            SpreadSheet sheet2 = new SpreadSheet();
            Chart chart = new Chart();

            dataSource.addObserver(sheet1);
            dataSource.addObserver(sheet2);
            dataSource.addObserver(chart);

            dataSource.setValue(1);
        }

        // MEDIATOR PATTERN
        {
            var dialog = new ArticlesDialogBox();
            dialog.simulateUserInteraction();
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