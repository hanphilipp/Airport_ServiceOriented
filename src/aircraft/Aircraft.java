package aircraft;

import aircraft.body.Seat;
import aircraft.gear.Gear;
import aircraft.wing.Wing;
import airport.ControlArea;
import airport.FieldPoints.Checkpoint;
import airport.FieldPoints.CheckpointName;
import airport.FieldPoints.IAircraftPosition;
import airport.control.events.*;
import com.google.common.eventbus.Subscribe;
import misc.AutoIdGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;


public class Aircraft {
    private long id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private Seat[] seats;
    private Wing[] wings;
    private Gear[] gears;
    //TODO facades
    private double currentFrequency;
    private AircraftName name;

    public Aircraft(String manufacturer, AircraftName name, double currentFrequency) {
        this.manufacturer = manufacturer;
        this.name = name;
        seats = new Seat[568];
        wings = new Wing[2];
        gears = new Gear[5];
        id = AutoIdGenerator.get();
        this.currentFrequency = currentFrequency;
    }

    public long getId() {
        return id;
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }

    public void setCurrentFrequency(double currentFrequency) {
        this.currentFrequency = currentFrequency;
    }

    public AircraftName getName() {
        return name;
    }

    private void writeEventLog(AirportEvent event) {
        writeEventLog(event, "");
    }

    private void writeEventLog(AirportEvent event, String message) {
        File logFile = new File("out/AircraftLogs/" + name + ".txt");

        ArrayList<String> lines = new ArrayList<String>();
        if (!logFile.exists()) {
            logFile.getParentFile().mkdirs();
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(logFile));
                String l;
                while ((l = br.readLine()) != null) {
                    lines.add(l);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        lines.add(new Date() + " : " + event + " : " + message);

        Path file = Paths.get(logFile.getAbsolutePath());
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
            // System.out.println("Log: " + file.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * checks how the event should be handeled
     *
     * @param event
     * @return 0 for nothing, 1 for frequency only, 2 for both
     */
    private int checkEventStats(AirportEvent event) {
        //System.out.print("Event Frequency: " + event.getFrequency());
        //System.out.println(" | Aircraft frequency: " + currentFrequency);

        if (event.getFrequency() == currentFrequency) {
            if (event.getAircraft().getId() == this.id) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Subscribe
    public void taxi(TaxiEvent taxiEvent) {//TODO function
        int eventStatus = checkEventStats(taxiEvent);
        if (eventStatus == 1) {
            //System.out.println("Receiving message but not acting");
            writeEventLog(taxiEvent, "Received but not acted on");
        } else if (eventStatus == 2) {
            //System.out.println(name + " acting on message " + taxiEvent);
            IAircraftPosition last = new Checkpoint(CheckpointName.L1, ControlArea.Apron);
            for (IAircraftPosition p : taxiEvent.getPositions()) {
                last.removeAircraft();
                p.setAircraft(this);
            }
            writeEventLog(taxiEvent, "Received and acted on");
        } else if (eventStatus == 0) {
            //do nothing because its acting on a different frequency
        } else {
            throw new RuntimeException("Unkown event status: " + eventStatus);
        }
    }

    @Subscribe
    public void holdShort(HoldShortEvent holdShortEvent) {//TODO function
        int eventStatus = checkEventStats(holdShortEvent);
        if (eventStatus == 1) {
            writeEventLog(holdShortEvent, "Received but not acted on");
        }
        if (eventStatus == 2) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeEventLog(holdShortEvent, "Received and acted on");
        }
    }

    @Subscribe
    public void takeOff(RunwayClearedForTakeOffEvent runwayClearedForTakeOffEvent) {//TODO function
        int eventStatus = checkEventStats(runwayClearedForTakeOffEvent);
        if (eventStatus == 1) {
            writeEventLog(runwayClearedForTakeOffEvent, "Received but not acted on");
        }
        if (eventStatus == 2) {
            System.out.println(name + " taking off");
            writeEventLog(runwayClearedForTakeOffEvent, "Received and acted on");
        }
    }

    @Subscribe
    public void land(RunwayClearedToLandEvent runwayClearedToLandEvent) {//TODO function
        int eventStatus = checkEventStats(runwayClearedToLandEvent);
        if (eventStatus == 1) {
            writeEventLog(runwayClearedToLandEvent, "Received but not acted on");
        }
        if (eventStatus == 2) {
            System.out.println(name + " landing");
            writeEventLog(runwayClearedToLandEvent, "Received and acted on");
        }
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
