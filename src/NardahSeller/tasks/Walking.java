package NardahSeller.tasks;

import NardahSeller.Constants;
import NardahSeller.States.SecureGenerator;
import NardahSeller.States.State;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;


public class Walking extends Task {
    @Override
    public boolean validate() {
        return (State.invContainsTP() && State.invContainsSellItems("Rune")  && SceneObjects.getNearest(Constants.SCENENARDAHCART) == null);
    }


    @Override
    public int execute() {

        Log.info("We zijn in Nardah");
        Log.info("Lopen...");

        while (!State.isAtShop()) {
            Movement.walkTo(Constants.NARDAHSHOP);
            State.action = "Walking to Shop";
            Time.sleepUntil(State::isAtShop, SecureGenerator.randomInt(1530, 1883));
        }

//        LEFT OFF:: - Lopen naar shop
//                   - Shop openen
//                   - Checken aan de hand van loop -> hoeveel items in shop
//                   - Berekenen hoeveel meer dan init amount
//                   - Max selling stack - init amount
//                   - Verkopen
//                   - Generate hopWorld (int)
//                   - Save vorige worlds in array -> if hopWorld in array generate nieuw hopWorld
//                   - Hoppen
//                   - Repeat last steps


        return 400;
    }
}
