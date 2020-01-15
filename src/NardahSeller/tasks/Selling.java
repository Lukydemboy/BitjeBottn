package NardahSeller.tasks;

import NardahSeller.Constants;
import NardahSeller.States.State;
import org.rspeer.runetek.adapter.scene.Npc;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.scene.Npcs;
import org.rspeer.script.task.Task;

public class Selling extends Task {


    @Override
    public boolean validate() {
        return State.isAtShop() && State.seesMerchant();
    }

    @Override
    public int execute() {

        Npc merchant = Npcs.getNearest(Constants.MERCHANT);

        merchant.interact("Trade");

//        Time.sleepUntil(State::)
//    
        return 1200;
    }
}
