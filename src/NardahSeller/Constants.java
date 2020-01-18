package NardahSeller;

import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Npc;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.movement.position.Position;

import java.awt.geom.Area;

public class Constants {

//   SCENEOBJECTS
   public final static int SCENENARDAHCART      = 10457;

//   ITEM IDS
   public final static int NARDAHTPID           = 12402;
   public final static int VARROCKTPID          = 8007;
   public final static int[] BANKITEMS          = {1079, 1113, 1093};



   //   NOTED!!! items
   public final static int[] SELLITEMS          = {1080, 1114, 1094};
   public final static int SELLITEMSKIRT        = 1094;
   public final static int SELLITEMLEGS         = 1080;
   public final static int SELLITEMCHAIN        = 1114;

//   POSITIONS
   public static final Position NARDAHSHOP      = new Position(3407,2923);

//   NPCS
   public static final int MERCHANT             = 4754;


//   SHOP INTERFACE
   public final static int SHOPINTERFACEID      = 300;
   public final static int SHOPCHILDID          = 16;
   public final static int SHOPCLOSECHILDID     = 1;
   public final static int SHOPCLOSECOMP        = 11;

   public final static int SHOPINVINTERFACE     = 301;
   public final static int SHOPINVID            = 0;


   //   SELLING CONSTANTS
   public final static int MAXSELLINGAMOUNT     = 4;





}
