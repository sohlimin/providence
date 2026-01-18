import java.util.List;
import java.util.Comparator;

class Nutri {
        private static int sugarB = 2400;
    //Nutrition class has an nutrientList - an immutable list of String-Integer pairs. These pairs represent nutrient nomenclature and its quantity.
    private final ImList<Pair<String, Integer>> nutrientList;
    //a constructor that creates a Nutrition object. It takes in String and integer to create its nutrientList property. 
    Nutri(String nutrientName, int qtyInMilligrams) {
        this.nutrientList = new ImList<Pair<String, Integer>>(List.of(new Pair<String, Integer>(nutrientName, qtyInMilligrams)));
    }
    
    Nutri(ImList<Pair<String, Integer>> nutrientList) {
        this.nutrientList = nutrientList;
    }

    public ImList<Pair<String, Integer>> nutrientList() {
        return this.nutrientList;
    }
    
    public Nutri update(String nutrientName, int qtyInMilligrams) {
        
        List<Pair<String,Integer>> listSansNutrient = this.nutrientList
            .stream()
            .filter(x -> x.first() != nutrientName)
            .toList();
    
        ImList<> newNutrientList = new ImList<>(listSansNutrient)
            .add(nutrientList.stream()
                    .filter(x -> x.first().equals(nutrientName))
                    .findAny()
                    .map(x -> new Pair<>(nutrientName, x.second() + qtyInMilligrams))
                    .orElse(new Pair<>(nutrientName, qtyInMilligrams));
        return new Nutri(newNutrientList.sort((x, y) -> x.compareTo(y)));
    }

    public String toString() {
        return nutrientList.toString(); 
        //String.format("%s, %d", this.nutrient.first(), this.nutrient.second());
    }

    public String grade() {
        int sugarB = 2400;
        int sugarC = 12000;
        int sugarD = 24000; 
        int fatB = 1680;
        int fatC = 2880;
        int fatD = 6720;
        String fatGrade = "";
        String sugarGrade = "";

        for (int i = 0; i < nutrientList.size(); i++) {
        //getting the fat content
            if (nutrientList.get(i).first().equals("fat")) {
                int fat = nutrientList.get(i).second();
                if (fat > fatD) {
                    return "D";
                } else if (fat > fatC) {
                    fatGrade = "C";
                } else if (fat > fatB) {
                    fatGrade = "B";
                } else {
                    fatGrade = "A";
                }
            }

            if (nutrientList.get(i).first().equals("sugar")) {
                int sugar = nutrientList.get(i).second();
                if (sugar > sugarD) {
                    return "D";
                } else if (sugar > sugarC) {
                    sugarGrade = "C";
                } else if (sugar > sugarB) {
                    sugarGrade = "B";
                } else {
                    sugarGrade = "A";
                }
            }
        }            

            if (fatGrade.equals("C") || sugarGrade.equals("C")) {
                return "C";
            } else if (fatGrade.equals("B") || sugarGrade.equals("B")) {
                return "B";
            } else {
                return "A";
            }

    }
}
