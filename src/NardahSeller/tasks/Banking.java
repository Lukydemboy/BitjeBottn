package NardahSeller.tasks;

import NardahSeller.Constants;
import NardahSeller.States.SecureGenerator;
import NardahSeller.States.State;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;

public class Banking extends Task {

    @Override
    public boolean validate() {
        return (State.isInvEmpty() || !State.invContainsTP() || !State.invContainsSellItems("Rune"));
    }

    @Override
    public int execute() {
        if (!Bank.isOpen()) {
            Bank.open();
        } else {

//            LET OP !! Nardah TP voor withdrawmode = NOTE
//            Nardah TP kan niet van bank gehalen worden in NOTE MODE
//          Wanneer Nardah TP niet in Inventory --> van de bank halen
//          Wanneer niet in bank --> kopen
            if (!State.invContainsTP()) {
                if (Bank.contains(Constants.NARDAHTPID)) {
                    Bank.withdraw(Constants.NARDAHTPID, 1);
                    Time.sleep(SecureGenerator.randomInt(1328, 2237));

                }
                // TODO:: Wanneer er geen tps in bank zitten --> kopen
            }

//            Set Withdrawmode to NOTE
            if (!String.valueOf(Bank.getWithdrawMode()).equals("NOTE")) {
                Bank.setWithdrawMode(Bank.WithdrawMode.NOTE);
            }

//            Alle items die we moeten sellen van de bank halen
            for (int itemID : Constants.BANKITEMS) {

                if (Bank.contains(itemID)) {
                    Bank.withdrawAll(itemID);
                    Time.sleep(SecureGenerator.randomInt(1228, 2837));

                }
            }

            if (!State.invContainsItem(Constants.VARROCKTPID)) {
                if (Bank.contains(Constants.VARROCKTPID)) {
                    Bank.withdraw(Constants.VARROCKTPID, 1);
                    Time.sleep(SecureGenerator.randomInt(928, 1830));
                }
                // TODO:: Wanneer er geen tps in bank zitten --> kopen
            }

            Time.sleepUntil(State::invContainsTP, SecureGenerator.randomInt(1503, 3295));

            Bank.close();
            Time.sleep(SecureGenerator.randomInt(1503, 3295));

            if (Bank.isClosed()) {
                Inventory.getFirst(Constants.NARDAHTPID).click();

                Time.sleepUntil(State::isInNardah, SecureGenerator.randomInt(4500, 7401));
            }

        }

        return 1300;
    }
}
