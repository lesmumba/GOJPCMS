public class Map{
    // instance variables - replace the example below with your own
    private float cords[];
    private String location, title, description;
    public static enum CORDS {
        LATTITUDE(0), LONGITUDE(1);
        private int value;

		private CORDS(int value) {
			this.value = value;
		}
    
    };    

    public Map(String location, float x_cord, float y_cord)
    {
        // initialise instance variables
        this.cords = new float[2];
        this.cords[CORDS.LATTITUDE.value] = x_cord;
        this.cords[CORDS.LONGITUDE.value] = y_cord;
        this.location = location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public void setTooltip(String title, String description){
        this.description = description;
        this.title = title;
    }
    
    public void setCords(float[] cords ){
        this.cords = cords;
    }
    
    public float getCord(CORDS cordinate){
        return this.cords[cordinate.value];
    }
    
    public void setCord(CORDS cordinate, float value){
        this.cords[cordinate.value] = value;
    }
    
    public void render_map(){
        /*
         * 
         * Additional function
         */
    }
}
