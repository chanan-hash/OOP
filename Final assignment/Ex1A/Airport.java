package Ex1A;

/**
 * Like the Register system class ans we can use here the faced pattern, and singelton pattern
 */

public class Airport {
   private static Airport instance = new Airport();

   public Airport getInstace() {
      return instance;
   }
}