package com.designPatterns;

import com.designPatterns.behavioralPatterns.chainOfResponsibility.*;
import com.designPatterns.behavioralPatterns.command.*;
import com.designPatterns.behavioralPatterns.command.fx.Button;
import com.designPatterns.behavioralPatterns.command.fx.Command;
import com.designPatterns.behavioralPatterns.iterator.BrowseHistory;
import com.designPatterns.behavioralPatterns.iterator.Iterator;
import com.designPatterns.creationalPatterns.abstractFactory.app.ContactForm;
import com.designPatterns.creationalPatterns.abstractFactory.materialDesign.MaterialWidgetFactory;
import com.designPatterns.creationalPatterns.builder.MovieBuilder;
import com.designPatterns.creationalPatterns.builder.PdfBuilder;
import com.designPatterns.creationalPatterns.builder.Presentation;
import com.designPatterns.creationalPatterns.builder.Slide;
import com.designPatterns.creationalPatterns.factoryMethod.ProductsController;
import com.designPatterns.creationalPatterns.singleton.ConfigManager;
import com.designPatterns.javaBasics.*;
import com.designPatterns.behavioralPatterns.mediator.ArticlesDialogBox;
import com.designPatterns.behavioralPatterns.memento.Editor;
import com.designPatterns.behavioralPatterns.memento.History;
import com.designPatterns.behavioralPatterns.observer.Chart;
import com.designPatterns.behavioralPatterns.observer.DataSource;
import com.designPatterns.behavioralPatterns.observer.SpreadSheet;
import com.designPatterns.behavioralPatterns.state.Canvas;
import com.designPatterns.behavioralPatterns.state.SelectionTool;
import com.designPatterns.behavioralPatterns.strategy.BWFilter;
import com.designPatterns.behavioralPatterns.strategy.ImageStorage;
import com.designPatterns.behavioralPatterns.strategy.JpegCompressor;
import com.designPatterns.behavioralPatterns.templateMethod.Task;
import com.designPatterns.behavioralPatterns.templateMethod.TransferMoneyTask;
import com.designPatterns.behavioralPatterns.visitor.*;
import com.designPatterns.structuralPatterns.adapter.CaramelFilter;
import com.designPatterns.structuralPatterns.adapter.Image;
import com.designPatterns.structuralPatterns.adapter.ImageView;
import com.designPatterns.structuralPatterns.adapter.externalFilters.Caramel;
import com.designPatterns.structuralPatterns.bridge.AdvancedRemoteControl;
import com.designPatterns.structuralPatterns.bridge.SonyTV;
import com.designPatterns.structuralPatterns.composite.Group;
import com.designPatterns.structuralPatterns.composite.Shape;
import com.designPatterns.structuralPatterns.decorator.CloudStream;
import com.designPatterns.structuralPatterns.decorator.CompressedCloudStream;
import com.designPatterns.structuralPatterns.decorator.EncriptedCloudStream;
import com.designPatterns.structuralPatterns.decorator.Stream;
import com.designPatterns.structuralPatterns.facade.*;
import com.designPatterns.structuralPatterns.flyweight.Point;
import com.designPatterns.structuralPatterns.flyweight.PointIconFactory;
import com.designPatterns.structuralPatterns.flyweight.PointService;
import com.designPatterns.structuralPatterns.proxy.EbookProxy;
import com.designPatterns.structuralPatterns.proxy.Library;
import com.designPatterns.structuralPatterns.proxy.RealEbook;

public class Main {
    public static void main(String[] args) {
        // BASICS
        {
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
        }

        // BEHAVIORAL PATTERNS
        {
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
                    String url = iterator.current();
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
                ArticlesDialogBox dialog = new ArticlesDialogBox();
                dialog.simulateUserInteraction();
            }

            // CHAIN OF RESPONSIBILITY PATTERN
            {
                // chain: auth -> log -> compress
                Compressor compressor = new Compressor(null);
                Logger logger = new Logger(compressor);
                Authenticator authenticator = new Authenticator(logger);

                WebServer server = new WebServer(authenticator);

                server.handle(new HttpRequest("admin", "124"));
            }

            // VISITOR PATTERN
            {
                HtmlDocument document = new HtmlDocument();
                document.add(new HeadingNode());
                document.add(new AnchorNode());
                document.execute(new PlainTextOperation());
            }
        }

        // STRUCTURAL PATTERNS
        {
            // COMPOSITE PATTERN
            {
                Group group1 = new Group();
                group1.add(new Shape());
                group1.add(new Shape());

                Group group2 = new Group();
                group1.add(new Shape());
                group1.add(new Shape());

                Group group = new Group();
                group.add(group1);
                group.add(group2);
                group.render();
                group.move();
            }

            // ADAPTER PATTERN
            {
                ImageView imageView = new ImageView(new Image());
                // imageView.apply(new VividFilter());
                imageView.apply(new CaramelFilter(new Caramel()));
            }

            // DECORATOR PATTERN
            {
                storeCreditCard(new CompressedCloudStream(new EncriptedCloudStream(new CloudStream())));
            }

            // FACADE PATTERN
            {
                NotificationService service = new NotificationService();
                service.send("Hello World", "target");
            }

            // FLYWEIGHT PATTERN
            {
                PointService pointService = new PointService(new PointIconFactory());
                for (Point point : pointService.getPoints())
                    point.draw();
            }

            // BRIDGE PATTERN
            {
                var remoteControl = new AdvancedRemoteControl(new SonyTV());
                remoteControl.turnOn();
                remoteControl.setChannel(5);
                remoteControl.turnOff();
            }

            // PROXY PATTERN
            {
                Library library = new Library();
                String[] fileNames = { "a", "b", "c" };
                for (String fileName : fileNames)
                    library.add(new EbookProxy(fileName));
                library.openEbook("a");
                library.openEbook("c");
            }
        }

        // CREATIONAL PATTERNS
        {
            // PROTOTYPE PATTERN
            {

            }

            // SINGLETON PATTERN
            {
                ConfigManager manager = ConfigManager.getInstance();
                manager.set("name", "nat");

                ConfigManager other = ConfigManager.getInstance();
                System.out.println(other.get("name"));
            }

            // FACTORY METHOD PATTERN
            {
                new ProductsController().listProducts();
            }

            // ABSTRACT FACTORY PATTERN
            {
                new ContactForm().render(new MaterialWidgetFactory());
            }

            // BUILDER PATTERN
            {
                var presentation = new Presentation();
                presentation.addSlide(new Slide("Slide 1"));
                presentation.addSlide(new Slide("Slide 2"));

                // var builder = new MovieBuilder();
                var builder = new PdfBuilder();
                presentation.export(builder);
                // var movie = builder.getMovie();
                var pdf = builder.getPdf();
            }
        }
    }

    public static TaxCalculator getCalculator() {
        // return new TaxCalculator2023();
        return new TaxCalculator2024();
    }

    public static void drawUIControl(UIControl control) {
        control.draw();
    }

    public static void storeCreditCard(Stream stream) {
        stream.write("1234-1234-1234-1234");
    }
}