package sakila_android.delegate;

import sakila_android.model.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorListDelegate {

    public List<Actor> getActorList(){
        List<Actor> actors = new ArrayList<>();
        Actor actor = new Actor("Mario","Rossi");
        actors.add(actor);
        Actor actor1 = new Actor("Luigi","Verdi");
        actors.add(actor1);
        return actors;
    }

}
