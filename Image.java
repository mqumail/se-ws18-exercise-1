
public class Image {
    public byte[] data;
    private int width;
    private int height;

    //Constructor of the image object
    public Image(int width, int height){
        //Create the array with the length according to the given Width and Height
        this.width = width;
        this.height = height;
        int arraySize = width * height * 3;
        data = new byte[arraySize];

        //Set the values of the byte  array to 00
        for(int i = 0; i < data.length; i++){
            data[i]=(byte)0x00;
        }
    }

    //Create getters
    public byte[] getData(){
      return this.data;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    //Create setters
    public void setData(byte[] updateData){
        this.data = updateData;
    }
    public void setWidth(int newWidth){
        this.width = newWidth;
    }
    public void setHeight(int newHeight){
        this.height = newHeight;
    }

    //Set method to insert values into the byte array
    //Make exceptions when the coordinates are too low to calculate regularly
    public void set(int x, int y, int val){
        int index;
        if(x == 0 && y == 0){
          index = 0;
        } else if(y == 0 && x != 0){
          index = x * 3;
        } else if(x == 0 && y != 0){
          index = x * (this.width * 3);
        } else{
          index = x * y;
        }

        //Set the values of the array by the given int value(val) shifting 8 bits from val value
        data[index] = (byte)(val >> 16);
        data[index+1] = (byte)(val >> 8);
        data[index+2] = (byte)(val >> 0);
    }

    public void write(String filename){}

}
