package Topics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Diary {
    private List<Topic> diary;

    public Diary() {
        this.diary = new ArrayList<>();
    }

    public void addToDiary(String title, String description, String link) {
        Topic topic = new Topic(title, description, link);
        this.diary.add(topic);
    }

    public void printTopics() {
        for(Topic topic : this.diary) {
            System.out.println(topic.getTitle());
        }
    }

    public int howManyTopics() {
        return this.diary.size();
    }

    public boolean containsTopic(String name) {
        for(Topic topic : this.diary) {
            if(name.equals(topic.getTitle())) {
                return true;
            }
        }
        return false;
    }

    //if there is no such topic, returns -1 and the host method/class has to deal with it
    public Topic getTopic(String name) {
        Topic topic;
        int index = -1;
        for(Topic tmp : this.diary) {
            if(name.equals(tmp.getTitle())) {
                index = this.diary.indexOf(tmp);
            }
        }
        return this.diary.get(index);
    }

    public void deleteTopic(String name) {
        Iterator<Topic> iter = this.diary.iterator();
        for(; iter.hasNext() ;) {
            Topic tmp = iter.next();
            if(name.equals(tmp.getTitle())) {
                iter.remove();
            }
        }
    }


}
