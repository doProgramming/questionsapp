package app;

import app.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class Runnable {

    public static void main (String args[]){
        //SpringApplication.run(Runnable.class,args);
        //FOR GUI
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Runnable.class).headless(false).run(args);
        View appFrame = context.getBean(View.class);
        try {
            appFrame.run();
        }catch (Exception e) {
            e.printStackTrace();
        }


}
}
