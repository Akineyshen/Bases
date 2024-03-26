import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Base {
    double degrees;

    public Base(double degrees, double minutes) {
        this.degrees = degrees + minutes / 60.0;
    }
}

public class Main {

    public static void maxBasesInSectorV1(List<Base> bases) {
        long startTime = System.currentTimeMillis();

            int maxBasesIn90Degrees = 0;

            for (Base startBase : bases) {
                for (int offset = 0; offset < 360; offset++) {
                    double startDegrees = (startBase.degrees + offset) % 360;
                    double endDegrees = (startDegrees + 90) % 360;

                    int basesInSector = 0;

                    for (Base targetBase : bases) {
                        double targetDegrees = targetBase.degrees;

                        if (startDegrees <= endDegrees) {
                            if (targetDegrees >= startDegrees && targetDegrees <= endDegrees) {
                                basesInSector++;
                            }
                        } else {
                            if (targetDegrees >= startDegrees || targetDegrees <= endDegrees) {
                                basesInSector++;
                            }
                        }
                    }

                    maxBasesIn90Degrees = Math.max(maxBasesIn90Degrees, basesInSector);
                }
            }

            System.out.println(maxBasesIn90Degrees);

        long endTime = System.currentTimeMillis();
        System.out.println("Time V1: " + (endTime - startTime) + "ms");
    }

    public static void maxBasesInSectorV2(List<Base> bases) {
        long startTime = System.currentTimeMillis();

        int maxBasesIn90Degrees = 0;

        for (Base startBase : bases) {
            int basesInSector = 0;
            for (Base targetBase : bases) {
                double diff = (targetBase.degrees - startBase.degrees + 360) % 360;
                if (diff < 90) {
                    basesInSector++;
                }
            }

            maxBasesIn90Degrees = Math.max(maxBasesIn90Degrees, basesInSector);
        }

        System.out.println(maxBasesIn90Degrees);

        long endTime = System.currentTimeMillis();
        System.out.println("Time V2: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        List<Base> bases = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"))) {
            String line;
            if ((line = reader.readLine()) != null) {
                int numBases = Integer.parseInt(line);
                for (int i = 0; i < numBases; i++) {
                    if ((line = reader.readLine()) != null) {
                        String[] coordinates = line.split(" ");
                        bases.add(new Base(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        maxBasesInSectorV1(new ArrayList<>(bases));
        maxBasesInSectorV2(bases);
    }
}


















