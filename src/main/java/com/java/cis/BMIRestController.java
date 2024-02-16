package com.java.cis;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmirest")
public class BMIRestController {

    @PostMapping
    public String calculateBMI(@RequestBody BMIRequest bmiRequest) {
        double bmi = calculateBMIValue(bmiRequest.getHeight(), bmiRequest.getWeight());
        return Double.toString(bmi);
    }

    private double calculateBMIValue(double heightInches, double weightLbs) {
        double bmi = (weightLbs / (heightInches * heightInches)) * 703;
        bmi = Math.round(bmi * 100.0) / 100.0;
        return bmi;
    }

    public static class BMIRequest {
        private double height;
        private double weight;

        // getters and setters

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }
}