package NardahSeller.tasks;

import NardahSeller.Constants;
import NardahSeller.States.SecureGenerator;
import NardahSeller.States.State;
import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.WorldHopper;
import org.rspeer.runetek.api.component.tab.Tab;
import org.rspeer.runetek.api.component.tab.Tabs;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;

import static NardahSeller.Constants.WORLDS;
import static NardahSeller.Constants.hoppedWorlds;

public class Hopping extends Task {


    @Override
    public boolean validate() {
        return (State.isAtShop() && !State.isShopOpen() && Tabs.isOpen(Tab.LOGOUT));
    }

    @Override
    public int execute() {
        Constants.hasSold = false;
        Log.fine("Hopping...");

//        Interfaces voor log out
        InterfaceComponent worldSwitcher = Interfaces.getComponent(Constants.WORLDINTERFACEID, Constants.WORLDCHILDID);
        InterfaceComponent worldSelect   = Interfaces.getComponent(Constants.WSELECTINTERFACEID, Constants.WSELECTCHILD);

        if (Tabs.isOpen(Tab.LOGOUT) && worldSwitcher != null) {
            if (worldSwitcher.getMaterialId() == -1) {
                worldSwitcher.interact("World Switcher");

                Time.sleep(SecureGenerator.randomInt(1302, 1920));
            }
        }

        if (worldSelect != null) {
            String hoppingMethod = "";

//          Wanneer er minder dan 2 items verkocht zijn --> slechte wereld
            if (Constants.itemsVerkocht < 2) {
                Constants.slechteWereldStreak += 1;
            }

//            Wanneer 3 slechte werelden na elkaar --> Random hoppen
            if (Constants.slechteWereldStreak >= 3) {
                hoppingMethod = "Random";
                int hopWorld = SecureGenerator.randomInt(0, WORLDS.length);

                while (hoppedWorlds.contains(hopWorld)){
                    hopWorld = SecureGenerator.randomInt(0, WORLDS.length);
                }

                Constants.hoppedWorlds.add(hopWorld);
                WorldHopper.hopTo(hopWorld);
            } else {
//                Wanneer een goeie wereld ( meer dan 2 verkocht) Streak methode (vorige wereld + 1)
                hoppingMethod = "Streak";
//                TODO:: Volgende index array --> nu kan ie proberen hoppen naar free worlds (omdat wereld (ID) + 1 soms een free wereld is)
                WorldHopper.hopTo(Constants.hoppedWorlds.get(Constants.hoppedWorlds.size() - 1) + 1);
            }

            Log.fine("Overlopen werelden");
            Log.info(hoppedWorlds);
            Log.fine("Totaal items verkocht");
            Log.info(Constants.totalSold);
            Log.fine("Hopping method");
            Log.info(hoppingMethod);


        }

        return SecureGenerator.randomInt(1293, 1873);
    }
}
