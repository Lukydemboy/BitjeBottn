package NardahSeller.States;

import NardahSeller.Constants;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;


public class State {
    Player player = Players.getLocal();
//
//    public static boolean nearBankArea() {
//        player.distance()
//    }

    public static boolean isInvEmpty() {
        return Inventory.isEmpty();
    }

    public static boolean invContainsTP() {
        return Inventory.contains(Constants.NARDAHTPID);
    }

    public static boolean invContainsItem(int id) {
        return Inventory.contains(id);
    }

    public static boolean invContainsSellItems(String itemStartString) {
        return Inventory.contains(x -> x.getName().startsWith(itemStartString));
    }

    public static boolean isInNardah() {
        return SceneObjects.getNearest(Constants.SCENENARDAHCART) != null;
    }


}
