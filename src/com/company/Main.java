package com.company;

//idea for info consolidation: NASA DART.

public class Main {

    public static void main(String[] args) {

        boolean meteorIsDeflectable = isDeflectable(13, (int)calculateMomentum(calculateMass(10.36)
                        ,convertToMetersPerSecond(30000)), 3, timeToImpact(17399));
        if (meteorIsDeflectable){
            System.out.println("yay earth!");
        } else {
            System.out.println("goodbye, blue planet");
        }
    }

    public static double convertToMetersPerSecond(int milesPerHour) {
        if (milesPerHour < 0) {
            return -1;
        } else {
            double metersPerSecond = (double) milesPerHour * 1.609 / 1000 / 3600;
            return metersPerSecond;
        }
    }

    public static double calculateMass(double radiusInMeters) {
        if (radiusInMeters < 0) {
            return -1;
        } else {
            int densityConstantInKilogramMetersCubed = 7874;   // kg/m3
            double mass = (4/3) * Math.PI * radiusInMeters * radiusInMeters * radiusInMeters  * densityConstantInKilogramMetersCubed;
            // m3 in volume and density cancel. leaves only kg. mass = vol * density
            return mass;
        }
    }

    public static double calculateMomentum(double mass, double velocity) {
        double momentum = mass * velocity;        // momentum = mv (momentum in kgm/s = mass in kg * velocity in m/s)
        return momentum;
    }

    public static int timeToImpact(int hours, int minutes) {
        int totalMinutes = (hours * 60) + minutes;
        return totalMinutes;
    }

    public static int timeToImpact(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int totalMinutes = timeToImpact(hours, minutes);
        return totalMinutes;
    }

    public static boolean isDeflectable(int availableMissiles, int momentum, int deflectionAngleNeeded, int minutesToImpact) {
        int missileDeflectionCapacity = 100000; // 'kg/m/s' deflectable by 1 degree per missile
        int firingRateConstant = 20; //rate of 1 missile fire per 20 minutes
        int missilesFireableUntilImpact = minutesToImpact / firingRateConstant;
        System.out.println("Current number of available missiles for use = " + availableMissiles);
        System.out.println("Number of missiles fireable until impact = " + missilesFireableUntilImpact);
        int missilesNeeded = momentum * deflectionAngleNeeded / missileDeflectionCapacity;
        System.out.println("Number of missiles needed to deflect " + momentum + " kgm/s an angle of " + deflectionAngleNeeded + " degrees = " + missilesNeeded);

        if (availableMissiles < 1){
            return false;
        } else if ((missilesNeeded < availableMissiles) && missilesNeeded < missilesFireableUntilImpact){
            return true;
        } return false;
    }

}



// exercise 1: speed converter: Math.round, casting double/int, if/else
// exercise 2: megabyte converter: remainder function
// exercise 3: barking dog: return boolean
// exercise 4: leap year: if statements
// exercise 5: decimal comparator: if statement and number similarity until certain decimal
// exercise 6: equal sum checker: if statement
// exercise 7: if statements
// method overloading example 1: player score: hard code in value for overloaded variant
// method overloading example 2: length conversion: independent overloaded methods. could have one call the other too
// method overloading example 3: time conversion: overloaded method calls the original method with correct parameters.
// uses leading zero in the case of a digit being under 10
// exercise 8: area calculator: different parameter variables in overloaded method
// exercise 9: minutes to years and days: just math, nothing new
// exercise 10: equal sum checker: nothing new
// exercise 11: playing cat: nothing new


