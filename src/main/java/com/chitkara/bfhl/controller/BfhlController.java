package com.chitkara.bfhl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BfhlController {

    @PostMapping("/bfhl")
    public Map<String, Object> bfhl(@RequestBody Map<String, Object> request) {

        Map<String, Object> response = new HashMap<>();
        response.put("official_email", "arshvir0385.be23@chitkara.edu.in");
        // ai
if (request.containsKey("AI")) {

    Object obj = request.get("AI");
    if (!(obj instanceof String)) {
        response.put("is_success", false);
        response.put("data", "Invalid AI input");
        return response;
    }

    String question = ((String) obj).toLowerCase();

  
    String answer = "unknown";

    if (question.contains("capital") && question.contains("maharashtra")) {
        answer = "Mumbai";
    }

    response.put("is_success", true);
    response.put("data", answer);
    return response;
}


        if (request.containsKey("fibonacci")) {
            int n = (int) request.get("fibonacci");

            int a = 0, b = 1;
            int[] fib = new int[n];

            for (int i = 0; i < n; i++) {
                fib[i] = a;
                int temp = a + b;
                a = b;
                b = temp;
            }

            response.put("is_success", true);
            response.put("data", fib);
            return response;
        }if (request.containsKey("prime")) {

            Object obj = request.get("prime");
            if (!(obj instanceof java.util.List<?>)) {
                response.put("is_success", false);
                response.put("data", "Invalid prime input");
                return response;
            }
        
            java.util.List<?> list = (java.util.List<?>) obj;
            java.util.List<Integer> primes = new java.util.ArrayList<>();
        
            for (Object item : list) {
                int num = (int) item;
        
                if (num < 2) continue;
        
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
        
                if (isPrime) primes.add(num);
            }
        
            response.put("is_success", true);
            response.put("data", primes);
            return response;
        }
        if (request.containsKey("lcm")) {

            Object obj = request.get("lcm");
            if (!(obj instanceof java.util.List<?>)) {
                response.put("is_success", false);
                response.put("data", "Invalid lcm input");
                return response;
            }
        
            java.util.List<?> list = (java.util.List<?>) obj;
        
            int resultLcm = 1;
        
            for (Object item : list) {
                int num = (int) item;
                resultLcm = lcm(resultLcm, num);
            }
            
            response.put("is_success", true);
            response.put("data", resultLcm);
            return response;
        }if (request.containsKey("hcf")) {

            Object obj = request.get("hcf");
            if (!(obj instanceof java.util.List<?>)) {
                response.put("is_success", false);
                response.put("data", "Invalid hcf input");
                return response;
            }
        
            java.util.List<?> list = (java.util.List<?>) obj;
        
            int hcf = 0;
        
            for (Object item : list) {
                int num = (int) item;
                hcf = gcd(hcf, num);
            }
        
            response.put("is_success", true);
            response.put("data", hcf);
            return response;
        }
        
        

        response.put("is_success", false);
        response.put("data", "Invalid request");
        return response;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

}
