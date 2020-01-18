package NardahSeller.tasks;

import NardahSeller.Constants;
import NardahSeller.States.SecureGenerator;
import NardahSeller.States.State;
import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Npc;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.tab.Inventory;
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
        Log.fine("Starten met sellen...");
        InterfaceComponent shopInterface = Interfaces.getComponent(Constants.SHOPINTERFACEID, Constants.SHOPCHILDID);

        Npc merchant = Npcs.getNearest(Constants.MERCHANT);

        if (shopInterface == null) {
            Log.info("Open shop");
            merchant.interact("Trade");
        }

//        Time.sleepUntil(State::)
        if (State.isShopOpen()) {
            InterfaceComponent shopInvInterface = Interfaces.getComponent(Constants.SHOPINVINTERFACE, Constants.SHOPINVID);

            for (int itemID : Constants.SELLITEMS) {
                if (Inventory.contains(itemID)) {

//                Begint van 1 omdat index 0 geen item is in Shop
                    for (int t = 1; t <= Constants.SELLITEMS.length; t++) {
                        State.action = "Shop Checken...";
                        shopInterface = Interfaces.getComponent(Constants.SHOPINTERFACEID, Constants.SHOPCHILDID, t);

                        int shopItemID = shopInterface.getItemId();

//                  shopItemID met 1 verhogen omdat we noted items hebben, de shop heeft unnoted items
                        if ((shopItemID + 1) == itemID) {
                            if (shopInterface.getItemStackSize() < Constants.MAXSELLINGAMOUNT) {
                                int shopAmount = shopInterface.getItemStackSize();
                                int startStack = Inventory.getFirst(itemID).getStackSize();

                                int itemsInInv = (28 - Inventory.getFreeSlots());

                                InterfaceComponent invSlot = null;

                                for (int c = 0; c < itemsInInv; c++) {
                                    int compItemID = shopInvInterface.getComponent(c).getItemId();

                                    Log.info(compItemID);
                                    Log.info(itemID);

                                    if (compItemID != -1) {
                                        if (compItemID == itemID) {
                                            State.action = "Verkopen";
                                            invSlot = Interfaces.getComponent(Constants.SHOPINVINTERFACE, Constants.SHOPINVID, c);
                                            break;
                                        }
                                    }
                                }

                                for (int i = 0; i < (Constants.MAXSELLINGAMOUNT - shopAmount); i++) {
                                    if (invSlot != null) {
                                        invSlot.interact("Sell 1");
                                    }

//                                  TODO:: Sleep until currentstack < startStack
                                    Time.sleep(SecureGenerator.randomInt(1302, 1793));

                                }

                            }
//                            break;
                        }
                    }
                }
            }

            State.action = "Sleeping";
            Time.sleep(SecureGenerator.randomInt(1203, 2183));

            InterfaceComponent shopInterfaceClose = Interfaces.getComponent(Constants.SHOPINTERFACEID, Constants.SHOPCLOSECHILDID, Constants.SHOPCLOSECOMP);
            State.action = "Closing shop";

            shopInterfaceClose.interact("Close");


//            shopInterface.getComponent(Constants.SHOPITEMCHAIN).item
        }


//
        return 1200;
    }
}
