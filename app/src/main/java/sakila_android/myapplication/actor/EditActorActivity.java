package sakila_android.myapplication.actor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import sakila_android.model.Actor;
import sakila_android.myapplication.R;

public class EditActorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_actor);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Actor actor = (Actor) intent.getSerializableExtra(ActorListActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(actor.getFirstName() + " " + actor.getLastName());
    }
}
