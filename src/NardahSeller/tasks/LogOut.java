package NardahSeller.tasks;

import NardahSeller.States.State;
import org.rspeer.script.task.Task;

public class LogOut extends Task {
    @Override
    public boolean validate() {
        return State.hasHoppedAll();
    }

    @Override
    public int execute() {
//        TODO:: Uitloggen

        return 0;
    }
}
