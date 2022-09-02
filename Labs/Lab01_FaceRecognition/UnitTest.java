/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amylarson
 */
public class UnitTest {
    
    public static void testDoubles(Double expected, Double results, Double tolerance, String msg) {
        if (Math.abs(expected-results) > tolerance) {
            System.out.println("FAIL "+msg); 
            System.out.println("       expected "+expected+", results "+results+" with tolerance "+tolerance);            
        }
    }

    public static void test(Object expected, Object results, String msg) {
        if (!expected.equals(results)) {
            System.out.println("FAIL "+msg); 
            System.out.println("       expected "+expected+", results "+results);
        }        
    }
}
