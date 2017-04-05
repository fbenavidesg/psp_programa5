package edu.uniandes.ecos.simpson.model;

public class Util {

    public static double factorial(double init, double limit) {
        if (init <= limit) {
            return limit;
        } else {
            return init * factorial(init - 1, limit);
        }
    }
}
