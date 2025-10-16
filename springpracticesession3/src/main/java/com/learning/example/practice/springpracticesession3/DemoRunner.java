//package com.learning.example.practice.springpracticesession3;
//
//import com.learning.example.practice.springpracticesession3.Service.Propagation.ReadCommenetdusingpropagation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DemoRunner implements CommandLineRunner {
//
//    @Autowired
//    private ReadCommenetdusingpropagation readCommenetdusingpropagation;
//
//    @Override
//    public void run(String... args) throws Exception {
//        try{
//            readCommenetdusingpropagation.placeOrder(false);
//        }
//        catch (Exception e)
//        {
//            System.out.println("❌ Exception during successful run: " + e.getMessage());
//        }
//
//        System.out.println("\n==============================\n");
//
//        try{
//            readCommenetdusingpropagation.placeOrder(true);
//        }
//        catch (Exception e)
//        {
//            System.out.println("❌ Exception during failed run: " + e.getMessage());
//        }
//
//    }
//}
