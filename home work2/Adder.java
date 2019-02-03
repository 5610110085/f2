public class Adder{
        private double val;
        
        public Adder(){
            val = 0.0;
        }
        public void add(double v){
            val += v;
        }
        
        public void addFrom(Adder another){
            val += another.getVal();
        }
        
        public void setVal(double v){
            val = v;
        }

        public double getVal(){
            return val;
        }
        
        public void reset(){
            val = 0.0;
        }
}
