package ch08;

import java.util.Arrays;
import java.util.List;

class Wine {
    String name() {
        return "wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}

public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}
