//this program was written by andrew sears
public abstract class salariedEmployee extends employee{
   public abstract int supervisor();
   public static float getGrossWeeklyPay(float salary){
      float pay = Float.valueOf(salary) / 52;
      return pay;
   }
   @Override
   public int salariedEmployee() {
   	// TODO Auto-generated method stub
      return 0;
   }
}