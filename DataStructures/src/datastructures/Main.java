package datastructures;

import datastructures.FastReader;
import datastructures.Stats;
import datastructures.Attributes;
import datastructures.Artifacts;
import java.util.*;
import java.io.*;

/**
 * Genshin Impact Stats
 *
 * @author Franklin Gao
 * @version 1.0 (current version number of program)
 * @since 1.8 (the version of the package this class was first added to)
 */

public class Main {

    public static FileWriter out;

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        out = new FileWriter("output.txt");
        String characterName = scanner.nextLine();
        String dmgType = scanner.nextLine();
        //input the weapons
        String weaponName = scanner.nextLine();
        String weaponType = scanner.nextLine();
        int weaponLevel = scanner.nextInt();
        ArrayList<Attributes> weaponStats = new ArrayList<Attributes>();
        for (int index = 0; index < 2; index++) {
                String statName = scanner.next();
                double statNumber = scanner.nextDouble();
                String scaling = scanner.next();
                boolean isScaling = false;
                if (scaling.equals("true")) {
                    isScaling = true;
                }
                weaponStats.add(new Attributes(statName, statNumber, isScaling));
        }
        Character character1 = new Character(characterName, dmgType, new Weapon(weaponName, weaponType, weaponLevel, weaponStats), new ArrayList<Artifacts>());
        //input the artifacts
        int numOfArtifacts = scanner.nextInt();
        for (int index = 0; index < numOfArtifacts; index++) {
            String artifactName = scanner.nextLine();
            String artifactSet = scanner.nextLine();
            String artifactPiece = scanner.nextLine();
            String artifact2SetBonus = scanner.nextLine();
            String artifact4SetBonus = scanner.nextLine();
            int level = scanner.nextInt();
            int numOfStats = scanner.nextInt();
            ArrayList<Attributes> stats = new ArrayList<Attributes>();
            for (int statIndex = 0; statIndex < numOfStats; statIndex++) {
                String statName = scanner.next();
                double statNumber = scanner.nextDouble();
                String scaling = scanner.next();
                boolean isScaling = false;
                if (scaling.equals("true")) {
                    isScaling = true;
                }
                stats.add(new Attributes(statName, statNumber, isScaling));
            }
            character1.addArtifacts(new Artifacts(artifactName, artifactSet, artifactPiece, artifact2SetBonus, artifact4SetBonus, level, stats));
        }
        //input the character stats
        int characterStats = scanner.nextInt();
        for (int index = 0; index < 4; index++) {
            String statName = scanner.next();
            double statNumber = scanner.nextDouble();
            String scaling = scanner.next();
            boolean isScaling = false;
            if (scaling.equals("true")) {
                isScaling = true;
            }
            character1.addSubStats(statName, statNumber, isScaling);
        }
        character1.printStats();
        out.close();
    }
    
}
