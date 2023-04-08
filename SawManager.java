package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

import java.util.LinkedList;
import java.util.stream.Collectors;

@ToString
public class SawManager {
    public void addSaw (final Saw gasSaw) {
        saws.add (gasSaw);
    }

    private final LinkedList <Saw> saws = new LinkedList<Saw> ();

    public LinkedList <Saw> findSawByPowerQuantity (int power) {
        return saws.stream ()
                    .filter ((object) -> object.getPower () > power)
                    .collect (Collectors.toCollection (LinkedList::new));
    }

    public LinkedList <Saw> findSawByWorkTime (double workInHours) {
        return saws.stream ()
                    .filter ((object) -> object.getWorkInHours () > workInHours)
                    .collect (Collectors.toCollection (LinkedList::new));
    }

    public static void main (String[] args) {
        SawManager sawManager = new SawManager ();
        Chainsaw chainsaw = new Chainsaw (1, 0.8, 0.1, "Husqvarna", 3000, 0.50, false);
        Chainsaw chainsaw1 = new Chainsaw (1.4, 0.7, 0.1, "Supretto", 2800, 0.60, false);
        ElectricSaw electricSaw = new ElectricSaw ("Blades", 240, 180, "Husqvarna", 3700, 1.20, false);
        ElectricSaw electricSaw1 = new ElectricSaw ("Blades", 200, 160, "Supretto", 2900, 1.60, false);
        Chainsaw gasSaw = new Chainsaw (2, 1.6, 0.4, "Husqvarna", 2600, 0.50, false);
        MiniRechargeableSaw miniRechargeableSaw = new MiniRechargeableSaw (230, "Lithium Ion", 180, "Supretto", 550, 2, false);
        MiniRechargeableSaw miniRechargeableSaw1 = new MiniRechargeableSaw (220, "Lithium Polymer", 180, "BLACK+DECKER", 700, 1.80, false);
        ReciprocatingSaw reciprocatingSaw = new ReciprocatingSaw (210, "Break",140, "BLACK+DECKER", 1800, 1.20, false);
        ReciprocatingSaw reciprocatingSaw1 = new ReciprocatingSaw (180, "Break",130, "Supretto", 2100, 1.10,false);
        sawManager.addSaw (chainsaw);
        sawManager.addSaw (chainsaw1);
        sawManager.addSaw (electricSaw);
        sawManager.addSaw (electricSaw1);
        sawManager.addSaw (miniRechargeableSaw);
        sawManager.addSaw (miniRechargeableSaw1);
        sawManager.addSaw (reciprocatingSaw);
        sawManager.addSaw (reciprocatingSaw1);
        sawManager.addSaw (gasSaw);
        for (Saw object : sawManager.saws) {
            System.out.println (object);
        }
        System.out.println (sawManager.findSawByPowerQuantity(2000));
        System.out.println (sawManager.findSawByWorkTime(0.70));
    }
}