package aui.skay44.lab3;

import aui.skay44.lab3.miningDrill.MiningDrill;
import aui.skay44.lab3.miningDrill.MiningDrillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class CMDRunner implements CommandLineRunner {

    private final AsteroidService asteroidService;
    private final MiningDrillService miningDrillService;

    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public CMDRunner(AsteroidService asteroidService,MiningDrillService miningDrillService) {
        this.asteroidService = asteroidService;
        this.miningDrillService = miningDrillService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("AMX company");
        System.out.println("type \"help\" for list of all commands");
        boolean running = true;

        while(running){
            System.out.print(">:");
            String nextLine = scanner.nextLine();
            String[] command = nextLine.split(" ");

            switch (command[0]){
                case "help":
                    help(command);
                    break;
                case "getall":
                    getAll(command);
                    break;
                case "add":
                    add(command);
                    break;
                case "delete":
                    delete(command);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    unknownCommand(command);
            }
        }

        //asteroidService.getAllAsteroids().forEach(System.out::println);
        //miningDrillService.getAllMiningDrills().forEach(System.out::println);
    }

    private void help(String[] command){
        if(command.length == 1){
            System.out.println("List of commands:");
            System.out.println("\t\"add\"");        //[type] [element]
            System.out.println("\t\"delete\"");     //[type] [element]
            System.out.println("\t\"exit\"");
            System.out.println("\t\"getall\"");     //[type]
        }
        else{
            unknownCommand(Arrays.copyOfRange(command,1,command.length));
        }
    }

    private void getAll(String[] command){
        if(command.length == 1){
            System.out.println("Usage of getall:");
            System.out.println("getall <asteroids/drills>");
            System.out.println("\t asteroids - prints all asteroids");
            System.out.println("\t drills - prints all mining drills");
        }
        else if(command.length == 2){
            if(Objects.equals(command[1], "asteroids")){
                asteroidService.getAllAsteroids().forEach(System.out::println);
            }
            else if(Objects.equals(command[1], "drills")){
                miningDrillService.getAllMiningDrills().forEach(System.out::println);
            }
            else{
                unknownCommand(Arrays.copyOfRange(command,1,command.length));
            }
        }
        else{
            System.out.println("Invalid amount of arguments");
        }
    }

    private void add(String[] command){
        if(command.length == 1){
            System.out.println("Usage of add:");
            System.out.println("add <asteroid/drill> <...args>");
            System.out.println("\tasteroid - add to asteroids");
            System.out.println("\tdrill - add to mining drills");
            System.out.println("\t<...ars> for asteroid: <name> <size>");
            System.out.println("\t<...ars> for mining drill: <name> <drillSize>");
        }
        else if(command.length == 4 || command.length == 5){
            if(Objects.equals(command[1], "asteroid")) {
                String asteroidName = command[2];
                Integer asteroidSize = Integer.parseInt(command[3]);

                ArrayList<MiningDrill> m = new ArrayList<MiningDrill>();
                Asteroid newAstr = new Asteroid(UUID.randomUUID(),asteroidName,asteroidSize,m);
                asteroidService.saveAsteroid(newAstr);
            }
            else if(Objects.equals(command[1], "drill")){
                String drillName = command[2];
                Integer drillSize = Integer.parseInt(command[3]);
                Optional<Asteroid> astr = asteroidService.findByName(command[4]);
                if(astr.isPresent()){
                    MiningDrill newDrill = new MiningDrill(UUID.randomUUID(),drillName,drillSize,astr.get(), astr.get().id);
                    miningDrillService.saveMiningDrill(newDrill);
                }

            }
            else{
                System.out.println("Unknown name: " + command[1]);
            }
        }
        else{
            System.out.println("Invalid amount of arguments");
        }
    }

    @Transactional
    private void delete(String[] command){
        if(command.length == 1){
            System.out.println("Usage of delete:");
            System.out.println("delete <asteroid/drill> <field> <value>");
            System.out.println("\tasteroid - delete from asteroids");
            System.out.println("\tdrill - delete from mining drills");
            System.out.println("\tfield - name of field in which the value will be searched");
            System.out.println("\tvalue - value of certain field to look for, when the object with correct value is found that object will be removed");
        }
        else if(command.length == 4){
            if(Objects.equals(command[1], "asteroid")) {
                Optional<Asteroid> astr = Optional.empty();
                if(Objects.equals(command[2], "id")){
                    astr = asteroidService.getAsteroidById(UUID.fromString(command[3]));
                }
                else if(Objects.equals(command[2], "name")){
                    astr = asteroidService.findByName(command[3]);
                }
                else if(Objects.equals(command[2], "size")){
                    astr = asteroidService.findBySize(Integer.parseInt(command[3]));
                }
                else{
                    System.out.println("Wrong name of a field.");
                }
                if(astr.isPresent()){
                    System.out.println("deleting asteroid...");
                    asteroidService.deleteAsteroid(astr.get().id);
                }
                else{
                    System.out.println("Couldn't find asteroid with given values.");
                }
            }
            else if(Objects.equals(command[1], "drill")){
                Optional<MiningDrill> drill = Optional.empty();
                if(Objects.equals(command[2], "id")){
                    drill = miningDrillService.getMiningDrillById(UUID.fromString(command[3]));
                }
                else if(Objects.equals(command[2], "name")){
                    drill = miningDrillService.findByName(command[3]);
                }
                else if(Objects.equals(command[2], "size")){
                    drill = miningDrillService.findBySize(Integer.parseInt(command[3]));
                }
                else{
                    System.out.println("Wrong name of a field.");
                }
                if(drill.isPresent()){
                    System.out.println("deleting drill...");
                    miningDrillService.deleteMiningDrill(drill.get().getId());
                }
                else{
                    System.out.println("Couldn't find drill with given values.");
                }
            }
            else{
                System.out.println("Unknown name: " + command[1]);
            }
        }
        else{
            System.out.println("Invalid amount of arguments");
        }
    }

    private void unknownCommand(String[] command){
        String unknownPart = "";
        for (int i = 0; i < command.length; i++) {
            unknownPart += command[i];
            if(i < command.length-1){
                unknownPart += " ";
            }
        }

        System.out.println("Unknown command: \"" + unknownPart + "\"");
    }
}
