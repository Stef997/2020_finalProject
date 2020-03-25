package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;

public class IOMenuHandler implements EventHandler<ActionEvent> {
    private IOMenu menu;
    public String currentFile;
    public IOMenuHandler(IOMenu menu){
        this.menu = menu;
    }
    @Override
    public void handle(ActionEvent e) {
        System.out.println(e.getSource());
        if(e.getSource() == menu.load){
            //load
            System.out.println("LOAD");
            File file = menu.fileChooser.showOpenDialog(menu.mainStage);
            if(file == null){
                System.out.println("NO FILE SELECTED");
            }else{
                currentFile = file.toString();
                try {
                    load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }else if(e.getSource().equals(menu.save)){
            //save
            try {
                save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    //Save Function
    private void save() throws IOException {
        FileWriter fileWriter = new FileWriter("saves/monsterSave.txt");

        fileWriter.append(menu.fightBox.monster.toString());
        fileWriter.append('\n');
        fileWriter.append(menu.fightBox.target.toString());

        fileWriter.flush();
        fileWriter.close();

        //write to a file

        //close writer
    }

    //Load Function
    private void load() throws IOException {
        int counter = 0;
        if(currentFile == null){
            return;
        }

        FileReader fileReader = new FileReader(currentFile);
        //read file get monster and target data
        String line = "";
        String data[] = {"nothing", "nothing", "nothing", "nothing", "nothing", "nothing", "nothing", "nothing", "nothing", "nothing", "nothing"};
        Monster m = null;
        Monster m2 = null;
        // "14" -> int 14
        try{
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null){

                data = line.split(", ");
                if(counter == 0){

                    String skills[] = {data[0], data[1], data[2], data[3]};
                    int skillDamage[] = {Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7])};
                    m = new Monster(skills, skillDamage, Integer.parseInt((data[10])), data[8], data[9]);

                }else if(counter == 1){
                    String skills[] = {data[0], data[1], data[2], data[3]};
                    int skillDamage[] = {Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7])};
                    m2 = new Monster(skills, skillDamage, Integer.parseInt((data[10])), data[8], data[9]);

                }else{
                    break;
                }
                counter++;
                //counter = counter + 1;



            }
            br.close();
            System.out.println(m.toString());
            System.out.println(m2.toString());
            fileReader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        //create new instance of fightbox
        FightBox newFightBox = new FightBox(m, m2);
        menu.setFightBox(newFightBox);

        //set IOMenu Fightbox -> new fightbox
        //need to update text and progress bar
    }
}
