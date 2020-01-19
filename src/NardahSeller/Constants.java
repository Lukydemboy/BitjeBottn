package NardahSeller;

import org.rspeer.runetek.api.movement.position.Position;

import java.util.ArrayList;
import java.util.List;

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


//   INTERFACES
   public final static int SHOPINTERFACEID      = 300;
   public final static int SHOPCHILDID          = 16;
   public final static int SHOPCLOSECHILDID     = 1;
   public final static int SHOPCLOSECOMP        = 11;

   public final static int SHOPINVINTERFACE     = 301;
   public final static int SHOPINVID            = 0;

   public final static int WORLDINTERFACEID     = 182;
   public final static int WORLDCHILDID         = 3;

   public final static int WSELECTINTERFACEID   = 69;
   public final static int WSELECTCHILD         = 0;


//   SELLING CONSTANTS
   public final static int MAXSELLINGAMOUNT     = 4;

//   WORLDS
   public final static int[] WORLDS             = {302, 303, 304, 305, 306, 307, 309, 310, 311, 312, 313, 314, 315, 317, 318, 319, 320, 321, 322, 323, 324,
                                                   327, 328, 329, 330, 331, 332, 333, 334, 336, 338, 339, 340, 341, 342, 343, 344, 346, 347, 348, 350, 351,
                                                   352, 354, 355, 356, 357, 358, 359, 360, 362, 365, 367, 368, 369, 370, 374, 375, 376, 377, 378, 386, 387,
                                                   388, 389, 390, 395, 421, 422, 424, 444, 445, 465, 466, 491, 492, 493, 494, 495, 496, 513, 514, 515, 516,
                                                   517, 518, 519, 520, 521, 522, 523, 524, 525};

   public static List<Integer> hoppedWorlds     = new ArrayList<Integer>(){
      {
         add(302);
      }
   };

   public static boolean inAndereSellingWorld          = false;
   public static int     slechteWereldStreak           = 0;

   public static int itemsVerkocht                     = 0;

   public static boolean hasSold                       = false;
   public static int totalSold                         = 0;


}