//this program was written by andrew sears
public abstract class supervisor extends salariedEmployee{
   public static float getGrossWeeklyPay(float salary, float bonus){
      float pay = Float.valueOf(salary) / 52 + Float.valueOf(bonus) / 52;
      return pay;
   }
   @Override
   public int supervisor() {
   	// TODO Auto-generated method stub
      return 0;
   }
}