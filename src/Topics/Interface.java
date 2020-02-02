/*
 *stil needs a method (or a new class of methods) to write and read from a file
 *desperate need of cleaning, maybe streams or - as above - whole new class for method -collection
 *maybe some methods use same syntax -more and shorter methods?
 */

package Topics;

import java.util.Scanner;

public class Interface {

    private Scanner reader = new Scanner(System.in);
    private Diary diary = new Diary();

    public void start() {

        //on start, prints intro
        System.out.println("****Ohjeistusta, ja alustuskrääsää****");
        System.out.println("KOMENNOT:");
        System.out.println("Lisaa uusi aihe: " + "\"lisaa\"");
        System.out.println("Näytä kaikki aiheet: " + "\"aiheet\"");
        System.out.println("Poista aihe: " + "\"poista\"");
        System.out.println("Päivitä aihetta: " + "\"paivita\"");
        System.out.println("Tallenna tiedostoon: " + "\"tallenna\"");
        System.out.println("Hae yksittäinen aihe: " + "\"hae\"");
        System.out.println("Lopeta ohjelma: " + "\"lopeta\"");


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
                    addTopic();
                    break;

                case "aiheet":
                    if(this.diary.howManyTopics()==0) {
                        System.out.println("Päiväkirja on tyhjä.");
                    } else {
                        System.out.println("AIHEET:");
                        diary.printTopics();
                    }
                    break;

                case "hae":
                    System.out.print("Hae aihetta: ");
                    String name = this.reader.nextLine();
                    if(this.diary.containsTopic(name)) {
                        Topic topic = diary.getTopic(name);
                        System.out.println(topic);
                    } else {
                        System.out.println("Aihetta ei löydy.");
                    }
                    break;

                case "paivita":
                    updateTopic();
                    break;

                case "poista":
                    System.out.print("Poistettava aihe: ");
                    diary.deleteTopic(this.reader.nextLine());
                    break;

                case "tallenna":
                    System.out.print("Anna tiedoston nimi: ");
                    String fileName = this.reader.nextLine();

                    //fileName tarkistus, onko olemassa vaiko ei...

//tämä metodiksi diary -luokkaan???
/*                    try {
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

                    System.out.println(todaystopic);*/
                    System.out.println("Tallennettu tiedostoon: " + fileName);
                    break;

                default:
                    System.out.println("outo käsky");
                    break;

            }
        }
    }


    public void addTopic() {
        System.out.print("Kirjoita aihe:");
        String title = this.reader.nextLine();

        System.out.print("Kirjoita kuvaus:");
        String description = this.reader.nextLine();

        System.out.print("Kirjoita linkki tm.:");
        String link = this.reader.nextLine();

        diary.addToDiary(title, description, link);

    }

    public void updateTopic() {
        System.out.print("Minkä aiheen haluat päivittää: ");
        String update = this.reader.nextLine();
        Topic topic = diary.getTopic(update);

//tehty/ei ei vielä ehkä ymmärrä true/falsea
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
                break;
            case "t" :
                System.out.print("Anna uusi status: ");
                boolean status = Boolean.valueOf(reader.nextLine());
                topic.setComplete(status);
                break;
            default:
                System.out.println("Outo komento");
                break;
        }
    }


}
