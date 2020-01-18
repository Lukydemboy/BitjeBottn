package NardahSeller.States;

import NardahSeller.Constants;
import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Npcs;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;

import java.util.function.BooleanSupplier;

public class State {
    Player player = Players.getLocal();
//
//    public static boolean nearBankArea() {
//        player.distance()
//    }

    InterfaceComponent shopInterface = Interfaces.getComponent(Constants.SHOPINTERFACEID, Constants.SHOPCHILDID);


    public static String action = "None";

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

    public static boolean isAtShop() {
        return Constants.NARDAHSHOP.getPosition().distance(Players.getLocal()) < 4;
    }

    public static boolean seesMerchant() {
        return Npcs.getNearest(Constants.MERCHANT) != null ;
    }

    public static boolean isShopOpen() {
        return Interfaces.getComponent(Constants.SHOPINTERFACEID, Constants.SHOPCHILDID) != null ;
    }

    public static boolean isVerkocht(int startStack, int currentStack) {
        return (currentStack - startStack) < 0;
    }


}
