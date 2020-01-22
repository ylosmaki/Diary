package Topics;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Interface {

    private Scanner reader;
    private List<Topic> diary;

    public Interface() {
        this.reader = new Scanner(System.in);
        this.diary = new ArrayList<>();
    }

    public void start() {

        //on start, prints intro
        System.out.println("****Ohjeistusta, ja alustuskrääsää****");
        System.out.println("KOMENNOT:");
        System.out.println("Lisaa uusi aihe: " + "\"lisaa\"");
        System.out.println("Tulostaa aiheet: " + "\"tulosta\"");
        System.out.println("Poista aihe: " + "\"poista\"");
        System.out.println("Hae yksittäinen aihe: " + "\"hae\"");
        System.out.println("Lopeta ohjelma: " + "\"lopeta\"");


//tiedoston nimi, kannattaako lukea käyttäjältä ja pitäisi tarkistaa onko olemassa

//        while(true) {
//            System.out.print(">");
//            String command = this.reader.nextLine();

//            if (!"lopeta".equals(command)) {

/*                System.out.println("Anna tiedostonimi:");
                String filename = this.reader.nextLine();*/


        while(true) {
            System.out.println("Mitä haluat tehdä?");
            System.out.print(">");
            String command = this.reader.nextLine();

            if ("lopeta".equals(command)) {
                System.out.println("Kiva, kiitti, hei!");
                break;
            }

            switch (command) {
                case "lisaa":
                    diary.add(addTopic());
                    break;

                case "tulosta":
                    printTopics(diary);
                    break;

                case "hae":
                    getTopic(diary);
                    break;

                case "paivita":

                    updateTopic();
                    break;

                case "poista":
                    deleteTopic(diary);
                    break;

                default:
                    System.out.println("outo käsky");
                    break;

            }
        }



//tulostetaanko tiedostoon?

 /*           try {
                FileWriter writer = new FileWriter(filename, true);
                writer.write(id);
                writer.write(title);
                writer.write(description);
                writer.write(link);
                writer.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Virhe: tiedostoa ei löytynyt");
            } catch(IOException ex) {
                System.out.println("Virhe: muu virhe lukiessa");
            }

            System.out.println(todaystopic);

  */

    }


    public Topic addTopic() {
        System.out.print("Kirjoita aihe:");
        String title = this.reader.nextLine();

        System.out.print("Kirjoita kuvaus:");
        String description = this.reader.nextLine();

        System.out.print("Kirjoita linkki tm.:");
        String link = this.reader.nextLine();

        Topic problem = new Topic(title, description, link);
        return problem;
    }

    public void printTopics(List<Topic> list) {
        System.out.println("AIHEET:");
        for(Topic topic : list) {
            System.out.println(topic.getTitle());
        }
    }

    public void getTopic(List<Topic> list) {
        System.out.print("Hae aihetta: ");
        String name = this.reader.nextLine();
        for(Topic topic : list) {
            if(name.equals(topic.getTitle())) {
                System.out.println(topic);
            }
        }
    }

    public void updateTopic() {
        System.out.print("Minkä aiheen haluat päivittää: ");
        String tmp = reader.nextLine();

        for(Topic topic : this.diary) {
            if(tmp.equals(topic.getTitle())) {
                System.out.println("Minkä tiedon haluat päivittää?");
                System.out.print("(k = kuvaus, l = linkki, t = tehty/ei) ");
                String field = reader.nextLine();

                switch (field)  {
                    case "k" :
                        System.out.print("Anna uusi kuvaus: ");
                        String descr = reader.nextLine();
                        topic.setDescription(descr);
                        break;
                    case "l" :
                        System.out.print("Anna uusi linkki: ");
                        String link = reader.nextLine();
                        topic.setAdditionalSource(link);
                    case "t" :
                        System.out.print("Anna uusi status: ");
                        boolean status = Boolean.valueOf(reader.nextLine());
                        topic.setComplete(status);
                    default:
                        System.out.println("Outo komento");
                        break;
                }

            }
        }

    }

    public void deleteTopic(List<Topic> list) {
        System.out.print("Poistettava aihe: ");
        String name = this.reader.nextLine();

        Iterator<Topic> iter = list.iterator();
        for(; iter.hasNext() ;) {
            Topic tmp = iter.next();
            if(name.equals(tmp.getTitle())) {
                iter.remove();
            }
        }
    }


}
