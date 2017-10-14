package Exersice1;

import java.util.*;

public class VechiclePark {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List <String> carsInPark = new ArrayList<>();
        carsInPark = Arrays.asList(console.nextLine().split("\\s+"));

        LinkedList <String> vechiclesSold = new LinkedList<>();
        LinkedList <String> vehiclesLeft = new LinkedList<>();
        vehiclesLeft.addAll(carsInPark);

        while (true){
            String text = console.nextLine();

            if (text.equals("End of customers!")){
                break;
            }
            String [] orders = text.split("\\s+");
            String typeVechicle = orders[0];
            String numberOfSeats = orders[2];

            for (String cars : carsInPark) {

                int priceForCar = 0;
                boolean available = carsInPark.contains((typeVechicle.toLowerCase().charAt(0)+numberOfSeats));
                if (!available){
                    System.out.println("No");
                    break;
                }

                if (typeVechicle.equals("Car")){
                    if (cars.equals("c"+numberOfSeats)){

                        priceForCar += cars.charAt(0) * Integer.parseInt(numberOfSeats);
                        System.out.printf("Yes, sold for %d$ %n",priceForCar);
                        vechiclesSold.add(cars);
                        vehiclesLeft.remove(cars);

                        break;
                    }
                }
                else if (typeVechicle.equals("Bus")){
                    if (cars.equals("b"+numberOfSeats)){

                        priceForCar += cars.charAt(0) * Integer.parseInt(numberOfSeats);
                        System.out.printf("Yes, sold for %d$ %n",priceForCar);
                        vechiclesSold.add(cars);
                        vehiclesLeft.remove(cars);

                        break;
                    }
                }
                else if (typeVechicle.equals("Van")){

                    if (cars.equals("v"+numberOfSeats)){
                        priceForCar += cars.charAt(0) * Integer.parseInt(numberOfSeats);
                        System.out.printf("Yes, sold for %d$ %n",priceForCar);
                        vechiclesSold.add(cars);
                        vehiclesLeft.remove(cars);

                        break;
                    }
                }
            }
        }

        String vehiclesLeftAsString = Arrays.toString(vehiclesLeft.toArray()).replace("[","").replace("]","");
        System.out.println("Vehicles left: " + String.join(", ",vehiclesLeftAsString));
        System.out.println("Vehicles sold: " + vechiclesSold.size());

    }
}

