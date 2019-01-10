/**
 * Simulates the Wokflow of the Airport
 */
public class Simulation {

    /**
     * kickoff for the simulation
     *
     * Ablauf:
     *
     *         Zu Beginn der Simulation wird die Windrichtung (Osten ► Westen, Start/Landung 08,
     *         Westen ► Osten, Start/Landung 26) zufällig bestimmt. Flugzeuge starten gegen den Wind
     *         landen mit dem Wind.
     *         Zu Simulationszwecken befinden sich 10 Flugzeuge (F11-F20) im Landeanflug.
     *         Landung (F11-F20) und Start (F01-F10) wechseln sich sukzessive einander ab.
     *         Nachfolgend ist ein Beispiel für Koordination/Kommunikation aufgeführt.
     *         (01) RunwayCleared-ToLand(F11,O8L), HoldShort(F11,S1), Taxi(F01,S04,O2 | O3 | O4 | O5 | X9 |
     *         M6), HoldShort(F01,S4) , Taxi(F11,A01,O1), RunwayClearedForTakeOff(F01,O8R),
     *         (02) RunwayClearedToLand(F12,O8R), HoldShort(F12,S3), Taxi(F02,S2,N2 | X4 | L1),
     *         HoldShort(F02,S2), Taxi(F12,A02,N6 | N5 | N4 | N3,A02), RunwayClearedForTakeOff(F02,O8L).
     *         Die Vorfeldkontrolle und der Tower nutzen eine gemeinsame AODB (Airport Operations Database)
     *         für die Aufzeichnung (#, aircraft_id, unix_timestamp, event_message). Jedes Flugzeug zeichnet
     *         in einem FlightRecorder – realisiert als Logfile – die empfangenen Events mit Zeitstempel auf.
     *
     * @param args currently no function
     */
    public static void main(String[] args) {
        System.out.println("This function will start the airport simulation in the future");

    }
}
