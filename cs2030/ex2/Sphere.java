class Sphere implements Shape2D {
           protected final double radius;
           Sphere(double r){
               this.radius = r;
           }
           public String toString(){
               return String.format("sphere [%.2f]", radius);
           }
           public double volume(){
               return (4.0/3.0)*Math.PI*Math.pow(radius, 3);
           }
       }
