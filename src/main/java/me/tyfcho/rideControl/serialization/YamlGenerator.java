package me.tyfcho.rideControl.serialization;

import me.tyfcho.rideControl.ride.Ride;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Generates YAML files for per-attraction registration.
 */
public class YamlGenerator {

    /**
     * Generates a folder and a YAML file for each ride.
     *
     * @param rides      The list of rides to serialize.
     * @param outputDir  The directory to save the YAML files.
     * @throws IOException If an error occurs while writing the files.
     */
    public void generateYamlFilesPerAttraction(Iterable<Ride> rides, String outputDir) throws IOException {
        // Create the output directory if it doesn't exist
        File directory = new File(outputDir);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Failed to create output directory: " + outputDir);
        }

        // Configure YAML options
        DumperOptions options = new DumperOptions();
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(options);

        // Generate a YAML file for each ride
        for (Ride ride : rides) {
            Map<String, Object> rideData = new HashMap<>();
            rideData.put("id", ride.getId());
            rideData.put("name", ride.getName());
            rideData.put("logicGates", ride.getLogicGates().size());

            File file = new File(directory, ride.getId() + ".yaml");
            try (FileWriter writer = new FileWriter(file)) {
                yaml.dump(rideData, writer);
            }
        }
    }
}