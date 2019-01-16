import aircraft.Aircraft;
import aircraft.AircraftName;
import airport.Airport;
import airport.FieldPoints.*;
import airport.Gate;
import airport.GateName;
import misc.WindDirection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Simulates the Wokflow of the Airport
 */
public class Simulation {

    ArrayList<Checkpoint> checkpoints;
    ArrayList<Gate> gates;

    /**
     * kickoff for the simulation
     * <p>
     * Ablauf:
     * <p>
     * Zu Beginn der Simulation wird die Windrichtung (Osten ► Westen, Start/Landung 08,
     * Westen ► Osten, Start/Landung 26) zufällig bestimmt. Flugzeuge starten gegen den Wind
     * landen mit dem Wind.
     * Zu Simulationszwecken befinden sich 10 Flugzeuge (F11-F20) im Landeanflug.
     * Landung (F11-F20) und Start (F01-F10) wechseln sich sukzessive einander ab.
     * Nachfolgend ist ein Beispiel für Koordination/Kommunikation aufgeführt.
     * (01) RunwayCleared-ToLand(F11,O8L), HoldShort(F11,S1), Taxi(F01,S04,O2 | O3 | O4 | O5 | X9 |
     * M6), HoldShort(F01,S4) , Taxi(F11,A01,O1), RunwayClearedForTakeOff(F01,O8R),
     * (02) RunwayClearedToLand(F12,O8R), HoldShort(F12,S3), Taxi(F02,S2,N2 | X4 | L1),
     * HoldShort(F02,S2), Taxi(F12,A02,N6 | N5 | N4 | N3,A02), RunwayClearedForTakeOff(F02,O8L).
     * Die Vorfeldkontrolle und der Tower nutzen eine gemeinsame AODB (Airport Operations Database)
     * für die Aufzeichnung (#, aircraft_id, unix_timestamp, event_message). Jedes Flugzeug zeichnet
     * in einem FlightRecorder – realisiert als Logfile – die empfangenen Events mit Zeitstempel auf.
     *
     * @param args currently no function
     */
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.runSim();
    }

    /**
     * actual internal routine
     */
    private void runSim() {
        System.out.println("Starting simulation");

        System.out.println("Building Airport");
        Airport airport = new Airport("Simulation", WindDirection.random());
        System.out.println("Finished building Airport");
        double[] f = airport.getFrequencies();
        airport.addAircrafts(genAircrafts(airport.getAllCheckpoints(), airport.getGatesList(), f));
        airport.printAircraftPositions();
        moveAirplanes(airport);
        airport.printAircraftPositions();


        System.out.println("Ending simulation");
    }

    /**
     *
     */
    private void moveAirplanes(Airport airport) {
        System.out.println("Starting movement");
        airport.land(AircraftName.F11);
        airport.takeOff(AircraftName.F01);
        airport.land(AircraftName.F12);
        airport.takeOff(AircraftName.F02);
        airport.land(AircraftName.F13);
        airport.takeOff(AircraftName.F03);
        airport.land(AircraftName.F14);
        airport.takeOff(AircraftName.F04);
        airport.land(AircraftName.F15);
        airport.takeOff(AircraftName.F05);
        airport.land(AircraftName.F16);
        airport.takeOff(AircraftName.F06);
        airport.land(AircraftName.F17);
        airport.takeOff(AircraftName.F07);
        airport.land(AircraftName.F18);
        airport.takeOff(AircraftName.F08);
        airport.land(AircraftName.F19);
        airport.takeOff(AircraftName.F09);
        airport.land(AircraftName.F20);
        System.out.println("Finished moving");
    }

    private HashMap<Aircraft, IAircraftPosition> genAircrafts(ArrayList<Checkpoint> c, ArrayList<Gate> g, double[] frequencies) {
        checkpoints = c;
        gates = g;
        System.out.println("Generating Aircrafts and Mappings");
        HashMap<Aircraft, IAircraftPosition> a = new HashMap<>();

        //Flying Aircrafts
        a.put(new Aircraft("Simulator", AircraftName.F11, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F12, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F13, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F14, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F15, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F16, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F17, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F18, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F19, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));
        a.put(new Aircraft("Simulator", AircraftName.F20, frequencies[0]), findCheckpointsByName(CheckpointName.AIR));

        //Grounded Aircrafts
        a.put(new Aircraft("Simulator", AircraftName.F01, frequencies[1]), findCheckpointsByName(CheckpointName.O3));
        a.put(new Aircraft("Simulator", AircraftName.F02, frequencies[1]), findCheckpointsByName(CheckpointName.N3));
        a.put(new Aircraft("Simulator", AircraftName.F03, frequencies[1]), findGateByName(GateName.A01));
        a.put(new Aircraft("Simulator", AircraftName.F04, frequencies[1]), findGateByName(GateName.A02));
        a.put(new Aircraft("Simulator", AircraftName.F05, frequencies[1]), findGateByName(GateName.A04));
        a.put(new Aircraft("Simulator", AircraftName.F06, frequencies[1]), findGateByName(GateName.A05));
        a.put(new Aircraft("Simulator", AircraftName.F07, frequencies[1]), findGateByName(GateName.B01));
        a.put(new Aircraft("Simulator", AircraftName.F08, frequencies[1]), findGateByName(GateName.B03));
        a.put(new Aircraft("Simulator", AircraftName.F09, frequencies[1]), findGateByName(GateName.B04));
//TODO Where is F10

        System.out.println("Finished generation");
        return a;
    }

    private Checkpoint findCheckpointsByName(CheckpointName n) {
        for (Checkpoint c : checkpoints) {
            if (c.getClass() == Checkpoint.class && c.getName() == n) {
                return c;
            }
        }
        throw new RuntimeException("Checkpoint with name: " + n + " not available!");
    }

    private Crossway findCheckpointsByName(CrosswayName n) {
        for (Checkpoint c : checkpoints) {
            if (c instanceof Crossway && ((Crossway) c).getCrosswayName() == n) {
                return (Crossway) c;
            }
        }
        throw new RuntimeException("Checkpoint with name: " + n + " not available!");
    }

    private Gate findGateByName(GateName n) {
        for (Gate c : gates) {
            if (c instanceof Gate && c.getName() == n) {
                return c;
            }
        }
        throw new RuntimeException("Gate with name: " + n + " not available!");
    }

}
