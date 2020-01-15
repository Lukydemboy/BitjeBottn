package NardahSeller.tasks;

import NardahSeller.Constants;
import NardahSeller.States.State;
import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Npc;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.scene.Npcs;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;

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
        if (State.isShopOpen()) {
            InterfaceComponent shopInterface = Interfaces.getComponent(Constants.SHOPINTERFACEID, Constants.SHOPCHILDID);
            Log.info(shopInterface.getComponent(Constants.SHOPITEMSKIRT).getItemStackSize());
            Log.info(shopInterface.getComponent(Constants.SHOPITEMLEGS).getItemStackSize());
            Log.info(shopInterface.getComponent(Constants.SHOPITEMCHAIN).getItemStackSize());

//            shopInterface.getComponent(Constants.SHOPITEMCHAIN).item

        }
//
        return 1200;
    }
}
