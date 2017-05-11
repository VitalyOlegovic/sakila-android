package sakila_android.myapplication.actor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import sakila_android.delegate.ActorListDelegate;
import sakila_android.model.Actor;
import sakila_android.myapplication.R;

import java.io.Serializable;
import java.util.List;

public class ActorListActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.vitalij.myapplication.ActorListActivity.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_list);

        TableLayout layout = (TableLayout)findViewById(R.id.table);

        ActorListDelegate actorListDelegate = new ActorListDelegate();
        List<Actor> actorList = actorListDelegate.getActorList();
        for(Actor actor : actorList){
            addActor(actor, layout);
        }
    }

    private void addField(String value, TableRow tableRow){
        TextView textView = new TextView(getApplicationContext());
        textView.setText(value);
        textView.setTextColor(Color.BLACK);
        tableRow.addView(textView);
    }

    private void addModifyButton(final Actor actor, TableRow tableRow){
        Button button = new Button(getApplicationContext());
        button.setText(R.string.modify);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendMessage(actor);
            }
        });
        tableRow.addView(button);
    }

    public void sendMessage(Serializable message) {
        Intent intent = new Intent(this, EditActorActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void addActor(final Actor actor, TableLayout layout){
        TableRow tableRow = new TableRow(getApplicationContext());

        addField(actor.getFirstName(), tableRow);
        addField(actor.getLastName(), tableRow);
        addModifyButton(actor, tableRow);

        layout.addView(tableRow);

    }
}
