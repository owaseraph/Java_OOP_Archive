class Circle{
    private int color;
    private float radius;
    private int[] planar_pos = new int[2];

    private static final int mask = 0xFF;

    public Circle(int color, float radius, int[]planar_pos){
        this.color = color;
        this.radius = radius;
        this.planar_pos[0]=planar_pos[0];
        this.planar_pos[1]=planar_pos[1];
    }

    //getters
    public int getColor(){
        return this.color;
    }
    public float getRadius(){
        return this.radius;
    }
    public int[] getPlanar_pos(){
        return this.planar_pos;
    }
    public int getX(){
        return this.planar_pos[0];
    }
    public int getY(){
        return this.planar_pos[1];
    }

    //setters
    public void setColor(int color){
        this.color=color;
    }
    public void setRadius(float radius){
        this.radius=radius;
    }
    public void setPlanar_pos(int[] x){
        System.arraycopy(x,0,this.planar_pos,0,2);
    }


    //color helpers
    public int getAlpha(){
        return (color>>24) & mask;
    }
    public int getRed(){
        return (color>>16) & mask;
    }
    public int getGreen(){
        return (color>>8) & mask;
    }
    public int getBlue(){
        return color & mask;
    }
    public String toString(){
        return String.format(
                "Center: (%d, %d), Radius(%f), Color ARGB(%d, %d, %d, %d)",
                getX(),getY(),radius,getAlpha(),getRed(),getGreen(),getBlue()
        );
    }
}