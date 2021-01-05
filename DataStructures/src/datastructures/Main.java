package datastructures;

import datastructures.FastReaderFile;
import datastructures.FastReaderConsole;
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
    public static FileWriter debug;

    public static void main(String[] args) throws IOException {
        FastReaderFile scanner = new FastReaderFile();
        FastReaderConsole consoleScanner = new FastReaderConsole();
        out = new FileWriter("output.txt");
        debug = new FileWriter("debug.txt");
        debug.write("Successfully created input and output\n");
        String characterName = scanner.nextLine();
        String dmgType = scanner.nextLine();
        debug.write("Successfully inputted the character name and damage type\n");
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
        debug.write("Successfully inputted the character's weapon\n");
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
        //Sort Artifacts from highest level to lowest level
        Collections.sort(character1.getArtifacts(), Collections.reverseOrder());
        debug.write("Successfully inputed character's artifacts\n");
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
        debug.write("Successfully inputed character's stats\n");
//        character1.printStats();
//        System.out.println("Sucessfully Printed Stats");
        boolean firstRun = true;
        boolean firstPrint = true;
        while (true) {
            if (firstRun) {
                firstRun = false;
            } else {
                System.out.println("===================================");
            }
            System.out.println("Do you want to change any stats: (type the number)");
            System.out.println("1. Character Stats");
            System.out.println("2. Weapon Stats");
            System.out.println("3. Artifacts Stats or Add/Change Artifacts");
            System.out.println("4. Print Stats");
            System.out.println("5. No More Changes");
            int mainInput = consoleScanner.nextInt();
            if (mainInput == 1) {
                System.out.println("Do you want to change:");
                System.out.println("1. Character Name");
                System.out.println("2. Damage Type");
                System.out.println("3. Character Stats");
                System.out.println("4. Go Back");
                int subInput = consoleScanner.nextInt();
                if (subInput == 1) {
                    System.out.println("What is the name of the character: (please put on one line)");
                    characterName = consoleScanner.nextLine();
                    character1.setName(characterName);
                    debug.write("Successfully changed name\n");
                } else if (subInput == 2) {
                    System.out.println("What is the damage type of the character: (please put on one line)");
                    dmgType = consoleScanner.nextLine();
                    character1.setDmgType(characterName);
                    debug.write("Successfully changed dmgType\n");
                } else if (subInput == 3) {
                    boolean delete = true;
                    while (true) {
                        System.out.println("Do you want to delete a stat? Y/N");
                        String deleteInput = consoleScanner.nextLine().toUpperCase();
                        if (deleteInput.equals("Y")) {
                            //Already set as true
                            break;
                        } else if (deleteInput.equals("N")) {
                            delete = false;
                            break;
                        } else {
                            System.out.println("Invalid input, please retype");
                        }
                    }
                    if (delete) {
                        System.out.println("What is the name of the stat you want to delete?");
                        String statName = consoleScanner.nextLine();
                        System.out.println("What is the new number you want to delete?");
                        double statNumber = consoleScanner.nextDouble();
                        boolean isScaling = true;
                        while (true) {
                            System.out.println("Is this stat scaling? Y/N");
                            String scalingInput = consoleScanner.nextLine().toUpperCase();
                            if (scalingInput.equals("Y")) {
                                //Already set as true
                                break;
                            } else if (scalingInput.equals("N")) {
                                isScaling = false;
                                break;
                            } else {
                                System.out.println("Invalid input, please retype");
                            }
                        }
                        character1.deleteSubStat(statName, statNumber, isScaling);
                        debug.write("Successfully deleted character stat\n");
                    } else {
                        System.out.println("What is the name of the stat you want to change/add?");
                        String statName = consoleScanner.nextLine();
                        boolean change = false;
                        int index = 0;
                        for (index = 0; index < character1.getAttributes().size(); index++) {
                            if (character1.getAttributes().get(index).getName().equals(statName)) {
                                change = true;
                                break;
                            }
                        }
                        System.out.println("What is the new number you want?");
                        double statNumber = consoleScanner.nextDouble();
                        boolean isScaling = true;
                        while (true) {
                            System.out.println("Is this stat scaling? Y/N");
                            String scalingInput = consoleScanner.nextLine().toUpperCase();
                            if (scalingInput.equals("Y")) {
                                //Already set as true
                                break;
                            } else if (scalingInput.equals("N")) {
                                isScaling = false;
                                break;
                            } else {
                                System.out.println("Invalid input, please retype");
                            }
                        }
                        if (change == true) {
                            character1.getAttributes().set(index, new Attributes(statName, statNumber, isScaling));
                        } else {
                            character1.addSubStats(statName, statNumber, isScaling);
                        }
                        debug.write("Successfully changed/added stat\n");
                    }
                } else if (subInput == 4) {
                    //Do nothing and go back
                } else {
                    System.out.println("Please Type a Valid Number");
                }
            } else if (mainInput == 2) {
                System.out.println("Do you want to change:");
                System.out.println("1. Weapon Name");
                System.out.println("2. Weapon Type");
                System.out.println("3. Weapon Stats");
                System.out.println("4. Go Back");
                int subInput = consoleScanner.nextInt();
                if (subInput == 1) {
                    System.out.println("What is the name of the weapon: (please put on one line)");
                    weaponName = consoleScanner.nextLine();
                    character1.getWeapon().setName(weaponName);
                    debug.write("Successfully changed name of weapon\n");
                } else if (subInput == 2) {
                    System.out.println("What is the type of weapon: (please put on one line)");
                    weaponType = consoleScanner.nextLine();
                    character1.getWeapon().setType(weaponType);
                    debug.write("Successfully changed weaponType\n");
                } else if (subInput == 3) {
                    boolean mainStat = true;
                    while (true) {
                        System.out.println("Do you want to change/delete/add a Main stat? Y/N");
                        String deleteInput = consoleScanner.nextLine().toUpperCase();
                        if (deleteInput.equals("Y")) {
                            //Already set as true
                            break;
                        } else if (deleteInput.equals("N")) {
                            mainStat = false;
                            break;
                        } else {
                            System.out.println("Invalid input, please retype");
                        }
                    }
                    boolean delete = true;
                    while (true) {
                        System.out.println("Do you want to delete a stat? Y/N");
                        String deleteInput = consoleScanner.nextLine().toUpperCase();
                        if (deleteInput.equals("Y")) {
                            //Already set as true
                            break;
                        } else if (deleteInput.equals("N")) {
                            delete = false;
                            break;
                        } else {
                            System.out.println("Invalid input, please retype");
                        }
                    }
                    if (delete) {
                        System.out.println("What is the name of the stat you want to delete?");
                        String statName = consoleScanner.nextLine();
                        int index = 0;
                        for (index = 0; index < character1.getWeapon().getAttributes().size(); index++) {
                            if (character1.getWeapon().getAttributes().get(index).getName().equals(statName)) {
                                break;
                            }
                        }
                        System.out.println("What is the new number you want to delete?");
                        double statNumber = consoleScanner.nextDouble();
                        boolean isScaling = true;
                        while (true) {
                            System.out.println("Is this stat scaling? Y/N");
                            String scalingInput = consoleScanner.nextLine().toUpperCase();
                            if (scalingInput.equals("Y")) {
                                //Already set as true
                                break;
                            } else if (scalingInput.equals("N")) {
                                isScaling = false;
                                break;
                            } else {
                                System.out.println("Invalid input, please retype");
                            }
                        }
                        if (mainStat) {
                            character1.getWeapon().deleteMainStat();
                        } else {
                            character1.getWeapon().deleteSubStat(statName, statNumber, isScaling);
                        }
                        debug.write("Successfully deleted weapon stat");
                    } else {
                        System.out.println("What is the name of the stat you want to change/add?");
                        String statName = consoleScanner.nextLine();
                        boolean change = false;
                        int index;
                        if (mainStat) {
                            index = 0;
                        } else {
                            index = 1;
                            for (index = 0; index < character1.getWeapon().getAttributes().size(); index++) {
                                if (character1.getWeapon().getAttributes().get(index).getName().equals(statName)) {
                                    change = true;
                                    break;
                                }
                            }
                        }
                        System.out.println("What is the new number you want?");
                        double statNumber = consoleScanner.nextDouble();
                        boolean isScaling = true;
                        while (true) {
                            System.out.println("Is this stat scaling? Y/N");
                            String scalingInput = consoleScanner.nextLine().toUpperCase();
                            if (scalingInput.equals("Y")) {
                                //Already set as true
                                break;
                            } else if (scalingInput.equals("N")) {
                                isScaling = false;
                                break;
                            } else {
                                System.out.println("Invalid input, please retype");
                            }
                        }
                        if (change == true) {
                            if (mainStat) {
                                character1.getWeapon().setMainAttribute(statName, statNumber, isScaling);
                            } else {
                                character1.getWeapon().getAttributes().set(index, new Attributes(statName, statNumber, isScaling));
                            }
                        } else {
                            if (mainStat) {
                                character1.getWeapon().setMainAttribute(statName, statNumber, isScaling);
                            } else {
                                character1.getWeapon().addSubStats(statName, statNumber, isScaling);
                            }
                        }
                        debug.write("Successfully changed/added stat\n");
                    }
                } else if (subInput == 4) {
                    //Do nothing and go back
                } else {
                    System.out.println("Please Type a Valid Number");
                }
            } else if (mainInput == 3) {
                boolean delete = true;
                while (true) {
                    System.out.println("Do you want to delete an artifact? Y/N");
                    String deleteInput = consoleScanner.nextLine().toUpperCase();
                    if (deleteInput.equals("Y")) {
                        //Already set as true
                        break;
                    } else if (deleteInput.equals("N")) {
                        delete = false;
                        break;
                    } else {
                        System.out.println("Invalid input, please retype");
                    }
                }
                if (delete) {
                    System.out.println("What is the name of the artifact you want to delete?");
                    String artifactName = consoleScanner.nextLine();
                    int index = 0;
                    for (index = 0; index < character1.getArtifacts().size(); index++) {
                        if (character1.getArtifacts().get(index).getName().equals(artifactName)) {
                            break;
                        }
                    }
                    character1.getArtifacts().remove(index);
                    debug.write("Successfully deleted artifact");
                } else {
                    System.out.println("What is the name of the artifact you want to change/add?");
                    String artifactName = consoleScanner.nextLine();
                    boolean change = false;
                    int index = 0;
                    for (index = 0; index < character1.getArtifacts().size(); index++) {
                        if (character1.getArtifacts().get(index).getName().equals(artifactName)) {
                            change = true;
                            break;
                        }
                    }
                    System.out.println("What is the set of the artifact you want to change/add?");
                    String artifactSet = consoleScanner.nextLine();
                    System.out.println("What is the piece of the artifact you want to change/add?");
                    String artifactPiece = consoleScanner.nextLine();
                    System.out.println("What is the name of the 2 Set Bonus artifact you want to change/add?");
                    String artifact2SetBonus = consoleScanner.nextLine();
                    System.out.println("What is the name of the 4 Set Bonus artifact you want to change/add?");
                    String artifact4SetBonus = consoleScanner.nextLine();
                    System.out.println("What is the level of the artifact you want to change/add?");
                    int level = consoleScanner.nextInt();
                    System.out.println("What is the number of stats of the artifact you want to change/add?");
                    int numOfStats = consoleScanner.nextInt();
                    ArrayList<Attributes> stats = new ArrayList<Attributes>();
                    for (int statIndex = 0; statIndex < numOfStats; statIndex++) {
                        System.out.println("What is the name of the stat you want to change/add?");
                        String statName = consoleScanner.next();
                        System.out.println("What is the stat number of the artifact you want to change/add?");
                        double statNumber = consoleScanner.nextDouble();
                        boolean isScaling = true;
                        while (true) {
                            System.out.println("Is the the artifact scaling? Y/N");
                            String scalingInput = consoleScanner.nextLine().toUpperCase();
                            if (scalingInput.equals("Y")) {
                                //Already set as true
                                break;
                            } else if (scalingInput.equals("N")) {
                                isScaling = false;
                                break;
                            } else {
                                System.out.println("Invalid input, please retype");
                            }
                        }
                        stats.add(new Attributes(statName, statNumber, isScaling));
                    }
                    if (change) {
                        character1.replaceArtifacts(index, new Artifacts(artifactName, artifactSet, artifactPiece, artifact2SetBonus, artifact4SetBonus, level, stats));
                    } else {
                        character1.addArtifacts(new Artifacts(artifactName, artifactSet, artifactPiece, artifact2SetBonus, artifact4SetBonus, level, stats));
                    }
                    debug.write("Successfully changed/add artifact");
                }
            } else if (mainInput == 4) {
                if (firstPrint) {
                    firstPrint = false;
                } else {
                    out.write("=================================================================\n");
                }
                character1.printStats();
                System.out.println("Successfully Printed to Output File");
                debug.write("Successfully Printed to Output File\n");
            } else if (mainInput == 5) {
                System.out.println("Good bye");
                break;
            } else {
                System.out.println("Please Enter Valid Number (1-4)");
            }
        }
        out.close();
        debug.close();
    }
}
