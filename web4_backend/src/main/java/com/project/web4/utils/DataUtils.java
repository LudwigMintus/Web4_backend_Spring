package com.project.web4.utils;

import com.project.web4.model.Data;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataUtils {
    private boolean rectangle(double x, double y, double r) {
        if (r >= 0) {
            return x <= 0 && x >= -r / 2 && y <= 0 && y >= -r;
        }else{
            double newX = -x;
            double newY = -y;
            return newX>=0 && newX<=-r/2 && newY>=0 && newY<=-r;
        }
    }
    private boolean triangle(double x, double y, double r) {
        if (r >= 0) {
            return x <= 0 && x >= -r / 2 && y >= 0 && y / 2 <= r / 2 + x;
        }else{
            double newX = -x;
            double newY = -y;
            return newX>=0 && newY<=0 && newY/2>=r/2+newX;
        }
    }

    private boolean circle(double x, double y, double r) {
        if (r >= 0) {
            return x >= 0 && x <= r / 2 && y >= 0 && y * y <= -x * x + r / 2 * r / 2;
        }else{
            double newX = -x;
            double newY = -y;
            return newX <= 0 && newX >= r / 2 && newY <= 0 && newY * newY <= -newX * newX + r / 2 * r / 2;
        }

    }

    public boolean checkAll(Data data) {
        double x = data.getX();
        double y = data.getY();
        double r = data.getR();
        if (rectangle(x, y, r) || triangle(x, y, r) || circle(x, y, r)) {
            return true;
        } else return false;
    }

    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
