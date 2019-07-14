import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Simulator{
    private static List<Flyable>flyables = new ArrayList<Flyable>();
    public static void main(String[] arg) throws InterruptedException{
        PrintStream stdout = System.out;
        try{
            if (arg.length < 1)
                return;

            PrintStream fileOut = new PrintStream("simulation.txt");
            System.setOut(fileOut);
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null){
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0){
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while((line = reader.readLine()) != null){
                    // ignores blank lines
                    if(line.trim().length() > 0){
                        Flyable flyable = AircraftFactory.newAircraft(
                            line.split(" ")[0],
                            line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                        flyables.add(flyable);
                    }
                }
                for (Flyable flyable :flyables){
                    // ignores invalid types
                    if(flyable != null)
                        flyable.registerTower();
                }
                for (int i = 1; i <= simulations; i++){
                    for (Flyable flyable :flyables){
                        if(flyable != null)
                            flyable.updateConditions();
                    }
                }
            }
            reader.close();
            System.setOut(stdout);
        }
        catch (FileNotFoundException e){
            System.setOut(stdout);
            System.out.println("Couldn't find file " + arg[0]);
        } catch (IOException e){
            System.setOut(stdout);
            System.out.println("There was an error while reading the file " + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.setOut(stdout);
            System.out.println("Specify simulation file.");
        } catch (NumberFormatException nfe) {
            System.setOut(stdout);
            System.out.println("File contains invalid input data.");
        }
    }
}