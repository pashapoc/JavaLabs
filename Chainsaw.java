package ua.lviv.iot.algo.part1;

import lombok.*;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Chainsaw {
        private String brand;
        private int power;
        private double fuelTankCapacity;
        private double fuelLevel;
        private boolean isWorking = false;

        public void cutWood(double length) {
            final double n = 0.1;
            final double requiredFuel = length * n;
            if (requiredFuel > this.fuelLevel) {
                fuelLevel = 0;
                isWorking = false;
            } else {
                isWorking = true;
                fuelLevel -= requiredFuel;
                System.out.printf("length : %.2f\nfuelLevel : %.2f\n", length, fuelLevel );
            }
        }

        public static void main(String[] args) {
        };

        public void start () {
            this.isWorking = true;
        }

        public void stop () {
            this.isWorking = false;
        }

        private static Chainsaw instance = new Chainsaw();

        static Chainsaw getInstance () {
            return instance;
        }
    }
