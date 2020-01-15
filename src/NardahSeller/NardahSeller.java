package NardahSeller;

import NardahSeller.tasks.Banking;
import NardahSeller.tasks.Selling;
import NardahSeller.tasks.Walking;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.Task;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;

@ScriptMeta(developer = "De Bois", desc = "Selling Items in Nardah Platelegs Shop", name = "Nardah Seller")

public class NardahSeller extends TaskScript {

    //Tasks Dat de bot moet uitvoeren (loops)
    private static final Task[] TASKS = {new Banking(), new Walking(), new Selling()};

    @Override
    public void onStart() {
        submit(TASKS);
        Log.fine("Starting...");

//        startTime = System.currentTimeMillis();

    }
}
